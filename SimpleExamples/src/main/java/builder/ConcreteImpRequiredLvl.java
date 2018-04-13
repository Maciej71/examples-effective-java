package builder;

import java.util.Objects;

public class ConcreteImpRequiredLvl extends AbstractDeveloperBuilder {
  private final Level level;

  private ConcreteImpRequiredLvl(Builder builder) {
    super(builder);
    level = builder.level;
  }

  public Level getLevel() {
    return level;
  }

  public enum Level {
    JUNIOR,
    MID,
    SENIOR
  }

  public static class Builder extends AbstractDeveloperBuilder.Builder<Builder> {
    private final Level level;

    public Builder(Level level) {
      this.level = Objects.requireNonNull(level);
    }

    @Override
    public ConcreteImpRequiredLvl build() {
      return new ConcreteImpRequiredLvl(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
