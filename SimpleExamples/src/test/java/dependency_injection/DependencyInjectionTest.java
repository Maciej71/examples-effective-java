package dependency_injection;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DependencyInjectionTest {

  @Test
  public void constructorGetsResourcesTest() {
    Resources resources = Resources.getInstance();
    assertTrue(new ConstructorGetsResources(resources).isItMyName("Maciek"));
    assertFalse(new ConstructorGetsResources(resources).isItMyName("Gosia"));
  }

  @Test
  public void supplierFactoryTest() {
    System.out.println(new SupplierFactory().createNames(2));//TODO create some reasonable test
  }
}
