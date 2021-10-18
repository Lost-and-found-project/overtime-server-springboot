package org.overtime.test;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ForteScarlet
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        String a = "Hello {}: {}";

        Pattern pattern = Pattern.compile("\\{}");

        int i = 0;
        Matcher matcher = pattern.matcher(a);
        System.out.println(a);

        MessageFormat format = new MessageFormat(a);
        System.out.println(format.format(new Object[]{"World!", 100}));

    }
}
