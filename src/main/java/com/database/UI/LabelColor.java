package com.database.UI;

import com.database.data.quiz.quiz.Quiz;
import com.database.data.quiz.quiz.Variant;

import java.util.Map;

/**
 * Created by wergin on 20-May-17.
 */
public class LabelColor {
    public String setColor(Map<Integer, Variant> map, Quiz quiz, Variant variant) {
        String color = null;
        if (map.get(quiz.getIdQuiz()).equals(variant)) {
            color = "btn-success";
        } else color = "btn-primary";
        return color;
    }

    public String setColorForRightResponse(Map<Integer, Variant> mapRightResponses, Quiz quiz, Variant variant) {
        String color = null;
        if (mapRightResponses.get(quiz.getIdQuiz()).equals(variant))
            color = "btn-success";
        return color;
    }

    public String setColorForWrongResponse(Map<Integer, Variant> mapWrongResponses, Quiz quiz, Variant variant) {
        String color = null;
        if (mapWrongResponses.get(quiz.getIdQuiz()).equals(variant)) {
            color = "btn-danger";
        } else color = "btn-primary";
        return color;
    }
}
