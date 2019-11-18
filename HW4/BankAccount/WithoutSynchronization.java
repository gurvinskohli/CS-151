package com.company;


public class WithoutSynchronization implements Runnable {

    private Account account = new Account();

    public static void main(String[] args) {

        WithoutSynchronization ws = new WithoutSynchronization();

        Thread first = new Thread(ws);

        Thread second = new Thread(ws);

        first.setName("Gurvin");

        second.setName("Mathew");

        first.start();

        second.start();

    }


    public void run() {

        for (int num = 0; num < 5; num++) {

            makeTransfer(10);

            if (account.showBalance() < 0) {

                System.out.println("You do not have enough money in your account");

            }

        }

    }

    private void makeTransfer(int transferAmmount) {

        if (account.showBalance() >= transferAmmount) {

            System.out.println(Thread.currentThread().getName() + "just drew some money");

            try {

                Thread.sleep(100);

            } catch (InterruptedException ex) {

            }

            account.drawn(transferAmmount);

            System.out.println(Thread.currentThread().getName() + " widraw of money was sucessfull");

        } else {

            System.out.println(Thread.currentThread().getName() + " ammount cannot be drawn" + account.showBalance() + " this is your balance");

        }

    }

}
