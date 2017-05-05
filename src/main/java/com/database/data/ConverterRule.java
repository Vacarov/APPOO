package com.database.data;

/**
 * Created by wergin on 30-Apr-17.
 */
public class ConverterRule {
    public Enum<UserRule> convertInEnumFromString(String nameRule){
        if (nameRule.toUpperCase().toString().equals(UserRule.ADMIN.toString())) return UserRule.ADMIN;
        else if (nameRule.toUpperCase().toString().equals(UserRule.STUDENT.toString())) return UserRule.STUDENT;
        else if (nameRule.toUpperCase().toString().equals(UserRule.TEACHER.toString())) return UserRule.TEACHER;
        else return UserRule.GUEST;
    }
}