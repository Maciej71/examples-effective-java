package dependency_injection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierFactory {
  private Supplier<FirstName> firstNameSuplier = FirstName::new;
  private Supplier<LastName> lastNameSupplier = LastName::new;

  public List<String> createNames(int amount) {

    List<String> result = new ArrayList<>();

    IntStream.range(0, amount)
        .forEach(i -> result.add(create(firstNameSuplier) + " " + create(lastNameSupplier)));

    return result;
  }

  private String create(Supplier<? extends Name> nameFactory) {
    return nameFactory.get().getName();
  }
}
