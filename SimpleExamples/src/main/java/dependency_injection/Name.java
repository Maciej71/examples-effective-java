package dependency_injection;

import java.util.List;
import java.util.Random;

public class Name {
  public String getName() {
    return "Default Name";
  }

  public String pickName(final List<String> name) {
    return name.get(new Random().ints(1, 0, 4).sum());
  }
}
