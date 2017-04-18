package com.database.data;

/**
 * Created by wergin on 08-Apr-17.
 */
public class DemoMain {
    public static void main(String[] args) {
        RuleRepository ruleRepository = new RuleRepository();
        RegistrationRepository registrationRepository = new RegistrationRepository();
        System.out.println(registrationRepository.findRuleIdById(2));
    }
}
