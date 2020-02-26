package builder;

import org.junit.Test;

import static builder.AbstractDeveloperBuilder.Skills;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeveloperWithAdditionalParameterTest {

  @Test
  public void concreteImpWithAdditionalParameter() {
    final var devWithEn = new DeveloperWithAdditionalParameter.Builder()
            .addSkill(Skills.DATA)
            .addSkill(Skills.COLLECTIONS)
            .addSkill(Skills.MEMORY)
            .englishSpeaking()
            .build();

    final var devWithoutEn = new DeveloperWithAdditionalParameter.Builder()
            .addSkill(Skills.DATA)
            .addSkill(Skills.COLLECTIONS)
            .addSkill(Skills.MEMORY)
            .build();

    assertTrue(devWithEn.isEnglishSpeaking());
    assertFalse(devWithoutEn.isEnglishSpeaking());
  }
}
