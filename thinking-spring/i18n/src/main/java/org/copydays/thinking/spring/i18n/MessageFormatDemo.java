package org.copydays.thinking.spring.i18n;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * {@link MessageFormat} 示例
 *
 * @author <a href="mailto:rmliumail@gmail.com">rmliu</a>
 * @since
 */
public class MessageFormatDemo {
    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";
        String pattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";

        MessageFormat messageFormat = new MessageFormat(pattern);

        String result = messageFormat.format(new Object[]{planet, new Date(), event});

        System.out.println(result);

        // 重置 MessageFormatPattern
        // applyPattern
        pattern = "This is a text: {0}, {1}, {2}";
        messageFormat.applyPattern(pattern);
        result = messageFormat.format(new Object[]{"hello rmliu!"});
        System.out.println(result);

        // 重置 Locale
        messageFormat.setLocale(Locale.CHINESE);

        pattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        messageFormat.applyPattern(pattern);
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);


        // 重置 Format
        messageFormat.setFormat(1, new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);
    }
}

