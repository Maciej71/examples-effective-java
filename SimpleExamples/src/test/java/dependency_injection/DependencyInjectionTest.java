package dependency_injection;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
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
    List<String> names = new SupplierFactory().createNames(2);

    Set<String> first =
        names
            .stream()
            .map(n -> n.split("\\s+")[0])
            .collect(Collectors.toSet());

    Set<String> second =
        names
            .stream()
            .map(n -> n.split("\\s+")[1])
            .collect(Collectors.toSet());

    assertEquals(2, names.size());
    assertTrue(new FirstName().firstNames.containsAll(first));
    assertTrue(new LastName().lastNames.containsAll(second));
  }
}
