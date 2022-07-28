package com.patrick.savingsApp.enumeration;

public enum Status {
   ACCOUNT_ACTIVE("ACCOUNT_ACTIVE"),
   ACCOUNT_CLOSE("ACCOUNT_CLOSE");

    private final String status;

    Status(String status){

        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
}
