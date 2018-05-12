package dependency_injection;

import java.util.Arrays;
import java.util.List;

public class FirstName extends Name {
  public List<String> firstNames = Arrays.asList("Maciek", "Gosia", "Artek", "John", "Batman");

  @Override
  public String getName() {
    return super.pickName(firstNames);
  }
}
