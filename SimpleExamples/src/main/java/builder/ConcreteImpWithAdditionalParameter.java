package builder;


public class ConcreteImpWithAdditionalParameter extends AbstractDeveloperBuilder {
  private final boolean englishSpeaking;

  private ConcreteImpWithAdditionalParameter(Builder builder) {
    super(builder);
    englishSpeaking = builder.englishSpeaking;
  }

  public boolean isEnglishSpeaking() {
    return englishSpeaking;
  }

  public static class Builder extends AbstractDeveloperBuilder.Builder<Builder> {

    private boolean englishSpeaking = false;

    public Builder englishSpeaking() {
      englishSpeaking = true;
      return this;
    }

    @Override
    public ConcreteImpWithAdditionalParameter build() {
      return new ConcreteImpWithAdditionalParameter(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
