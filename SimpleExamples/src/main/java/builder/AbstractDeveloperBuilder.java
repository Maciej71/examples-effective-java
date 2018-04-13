package builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractDeveloperBuilder {
  final Set<Skills> skills;

  AbstractDeveloperBuilder(Builder<?> builder) {
    skills = builder.skills.clone();
  }

  public enum Skills {
    GC,
    JIT,
    MEMORY,
    DATABASES,
    CONCURRENCY,
    DATA,
    COLLECTIONS,
    OOP,
    PATTERNS
  }

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Skills> skills = EnumSet.noneOf(Skills.class);

    public T addSkill(Skills skill) {
      skills.add(Objects.requireNonNull(skill));
      return self();
    }

    abstract AbstractDeveloperBuilder build();

    protected abstract T self();
  }
}
