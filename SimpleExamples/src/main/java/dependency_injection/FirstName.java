package dependency_injection;

import java.util.Arrays;

public class FirstName extends Name {
  @Override
  public String getName() {
    return super.pickName(Arrays.asList("Maciek", "Gosia", "Artek", "John", "Batman"));
  }
}
