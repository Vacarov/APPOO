package com.database.data;

/**
 * Created by wergin on 15-Apr-17.
 */
public class RuleInput {
    public static int setRule(Enum<UserRule> userRuleEnum){
        RuleRepository ruleRepository = new RuleRepository();
        return ruleRepository.getIdByRule(userRuleEnum);
    }
}