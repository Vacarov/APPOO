package com.database.data.quiz.quiz;

import java.util.Map;

/**
 * Created by wergin on 08-May-17.
 */
public class RightVariant {
    public String getCheckedRightVariant(Map<Variant, String> map, Variant rightVariant){
        return map.get(map.containsKey(rightVariant));
    }
}
