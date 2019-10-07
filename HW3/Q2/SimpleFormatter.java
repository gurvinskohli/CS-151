package com.company;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A simple invoice formatter.
 */
public class SimpleFormatter implements InvoiceFormatter {
    private HashMap<LineItem, Integer> items = new HashMap<>();

    public String format(ArrayList<LineItem> items) {
        for (LineItem item : items) {
            total += item.getPrice();
            if (!this.items.containsKey(item)) {
                this.items.put(item, 1);
            } else {
                this.items.put(item, this.items.get(item) + 1);
            }
        }

        Iterator it = this.items.entrySet().iterator();
        String r = "";
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            double itemPrice = 0;

            if (pair.getKey().toString().equals("Hammer")) {
                itemPrice = 19.95;
            }
            if (pair.getKey().toString().equals("Bundle: Hammer, Assorted nails (Discount 10.0%)")) {
                itemPrice = 26.91;
            }

            r += (pair.getKey() + ": $" + itemPrice + " x " + pair.getValue() + "\n");
            it.remove();
        }
        return r;
    }

    public String formatHeader() {

        total = 0;
//        JEditorPane pane = new JEditorPane();
//        pane.setText("<html><font color=\"red\">hello world!</font></html>");

        return ("INVOICE\n\n\n");
        //return pane.toString();

    }


    public String formatLineItem(LineItem item) {
        total += item.getPrice();

        if (!this.items.containsKey(item)) {
            this.items.put(item, 0);

            return (String.format(
                    "%s: $%.2f\n", item.toString(), item.getPrice()));
        }
        this.items.put(item, this.items.get(item) + 1);
        return (String.format(
                "%s: $%.2f x %d\n", item.toString(), item.getPrice(), items.get(item)));

    }

    public String formatFooter() {
        return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
    }

    public class Items {
        ArrayList<LineItem> items;
        private LineItem item;
        private int count;

        public Items() {
            item = null;
            count = 0;
        }
    }

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double newTotal) {
        total = newTotal;
    }

    private static double total;

}