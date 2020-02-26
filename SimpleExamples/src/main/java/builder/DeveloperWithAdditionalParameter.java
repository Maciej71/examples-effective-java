package builder;


public class DeveloperWithAdditionalParameter extends AbstractDeveloperBuilder {
  private final boolean englishSpeaking;

  private DeveloperWithAdditionalParameter(Builder builder) {
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
    public DeveloperWithAdditionalParameter build() {
      return new DeveloperWithAdditionalParameter(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
