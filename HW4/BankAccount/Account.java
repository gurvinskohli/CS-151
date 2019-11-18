package com.company;

public class Account {

    private int accountBalance = 50;

    public int showBalance() {

        return accountBalance;

    }

    public void drawn(int widrawAmmount) {

        accountBalance = accountBalance - widrawAmmount;

    }

}
