package org.aptech.t2303e.reflection.consts;

public enum StringSql {
    SELECT_CLAUSE("SELECT * FROM"),
    WHERE("WHERE"),
    EQUAL("="),
    SPACE(" "),
    QUESTION_MARK("?"),
    SEMI_COLON(";")
    ;
    public final String val;
    private  StringSql(String val) {
        this.val = val;
    }
}
