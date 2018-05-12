package avoid_unnecessary_objects;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;

public class Immutable {
  public ImmutableList get() {
    return ImmutableList.copyOf(Arrays.asList("a", "c", "d", "b", "f", "g", "h"));
  }
}
