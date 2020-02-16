package static_factory;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class InstanceFactoryTest {
  @Test
  public void getSingletonInstance_Should_ReturnSameInstance() {
    assertTrue(InstanceFactory.getSingletonInstance() == InstanceFactory.getSingletonInstance());
  }

  @Test
  public void getNewObject_Should_ReturnDifferentObject() {
    assertTrue(InstanceFactory.getNewObject() != InstanceFactory.getNewObject());
  }
}
