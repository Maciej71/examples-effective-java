package avoid_unnecessary_objects;

import java.util.regex.Pattern;

public class ExpensiveObjects {
  private static final Pattern URL =
      Pattern.compile(
          "^(http|https|ftp):[/]{2}([a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,4})(:[0-9]+)?/?([a-zA-Z0-9\\-._?,'/\\\\+&amp;%$#=~]*)");

  static boolean expensiveUrlCheck(String address) {
    return address.matches(
        "^(http|https|ftp):[/]{2}([a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,4})(:[0-9]+)?/?([a-zA-Z0-9\\-._?,'/\\\\+&amp;%$#=~]*)");
  }

  static boolean moderateUrlCheck(String address) {
    return URL.matcher(address).matches();
  }
}
