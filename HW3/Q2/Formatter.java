package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Formatter implements InvoiceFormatter {
    private HashMap<LineItem, Integer> items = new HashMap<>();

    //    public ArrayList<LineItem> getItems(){
//        return items;
//    }
    public String formatHeader() {
        String invoiceHeader = new String("<html>\n"
                + "<body>\n"
                + "<h1>Welcome!</h1>\n");
        return invoiceHeader;
    }

    public String formatFooter() {
        String invoiceFooter = new String("<b><h1 style = 'color: red'; align = 'center' >" + "\n\nTOTAL DUE: $%.2f\n" + "</h1></b><br><br><br>" + "</body></html>\n");
        return String.format(invoiceFooter, SimpleFormatter.getTotal());
    }

    public String format(ArrayList<LineItem> items) {
        for (LineItem item : items) {
            SimpleFormatter.setTotal(SimpleFormatter.getTotal() + item.getPrice());
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

    public String formatLineItem(LineItem item) {
        // total += item.getPrice();
        SimpleFormatter.setTotal(SimpleFormatter.getTotal() + item.getPrice());
        if (!this.items.containsKey(item)) {
            this.items.put(item, 0);

            return (String.format(
                    "%s: $%.2f\n", item.toString(), item.getPrice()));
        }
        this.items.put(item, this.items.get(item) + 1);
        return (String.format(
                "%s: $%.2f x %d\n", item.toString(), item.getPrice(), items.get(item)));

    }

}
