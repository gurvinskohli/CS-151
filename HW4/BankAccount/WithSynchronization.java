package com.company;

public class WithSynchronization implements Runnable {

    private Account account = new Account();

    public static void main(String[] args) {

        WithSynchronization wis = new WithSynchronization();

        Thread first = new Thread(wis);

        Thread second = new Thread(wis);

        first.setName("Gurvin");

        second.setName("Mathew");

        first.start();

        second.start();

    }


    public void run() {

        for (int num = 0; num < 5; num++) {

            makeTransfer(10);

            if (account.showBalance() < 0) {

                System.out.println("You dont have enough money in you account");

            }

        }

    }

    private synchronized void makeTransfer(int transferAmmount) {

        if (account.showBalance() >= transferAmmount) {

            System.out.println(Thread.currentThread().getName() + " is being removed from your bank account");

            try {

                Thread.sleep(100);

            } catch (InterruptedException ex) {

            }

            account.drawn(transferAmmount);

            System.out.println(Thread.currentThread().getName() + " widraw of money was sucessfull");

        } else {

            System.out.println(Thread.currentThread().getName() + " widraw money exceeds money in bank account = " + account.showBalance());

        }

    }

}
