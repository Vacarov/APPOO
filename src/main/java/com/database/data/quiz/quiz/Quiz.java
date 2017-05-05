package com.database.data.quiz.quiz;

/**
 * Created by wergin on 23-Apr-17.
 */
public class Quiz {
    private int idQuiz;
    private String question;
    private String variantA;
    private String variantB;
    private String variantC;
    private String variantD;
    private Variant rightVariant;

    public Quiz(int idQuiz, String question, String variantA, String variantB, String variantC, String variantD, Variant rightVariant) {
        this.idQuiz = idQuiz;
        this.question = question;
        this.variantA = variantA;
        this.variantB = variantB;
        this.variantC = variantC;
        this.variantD = variantD;
        this.rightVariant = rightVariant;
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

    public String getVariantA() {
        return variantA;
    }

    public void setVariantA(String variantA) {
        this.variantA = variantA;
    }

    public String getVariantB() {
        return variantB;
    }

    public void setVariantB(String variantB) {
        this.variantB = variantB;
    }

    public String getVariantC() {
        return variantC;
    }

    public void setVariantC(String variantC) {
        this.variantC = variantC;
    }

    public String getVariantD() {
        return variantD;
    }

    public void setVariantD(String variantD) {
        this.variantD = variantD;
    }

    public Variant getRightVariant() {
        return rightVariant;
    }

    public void setRightVariant(Variant rightVariant) {
        this.rightVariant = rightVariant;
    }
}
