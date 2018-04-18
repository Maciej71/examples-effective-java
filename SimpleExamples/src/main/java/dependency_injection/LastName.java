package dependency_injection;

import java.util.Arrays;

public class LastName extends Name {
  @Override
  public String getName() {
    return super.pickName(Arrays.asList("Lee", "Wayne", "Skywalker", "Shelby", "Anderson"));
  }
}
