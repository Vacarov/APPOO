package com.database.data.quiz.quiz;

/**
 * Created by wergin on 08-May-17.
 */
public class ConvertInEnumFrom {
    public static Variant convertInEnumFromString(String variant){
        if (variant.toUpperCase().toString().equals(Variant.A.toString())) return Variant.A;
        if (variant.toUpperCase().toString().equals(Variant.B.toString())) return Variant.B;
        if (variant.toUpperCase().toString().equals(Variant.C.toString())) return Variant.C;
        else return Variant.D;
    }
}
