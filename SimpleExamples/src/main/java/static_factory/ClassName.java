package static_factory;

class ClassName {
  static String from(Object object) {
    return object.getClass().getSimpleName();
  }
}
