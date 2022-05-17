package com.automation_testing.allrequests.authorization;

import com.automation_testing.checks.Check;
import com.automation_testing.creatingxml.TagPOfUnivReq;
import com.automation_testing.creatingxml.UniversalRequestRootTag;
import com.automation_testing.parsingxml.UniversalResponseRootTag;
import com.automation_testing.post_request_pattern.Post;
import com.automation_testing.generalsettings.Settings;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AuthMacIp extends Post {

    public static UniversalResponseRootTag rootTag;

    @Override
    protected void checkTest() throws IOException {
        Check.checkCode200(codeStatusResponse, "AuthMacip");
    }

    @Override
    protected void createXmlBodyRequest() throws JAXBException {
        UniversalRequestRootTag authMacip = new UniversalRequestRootTag();
        TagPOfUnivReq tagP = new TagPOfUnivReq();
        List<TagPOfUnivReq> listP = new ArrayList<>();

        authMacip.setT("auth");
        authMacip.setC("");
        authMacip.setN("macip");
        authMacip.setV(3.0);
        authMacip.setS(AuthLogin.sessionID);

        tagP.setApc("25");
        tagP.setApv(Settings.APP_VERSION_NAME);
        tagP.setD("d8eb432fb028c2b3");
        tagP.setI("10.0.2.16");
        tagP.setM("");
        tagP.setModel("Intellij Idea");
        tagP.setOsv("Autotest");
        tagP.setOsvk("");
        tagP.setPn("com.bssys.mbcphone.gpbank");
        tagP.setSdkRSA("{&quot;HardwareID&quot;:&quot;4794dd04-73b1-4e7f-811c-8ff0f28ebce3&quot;,&quot;InstallationSource&quot;:&quot;&quot;,&quot;DeveloperTools&quot;:1,&quot;Displays&quot;:[{&quot;flags&quot;:131,&quot;name&quot;:&quot;Встроенный экран&quot;,&quot;logicalHeight&quot;:2280,&quot;state&quot;:2,&quot;displayId&quot;:0,&quot;logicalWidth&quot;:1080}],&quot;Languages&quot;:&quot;ru&quot;,&quot;Emulator&quot;:16,&quot;OS_ID&quot;:&quot;097e2a18390d44b4&quot;,&quot;SDK_VERSION&quot;:&quot;4.3.35&quot;,&quot;TIMESTAMP&quot;:1652780291434,&quot;AppKey&quot;:&quot;77059A0BCD67BB1D71B492EEACDA5C08&quot;,&quot;GooglePlayProtect&quot;:-1,&quot;HoursSinceAnyDeskInstall&quot;:-1,&quot;PhoneCallState&quot;:0,&quot;DeviceSystemVersion&quot;:&quot;12&quot;,&quot;RdpConnection&quot;:false,&quot;WiFiNetworksData&quot;:{&quot;BSSID&quot;:&quot;02:00:00:00:00:00&quot;,&quot;SSID&quot;:null,&quot;SignalStrength&quot;:-50},&quot;ScreenSize&quot;:&quot;1080x2148&quot;,&quot;DeviceModel&quot;:&quot;Google sdk_gphone64_x86_64&quot;,&quot;HoursSinceZoomInstall&quot;:-1,&quot;GeoLocationInfo&quot;:{&quot;Status&quot;:1},&quot;DeviceSystemName&quot;:&quot;Android&quot;,&quot;HoursSinceQSInstall&quot;:-1,&quot;Compromised&quot;:0,&quot;TimeZone&quot;:&quot;0.0&quot;,&quot;MultitaskingSupported&quot;:false,&quot;UnknownSources&quot;:-1,&quot;WiFiMacAddress&quot;:&quot;&quot;,&quot;DeviceName&quot;:&quot;sdk_gphone64_x86_64&quot;}");
        long time = System.currentTimeMillis();
        String currentTime = Long.toString(time);
        tagP.setTermsDate(currentTime);

        listP.add(tagP);
        authMacip.setListP(listP);

        marshalling(authMacip);
    }

    @Override
    public void run() throws JAXBException, IOException, InterruptedException {
        super.run();
        if (codeStatusResponse == 200) {
            rootTag = Post.rootTag;
        }
    }
}
