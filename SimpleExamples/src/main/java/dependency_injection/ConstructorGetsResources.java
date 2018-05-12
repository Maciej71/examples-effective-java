package dependency_injection;

import java.util.Objects;

public class ConstructorGetsResources {
  private final Resources resources;

  public ConstructorGetsResources(Resources resources) {
    this.resources = Objects.requireNonNull(resources);
  }

  public boolean isItMyName(String name) {
    return this.resources.name().equals(name);
  }
}
