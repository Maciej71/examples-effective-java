package dependency_injection;

import java.util.Arrays;
import java.util.List;

public class LastName extends Name {
  public List<String> lastNames = Arrays.asList("Lee", "Wayne", "Skywalker", "Shelby", "Anderson");

  @Override
  public String getName() {
    return super.pickName(lastNames);
  }
}
