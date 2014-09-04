
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by test on 2014/8/29.
 */
public class test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(a(b*))*");
        String input = "seller1:activity1,seller2,seller3:activity2";
        String output = find(input);


    }

    public static String find(String input) {
        Pattern pattern = Pattern.compile("[^,]*");
        Matcher matcher = pattern.matcher(input);
        StringBuilder buffer = new StringBuilder();
        if (matcher.find()) {
            int n = matcher.groupCount();
            System.out.println(n);
            for (int i = 0; i <= n; i++) {
                System.out.println(matcher.group(i));
                buffer.append(matcher.group(i));
            }
        }
        return buffer.toString();
    }
}