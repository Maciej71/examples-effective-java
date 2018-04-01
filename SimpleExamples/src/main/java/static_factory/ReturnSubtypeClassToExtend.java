package static_factory;

import java.util.Arrays;
import java.util.stream.Collectors;

class ReturnSubtypeClassToExtend {
    private final int[] input;

    ReturnSubtypeClassToExtend(int[] input) {
        this.input = input;
    }

    Iterable<Integer> value() {
        return Arrays.stream(this.input).boxed().collect(Collectors.toList());
    }
}
