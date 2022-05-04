package com.automation_testing.allrequests.authorization.utils;

import org.apache.http.util.ByteArrayBuffer;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CryptoUtils {

    private static char[] chr64 = {
            'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K',
            'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V',
            'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '='};
    private static BigInteger I1 = new BigInteger("3637558868994798876882255374096734216320034497547548143517976981487292475507251166244237544011143424902947645839287662788002014962730934245661136675360227");
    private static BigInteger I2 = new BigInteger("49319126198309317910865929144251146028568244848844751825779007391902668915403");
    private static BigInteger I3 = new BigInteger("258484969564677506792243207977004864742570214912900365543069930421417661558087302064643247693146144791273023160087951601643285998184749084456255051377884");


    public static byte[] generateSignData(int version, String signType, String uid, String passKey, double signDate, String hashAlg, BigInteger rgInt, BigInteger sgInt, Cert cert) {

        ByteArrayBuffer buffer = new ByteArrayBuffer(1000);
// Версия.
        byte[] data = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(version).array();
        buffer.append(data, 0, data.length);

// Тип подписи.
        data = signType.getBytes(StandardCharsets.US_ASCII);
        buffer.append(data, 0, data.length);
        buffer.append(0);

// Uid.
        data = uid.getBytes(StandardCharsets.UTF_16LE);
        buffer.append(data, 0, data.length);
        buffer.append(0);
        buffer.append(0);

// PassKey
        data = passKey.getBytes(StandardCharsets.US_ASCII);
        buffer.append(data, 0, data.length);
        buffer.append(0);

// Текущая дата.
        data = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(signDate).array();
        buffer.append(data, 0, data.length);

// Алгоритм хэша
        data = hashAlg.getBytes(StandardCharsets.US_ASCII);
        buffer.append(data, 0, data.length);
        buffer.append(0);

// Сертификат.
        data = cert.toBase64();
        buffer.append(data, 0, data.length);
        buffer.append(0);

// rgInt.
        data = generateChr64(rgInt);
        buffer.append(data, 0, data.length);
        buffer.append(0);

// sgInt.
        data = generateChr64(sgInt);
        buffer.append(data, 0, data.length);
        buffer.append(0);

        return buffer.toByteArray();
    }

    public static Pair<BigInteger, BigInteger> generateSign(BigInteger privateKey, byte[] hash) {

        boolean isOK = false;
        BigInteger k, tmp1, tmp2, tmp3;
        BigInteger rgInt, sgInt;

        do {
// Создаем байтовый массив на [101, 191] элементов.
            byte[] kArray = new byte[101 + (int) Math.floor(Math.random() * 91)];

// Забиваем массив [0, 255] данными.
            for (int i = 0; i < kArray.length; i++) {
                kArray[i] = (byte) Math.floor(Math.random() * 256);
            }

            k = new BigInteger(kArray);

            tmp1 = I3.modPow(k, I1);
            rgInt = tmp1.mod(I2);

// Повторяем процесс, пока не сгенерится ненулевой rgInt.
            if (rgInt.compareTo(BigInteger.ZERO) != 0) {
                isOK = true;
            }

        } while (!isOK);

        tmp2 = new BigInteger(Hex.toHexString(hash), 16);
        tmp1 = tmp2.mod(I2);

        if (tmp1.compareTo(BigInteger.ZERO) == 0) {
            tmp2 = new BigInteger("1");
        }

        tmp1 = privateKey.multiply(rgInt).mod(I2);
        tmp3 = k.multiply(tmp2).mod(I2);

        sgInt = tmp1.add(tmp3).mod(I2);

        return new Pair<>(rgInt, sgInt);
    }

    public static byte[] generateHash(byte[] data, String uid, String passId, double signDate) {

        GOST3411Digest digest = new GOST3411Digest();
        byte[] retVal = new byte[digest.getDigestSize()];

        ByteArrayBuffer buffer = new ByteArrayBuffer(500);

        buffer.append(data, 0, data.length);

// Uid.
        data = uid.getBytes(StandardCharsets.UTF_16LE);
        buffer.append(data, 0, data.length);

// PassId
        data = passId.getBytes(StandardCharsets.US_ASCII);
        buffer.append(data, 0, data.length);

// Текущая дата.
        data = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(signDate).array();
        buffer.append(data, 0, data.length);

        data = buffer.toByteArray();

        digest.update(data, 0, data.length);
        digest.doFinal(retVal, 0);

        return retVal;
    }

    public static double getDelphiCurrentTime() {
        return System.currentTimeMillis() / 86400000.0 + 25569.0; // Делфёвое время от 1899г.
    }

    public static Pair<BigInteger, BigInteger> generateKeys(String value) {

        byte[] data = new byte[29];

        if (value == null || value.length() == 0) {
            value = " ";
        }


        for (int i = 0; i < data.length - 1; i++) {
            data[i] += value.charAt(i % value.length()) % 256;
        }

        data[data.length - 1] = (byte) value.length();

        BigInteger privateKey = new BigInteger(data);
        BigInteger publicKey = I3.modPow(privateKey, I1);
        return new Pair<>(privateKey, publicKey);
    }

    public static String generateSignForAuthCode(String authCode, // код числовой
                                                 String sessionId,
                                                 int signVersion, // атрибут h из предыдущего запроса
                                                 String profileUID, // атрибут u из предыдущего запроса
                                                 String pubKeyAlgorithm, // атрибут j из предыдущего запроса
                                                 String hashAlgorithm, // атрибут i из предыдущего запроса
                                                 long timeStart, // атрибут k из предыдущего запроса
                                                 long timeEnd, // атрибут l из предыдущего запроса
                                                 String phoneNumber, // атрибут a из предыдущего запроса
                                                 String codeID // атрибут b из предыдущего запроса
    ) {

        String sign = "";
        try {
// Приватный/Открытый ключи.
            Pair<BigInteger, BigInteger> privatePublicPair = generateKeys(authCode);
// Сертификат.
            Cert cert = new Cert(signVersion, profileUID, privatePublicPair.second,
                    pubKeyAlgorithm, timeStart, timeEnd);
            double signDate = getDelphiCurrentTime();
            String passKey = phoneNumber
                    .concat("|").concat(codeID);
// Хэш.
            byte[] hash = generateHash(sessionId.getBytes(), profileUID, passKey, signDate);
// rgInt/sgInt.
            Pair<BigInteger, BigInteger> rgsgPair = generateSign(privatePublicPair.first, hash);
// Подпись.
            String signType = "SMS";
            byte[] signedData = generateSignData(signVersion, signType,
                    profileUID, passKey, signDate, hashAlgorithm,
                    rgsgPair.first, rgsgPair.second, cert);

            sign = Base64.toBase64String(signedData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sign;
    }

    private static byte[] generateChr64(BigInteger bigInteger) {

        ByteArrayBuffer buffer = new ByteArrayBuffer(500);
        StringBuilder base2SBuffer1 = new StringBuilder(bigInteger.toString(2));
        int len;

        while (base2SBuffer1.length() % 8 > 0) {
            base2SBuffer1.insert(0, '0');
        }

        while (base2SBuffer1.length() % 6 > 0) {
            base2SBuffer1.append("0");
        }

        len = base2SBuffer1.length() / 6;

        for (int i = 0; i < len; i++) {
            buffer.append(chr64[Integer.parseInt(base2SBuffer1.substring(i * 6, i * 6 + 6), 2)]);
        }

        return buffer.toByteArray();
    }

    /**
     * Сертификат (информация об открытом ключе)
     */
    public static class Cert {

        private int mVersion;
        private String mUid;
        private String mPublicKeyAlg;
        private long mTimeStart;
        private long mTimeEnd;
        private BigInteger mPublicKey;

        public Cert(int version, String uid, BigInteger publicKey, String publicKeyAlg, long timeStart, long timeEnd) {
            mVersion = version;
            mUid = uid;
            mPublicKey = publicKey;
            mPublicKeyAlg = publicKeyAlg;
            mTimeStart = timeStart;
            mTimeEnd = timeEnd;
        }

        public byte[] toBase64() {
            return Base64.encode(toByteArray());
        }

        public String toBase64String() {
            return Base64.toBase64String(toByteArray());
        }

        private byte[] toByteArray() {

            ByteArrayBuffer buffer = new ByteArrayBuffer(500);
// Версия.
            byte[] data = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(mVersion).array();
            buffer.append(data, 0, data.length);

// Uid.
            data = mUid.getBytes(StandardCharsets.UTF_16LE);
            buffer.append(data, 0, data.length);
            buffer.append(0);
            buffer.append(0);

// Алгоритм хэша
            data = mPublicKeyAlg.getBytes(StandardCharsets.US_ASCII);
            buffer.append(data, 0, data.length);
            buffer.append(0);


            Calendar old = new GregorianCalendar(1, 0, 2);
            Calendar now = new GregorianCalendar();

// Дата начала.
            now.setTimeInMillis(mTimeStart);
            int daysStart = (int) ((now.getTime().getTime() - old.getTime().getTime()) / (1000 * 60 * 60 * 24));
            data = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(daysStart).array();
            buffer.append(data, 0, data.length);

// Дата конца.
            now.setTimeInMillis(mTimeEnd);
            int daysEnd = (int) ((now.getTime().getTime() - old.getTime().getTime()) / (1000 * 60 * 60 * 24));
            data = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(daysEnd).array();
            buffer.append(data, 0, data.length);

// publicKey.
            data = generateChr64(mPublicKey);

            buffer.append(data, 0, data.length);
            buffer.append(0);

            return buffer.toByteArray();
        }


    }

    public static class Pair<F, S> {
        public final F first;
        public final S second;

        /**
         * Constructor for a Pair.
         *
         * @param first  the first object in the Pair
         * @param second the second object in the pair
         */
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public static <A, B> Pair<A, B> create(A a, B b) {
            return new Pair<A, B>(a, b);
        }
    }
}
