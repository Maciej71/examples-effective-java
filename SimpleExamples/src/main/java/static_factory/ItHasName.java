package static_factory;

class ItHasName {
    static String nameOf(Object object) {
        return object.getClass().getSimpleName();
    }
}
