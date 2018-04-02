package static_factory;

import java.util.Arrays;

import static java.lang.StrictMath.toIntExact;

class ReturnSubtype {
  static ReturnSubtypeClassToExtend returnSuitableType(int... numbers) {

    int listSize = toIntExact(Arrays.stream(numbers).count());
    int setSize = toIntExact(Arrays.stream(numbers).distinct().count());

    return setSize == listSize ? new ReturnSubtypeClassExtending(numbers) : new ReturnSubtypeClassToExtend(numbers);
  }
}
