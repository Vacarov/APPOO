package com.database.data;

import com.database.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wergin on 25-Mar-17.
 */
public class RuleRepository {
    public static List<Rule> getAllRules() {
        List<Rule> ruleList = new ArrayList<Rule>();
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select * from Rule";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idRule = resultSet.getInt("idRule");
                String name = resultSet.getString("name");
                Rule rule = new Rule(idRule, name);
                ruleList.add(rule);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return ruleList;
    }

    public int findIdByName(Enum<UserRule> ruleEnum) {
        int idRule = 0;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select idRule from Rule where NAME = '" + ruleEnum.name().toLowerCase() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                idRule = resultSet.getInt("idRule");
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return idRule;
    }

    public boolean isAdmin(int idRegistration) {
        boolean isAdmin = false;
        RegistrationRepository registrationRepository = new RegistrationRepository();
        if (registrationRepository.findRuleIdById(idRegistration) == 1) {
            isAdmin = true;
        }
        return isAdmin;
    }

    public boolean isStudent(int idRegistration) {
        boolean isStudent = false;
        RegistrationRepository registrationRepository = new RegistrationRepository();
        if (registrationRepository.findRuleIdById(idRegistration) == 2) {
            isStudent = true;
        }
        return isStudent;
    }

    public boolean isTeacher(int idRegistration) {
        boolean isTeacher = false;
        RegistrationRepository registrationRepository = new RegistrationRepository();
        if (registrationRepository.findRuleIdById(idRegistration) == 3) {
            isTeacher = true;
        }
        return isTeacher;
    }

    public boolean isGuest(int idRegistration) {
        boolean isGuest = false;
        RegistrationRepository registrationRepository = new RegistrationRepository();
        if (registrationRepository.findRuleIdById(idRegistration) == 4) {
            isGuest = true;
        }
        return isGuest;
    }

    public String findNameById(int idRule) {
        String name = null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Name from Rule where idRule = " + idRule;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                name = resultSet.getString("Name");
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public String findUserRule(String email) {
        RegistrationRepository registrationRepository = new RegistrationRepository();
        return registrationRepository.findRuleNameByIdRegistration(registrationRepository.findIdByEmail(email));
    }
}