package com.company;

import java.util.*;
import javax.swing.event.*;

/**
 * An invoice for a sale, consisting of line items.
 */
public class Invoice {
    /**
     * Constructs a blank invoice.
     */
    public Invoice() {
        items = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     * Count number of items to display quantity
     */
    public int countItems(String itemName){
        int count = 0;
        for(LineItem item:items){
            if(item.getType().equals(itemName)){
                count++;
            }
        }
        return count;
    }

    /**
     * Adds an item to the invoice.
     *
     * @param item the item to add
     */
    public void addItem(LineItem item) {
        int count = 0;
        if (items.contains(item)) {
            count++;
        }
        items.add(item);
        // Notify all observers of the change to the invoice
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
    }

    /**
     * Adds a change listener to the invoice.
     *
     * @param listener the change listener to add
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Gets an iterator that iterates through the items.
     *
     * @return an iterator for the items
     */
    public Iterator<LineItem> getItems() {
        return new
                Iterator<LineItem>() {
                    public boolean hasNext() {
                        return current < items.size();
                    }

                    public LineItem next() {
                        return items.get(current++);
                    }

                    public void remove() {
                        items.remove(current--);
                    }

                    private int current = 0;
                };
    }

    public String format(InvoiceFormatter formatter) {

        int noOfHammers = countItems("Hammer");
        int noOfBundles = countItems("Discount");

        String head = formatter.formatHeader();
        Iterator<LineItem> iter = getItems();

        String r = "";
        r=formatter.format(items);

        return head+ r + formatter.formatFooter();
    }

    private ArrayList<LineItem> items;
    private ArrayList<ChangeListener> listeners;
}
