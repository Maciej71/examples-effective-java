package builder;

public class BookInNumbersWithInvariantsCheck {
  private final int pages;
  private final int year;
  private final int chapters;
  private final int rank;

  private BookInNumbersWithInvariantsCheck(Builder builder) {
    pages = builder.pages;
    year = builder.year;
    chapters = builder.chapters;
    rank = builder.rank;
  }

  public int getPages() {
    return pages;
  }

  public int getYear() {
    return year;
  }

  public int getChapters() {
    return chapters;
  }

  public int getRank() {
    return rank;
  }

  public static class Builder {
    private final int pages;
    private final int year;

    private int chapters = 0;
    private int rank = 0;

    public Builder(int pages, int year) {
      this.pages = pages;
      this.year = year;
    }

    public Builder chapters(int val) {
      chapters = val;
      return this;
    }

    public Builder rank(int val) {
      rank = val;
      return this;
    }

    public BookInNumbersWithInvariantsCheck build() {
      return new BookInNumbersWithInvariantsCheck(this);
    }
  }
}
