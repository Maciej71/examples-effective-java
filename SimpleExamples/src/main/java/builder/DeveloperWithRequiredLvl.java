package builder;

import java.util.Objects;

public class DeveloperWithRequiredLvl extends AbstractDeveloperBuilder {
  private final Level level;

  private DeveloperWithRequiredLvl(Builder builder) {
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
    public DeveloperWithRequiredLvl build() {
      return new DeveloperWithRequiredLvl(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
