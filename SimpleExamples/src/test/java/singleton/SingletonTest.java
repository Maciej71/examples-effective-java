package singleton;

import org.junit.Test;

import java.io.*;
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

  @Test
  public void singletonSerializationFlaw() {
    SerializationFlaw instanceOne = SerializationFlaw.getInstance();

    try {
      ObjectOutput output =
          new ObjectOutputStream(new FileOutputStream("serialSingletonNotSafe.txt"));
      output.writeObject(instanceOne);
      output.close();
      ObjectInput input = new ObjectInputStream(new FileInputStream("serialSingletonNotSafe.txt"));
      SerializationFlaw instanceTwo = (SerializationFlaw) input.readObject();

      assertNotSame(instanceOne, instanceTwo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void overcomeSerialization() {
    OvercomeSerialization instanceOne = OvercomeSerialization.getInstance();

    try {
      ObjectOutput output = new ObjectOutputStream(new FileOutputStream("serialSingletonSafe.txt"));
      output.writeObject(instanceOne);
      output.close();
      ObjectInput input = new ObjectInputStream(new FileInputStream("serialSingletonSafe.txt"));
      OvercomeSerialization instanceTwo = (OvercomeSerialization) input.readObject();

      assertSame(instanceOne, instanceTwo);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
