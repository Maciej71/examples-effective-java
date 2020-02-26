package builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeveloperWithRequiredLvlTest {

  @Test
  public void ConcreteImpRequiredLvlTest() {
    final var concreteImpRequiredLvl =
        new DeveloperWithRequiredLvl.Builder(DeveloperWithRequiredLvl.Level.MID)
            .addSkill(AbstractDeveloperBuilder.Skills.JIT)
            .addSkill(AbstractDeveloperBuilder.Skills.GC)
            .addSkill(AbstractDeveloperBuilder.Skills.OOP)
            .addSkill(AbstractDeveloperBuilder.Skills.CONCURRENCY)
            .addSkill(AbstractDeveloperBuilder.Skills.PATTERNS)
            .build();

    assertEquals(DeveloperWithRequiredLvl.Level.MID, concreteImpRequiredLvl.getLevel());
  }
}
