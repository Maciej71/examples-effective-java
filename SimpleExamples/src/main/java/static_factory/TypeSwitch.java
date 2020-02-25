package static_factory;

class TypeSwitch {

  static Color switchColor(final AvailableColors color) {
    return color == AvailableColors.GREEN ? new Blue() : new Green();
  }

  enum AvailableColors {
    BLUE,
    GREEN
  }

  static class Color {}

  static class Green extends Color {}

  static class Blue extends Color {}
}
