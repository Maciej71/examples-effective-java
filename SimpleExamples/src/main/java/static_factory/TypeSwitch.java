package static_factory;

class TypeSwitch {

  static Color switchColor(final AvaliableColors color) {
    return color == AvaliableColors.GREEN ? new Blue() : new Green();
  }

  enum AvaliableColors {
    BLUE,
    GREEN
  }

  static class Color {}

  static class Green extends Color {}

  static class Blue extends Color {}
}
