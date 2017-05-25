package com.database.data.quiz.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wergin on 23-Apr-17.
 */
public class Quiz {
    private int idQuiz;
    private String question;
    private Map<Variant, String> variants;
    private Variant rightVariant;
    private int idTest;

    public Quiz(int idQuiz, String question, Map<Variant, String> variants, Variant rightVariant, int idTest) {
        this.idQuiz = idQuiz;
        this.question = question;
        this.variants = variants;
        this.rightVariant = rightVariant;
        this.idTest = idTest;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Variant, String> getVariants() {
        return variants;
    }

    public void setVariants(Map<Variant, String> variants) {
        this.variants = variants;
    }

    public Variant getRightVariant() {
        return rightVariant;
    }

    public void setRightVariant(Variant rightVariant) {
        this.rightVariant = rightVariant;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
}