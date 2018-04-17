package noninstantiability;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NoninstantiabilityTest {

  @Test(expected = InvocationTargetException.class)
  public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<PrivateConstructor> constructor = PrivateConstructor.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    constructor.newInstance();
  }
}
