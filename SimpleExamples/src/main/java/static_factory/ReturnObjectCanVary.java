package static_factory;

import java.util.EnumSet;

class ReturnObjectCanVary {
    static EnumSet valueOf(boolean regular) {
//        use of static factory in EnumSet itself
        return regular ? EnumSet.allOf(InputForEnumSet.regular.class): EnumSet.allOf(InputForEnumSet.jumbo.class);
    }
}
