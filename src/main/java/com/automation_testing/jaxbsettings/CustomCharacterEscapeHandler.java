package com.automation_testing.jaxbsettings;


import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import java.io.IOException;
import java.io.Writer;

public class CustomCharacterEscapeHandler implements CharacterEscapeHandler {
    public CustomCharacterEscapeHandler() {
        super();
    }

    @Override
    public void escape(char[] chars, int i, int i1, boolean b, Writer writer) throws IOException {
        int limit = i + i1;
        for (int in = i; in < limit; in++) {
            char c = chars[i];
            if (c == '&' || c == '<' || c == '>' || c == '\'' || (c == '\"' && b)) {
                if (in != i)
                    writer.write(chars, i, in - i);
                in = in + 1;
                switch (chars[i]) {
                    case '&':
                        writer.write("&amp;");
                        break;
                    case '\n':
                        writer.write("&#xA;");
                        break;
                    case '<':
                        writer.write("&lt;");
                        break;
                    case '>':
                        writer.write("&gt;");
                        break;
                    case '\"':
                        writer.write("&quot;");
                        break;
                    case '\'':
                        writer.write("&apos;");
                        break;
                }
            }
        }

        if (i != limit)
            writer.write(chars, i, limit - i);
    }
}