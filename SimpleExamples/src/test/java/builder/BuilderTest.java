package builder;

import builder.ConcreteImpRequiredLvl.Builder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static builder.AbstractDeveloperBuilder.Skills;
import static builder.ConcreteImpRequiredLvl.Level;
import static org.junit.Assert.*;

public class BuilderTest {

  @Test
  public void SimpleBookInNumberTest() {
    final SimpleBookInNumbers fullBook =
        new SimpleBookInNumbers.Builder(300, 1996).chapters(12).rank(1).build();

    final SimpleBookInNumbers partBook = new SimpleBookInNumbers.Builder(300, 1996).rank(2).build();

    assertEquals(300, fullBook.getPages());
    assertEquals(1996, fullBook.getYear());
    assertEquals(12, fullBook.getChapters());
    assertEquals(1, fullBook.getRank());

    assertEquals(300, partBook.getPages());
    assertEquals(1996, partBook.getYear());
    assertEquals(0, partBook.getChapters());
    assertEquals(2, partBook.getRank());
  }

  @Test
  public void ConcreteImpRequiredLvlTest() {
    final ConcreteImpRequiredLvl concreteImpRequiredLvl =
        new Builder(Level.MID)
            .addSkill(Skills.JIT)
            .addSkill(Skills.GC)
            .addSkill(Skills.OOP)
            .addSkill(Skills.CONCURRENCY)
            .addSkill(Skills.PATTERNS)
            .build();

    final Set shouldBeEmpty =
        concreteImpRequiredLvl
            .skills
            .stream()
            .filter(
                s ->
                    !Skills.JIT.equals(s)
                        && !Skills.GC.equals(s)
                        && !Skills.OOP.equals(s)
                        && !Skills.PATTERNS.equals(s)
                        && !Skills.CONCURRENCY.equals(s))
            .collect(Collectors.toSet());

    assertTrue(shouldBeEmpty.isEmpty());
    assertEquals(Level.MID, concreteImpRequiredLvl.getLevel());
  }

  @Test
  public void concreteImpWithAdditionalParameter() {
    final ConcreteImpWithAdditionalParameter devWithEn =
        new ConcreteImpWithAdditionalParameter.Builder()
            .addSkill(Skills.DATA)
            .addSkill(Skills.COLLECTIONS)
            .addSkill(Skills.MEMORY)
            .englishSpeaking()
            .build();

    final ConcreteImpWithAdditionalParameter devWithoutEn =
        new ConcreteImpWithAdditionalParameter.Builder()
            .addSkill(Skills.DATA)
            .addSkill(Skills.COLLECTIONS)
            .addSkill(Skills.MEMORY)
            .build();

    final List<ConcreteImpWithAdditionalParameter> devs = Arrays.asList(devWithEn, devWithoutEn);

    devs.forEach(
        d ->
            assertTrue(
                d.skills
                    .stream()
                    .filter(
                        s ->
                            !Skills.DATA.equals(s)
                                && !Skills.COLLECTIONS.equals(s)
                                && !Skills.MEMORY.equals(s))
                    .collect(Collectors.toSet())
                    .isEmpty()));

    assertTrue(devWithEn.isEnglishSpeaking());
    assertFalse(devWithoutEn.isEnglishSpeaking());
  }
}
