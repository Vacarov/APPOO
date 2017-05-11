package com.database.data.quiz.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wergin on 08-May-17.
 */
public class VariantMapping {
    public Map<Variant,String> getVariants(String variantA, String variantB, String variantC, String variantD) {
        Map<Variant, String> map = new HashMap<Variant, String>();
        map.put(Variant.A, variantA);
        map.put(Variant.B, variantB);
        map.put(Variant.C, variantC);
        map.put(Variant.D, variantD);
        return map;
    }
}
