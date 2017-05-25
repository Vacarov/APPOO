package com.database.data.quiz.quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wergin on 12-May-17.
 */
public class Answer {
    public Map<Integer, String> getQuizzesResult(Map<Integer, Variant> rightResponses, Map<Integer, Variant> answer) {
        Map<Integer, String> checkedQuizzes = new HashMap<Integer, String>();
        Set<Integer> set = rightResponses.keySet();
        String right = "RIGHT!";
        String wrong = "WRONG!";
        String noAnswer = "No Answer";
        for (Integer idQuiz : set) {
            if (answer.containsKey(idQuiz) == true) {
                if (rightResponses.get(idQuiz).equals(answer.get(idQuiz)) == true) {
                    checkedQuizzes.put(idQuiz, right);
                } else checkedQuizzes.put(idQuiz, wrong);
            } else checkedQuizzes.put(idQuiz, noAnswer);
        }
        return checkedQuizzes;
    }

    public Map<Integer, Variant> getRightQuizzesResult(Map<Integer, Variant> rightResponses,Map<Integer, Variant> answer) {
        Map<Integer, Variant> checkedQuizzes = new HashMap<Integer, Variant>();
        Set<Integer> set = answer.keySet();
        for (Integer idQuiz : set) {
            if (rightResponses.get(idQuiz).equals(answer.get(idQuiz)) == true)
                checkedQuizzes.put(idQuiz, answer.get(idQuiz));
        }
        return checkedQuizzes;
    }

    public Map<Integer, Variant> getWrongQuizzesResult(Map<Integer, Variant> rightResponses,Map<Integer, Variant> answer) {
        Map<Integer, Variant> checkedQuizzes = new HashMap<Integer, Variant>();
        Set<Integer> set = answer.keySet();
        for (Integer idQuiz : set) {
            if (rightResponses.get(idQuiz).equals(answer.get(idQuiz)) == false)
                checkedQuizzes.put(idQuiz, answer.get(idQuiz));
        }
        return checkedQuizzes;
    }

    public int countNumberOfRightResponse(Map<Integer, String> map) {
        int counter = 0;
        String right = "RIGHT!";
        Set<Integer> set = map.keySet();
        for (Integer item : set) {
            if (map.get(item).equals(right))
                counter++;
        }
        return counter;
    }

    public int countNumberOfWrongResponse(Map<Integer, String> map) {
        int counter = 0;
        String wrong = "WRONG!";
        Set<Integer> set = map.keySet();
        for (Integer item : set) {
            if (map.get(item).equals(wrong))
                counter++;
        }
        return counter;
    }

    public int countNumberOfNoAnswer(Map<Integer, String> map) {
        int counter = 0;
        String noAnswer = "No Answer";
        Set<Integer> set = map.keySet();
        for (Integer item : set) {
            if (map.get(item).equals(noAnswer))
                counter++;
        }
        return counter;
    }
}