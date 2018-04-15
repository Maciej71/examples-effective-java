package singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertSame;

public class SingletonTest {

  @Test
  public void publicFinalFieldTest() {
    assertSame(PublicFinalField.INSTANCE, PublicFinalField.INSTANCE);
  }

  @Test
  public void publicFinalFieldReflectionTest()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException {
    PublicFinalField firstObject = PublicFinalField.INSTANCE;

    Constructor<PublicFinalField> constructor = PublicFinalField.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    PublicFinalField secondObject = constructor.newInstance();

    assertNotSame(firstObject, secondObject);
  }

  @Test
  public void staticFactoryTest() {
    assertSame(StaticFactory.getInstance(), StaticFactory.getInstance());
  }

  @Test
  public void staticFactoryReflectionTest()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException {
    StaticFactory firstObject = StaticFactory.getInstance();

    Constructor<StaticFactory> constructor = StaticFactory.class.getDeclaredConstructor();
    constructor.setAccessible(true);

    StaticFactory secondObject = constructor.newInstance();

    assertNotSame(firstObject, secondObject);
  }
}
