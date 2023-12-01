package util;

import java.util.Collection;
import java.util.Objects;

public class CollectionUtil {
    public static Boolean isEmpty(Collection<?> collection){
        return Objects.isNull(collection) || collection.isEmpty();
    }
}
