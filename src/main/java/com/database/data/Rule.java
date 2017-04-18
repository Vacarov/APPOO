package com.database.data;

/**
 * Created by wergin on 25-Mar-17.
 */
public class Rule {
    private int idRule;
    private String name;

    public Rule(int idRule, String name) {
        this.idRule = idRule;
        this.name = name;
    }

    public int getIdRule() {
        return idRule;
    }

    public void setIdRule(int idRule) {
        this.idRule = idRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
