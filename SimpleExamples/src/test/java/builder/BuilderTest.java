package builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

  @Test
  public void SimpleBookInNumberTest() {
    final var pages = 300;
    final var year = 1996;
    final var fullChapters = 12;
    final var defaultChapters = 0;
    final var fullRank = 1;
    final var defaultRank = 0;

    final var fullBook =
        new BookInNumbersWithInvariantsCheck.Builder(pages, year)
            .chapters(fullChapters)
            .rank(fullRank)
            .build();

    final var partBook = new BookInNumbersWithInvariantsCheck.Builder(pages, year).build();

    assertEquals(pages, fullBook.getPages());
    assertEquals(year, fullBook.getYear());
    assertEquals(fullChapters, fullBook.getChapters());
    assertEquals(fullRank, fullBook.getRank());

    assertEquals(pages, partBook.getPages());
    assertEquals(year, partBook.getYear());
    assertEquals(defaultChapters, partBook.getChapters());
    assertEquals(defaultRank, partBook.getRank());
  }
}
