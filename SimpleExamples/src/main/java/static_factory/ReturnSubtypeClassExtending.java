package static_factory;

import java.util.Collection;
import java.util.HashSet;

class ReturnSubtypeClassExtending extends ReturnSubtypeClassToExtend {
    ReturnSubtypeClassExtending(int[] input) {
        super(input);
    }

    @Override
    Iterable<Integer> value() {
        return new HashSet<>((Collection<? extends Integer>) super.value());
    }
}
