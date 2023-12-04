package util;

import java.util.ArrayList;
import java.util.List;

public class Flat {
    public static List<Object> flat (List<Object> nestedList){
        if(CollectionUtil.isEmpty(nestedList)){
            return nestedList;
        }
        List<Object> flattenedList = new ArrayList<>();
        flatten(flattenedList, nestedList);
        return flattenedList;
    }
    @SuppressWarnings("unchecked")
    private static void flatten (List<Object> flattenedList, List<Object> obj){
        for (Object o : obj) {
            if(o instanceof List){
                flatten(flattenedList, (List<Object>) o);
            }else flattenedList.add(o);
        }
    }
}
