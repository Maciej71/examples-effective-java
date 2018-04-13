package builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderTest {

  @Test
  public void simpleBookInNumberTest() {
    final SimpleBookInNumbers fullBook = new SimpleBookInNumbers.Builder(300, 1996)
        .chapters(12)
        .rank(1)
        .build();

    final SimpleBookInNumbers partBook = new SimpleBookInNumbers.Builder(300, 1996)
        .rank(2)
        .build();

      assertEquals(300, fullBook.getPages());
      assertEquals(1996, fullBook.getYear());
      assertEquals(12, fullBook.getChapters());
      assertEquals(1, fullBook.getRank());

      assertEquals(300, partBook.getPages());
      assertEquals(1996, partBook.getYear());
      assertEquals(0, partBook.getChapters());
      assertEquals(2, partBook.getRank());

  }
}
