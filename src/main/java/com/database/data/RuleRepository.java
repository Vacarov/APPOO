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

    public int getIdByRule(Enum<UserRule> ruleEnum) {
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

    public String findNameById(int idRule){
        String name = null;
        try {
            Connection connection = ConnectionConfiguration.getDBConnection();
            Statement statement = connection.createStatement();
            String query = "select Name from Rule where idRule = " + idRule ;
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
}