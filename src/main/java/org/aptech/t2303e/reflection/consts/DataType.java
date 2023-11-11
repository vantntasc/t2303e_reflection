package org.aptech.t2303e.reflection.consts;

public enum DataType {
    VARCHAR("VARCHAR"),
    INT("INT")
    ;
    public final String val;
    private  DataType(String val) {
        this.val = val;
    }
}
