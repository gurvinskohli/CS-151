package com.company;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

/**
 * A program that tests the invoice classes.
 */
public class InvoiceTester {
    public static void main(String[] args) {
        final Invoice invoice = new Invoice();
        final InvoiceFormatter formatter = new Formatter();
        final Formatter format = new Formatter();
        final JEditorPane jEditorPane = new JEditorPane();
        final JScrollPane scrollPane = new JScrollPane(jEditorPane);
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane.setEditorKit(kit);
        // This text area will contain the formatted invoice
        final JTextArea textArea = new JTextArea(20, 40);

        // When the invoice changes, update the text area
        invoice.addChangeListener(event ->
                textArea.setText(invoice.format(formatter)));

        // Add line items to a combo box
        final JComboBox combo = new JComboBox();
        Product hammer = new Product("Hammer", 19.95);
        Product nails = new Product("Assorted nails", 9.95);
        combo.addItem(hammer);
        Bundle bundle = new Bundle();
        bundle.add(hammer);
        bundle.add(nails);
        combo.addItem(new DiscountedItem(bundle, 10));


        JButton addButton = new JButton("Add");
        addButton.addActionListener(event ->
        {
            LineItem item = (LineItem) combo.getSelectedItem();
            invoice.addItem(item);
        });

        JPanel panel = new JPanel();
        panel.add(combo);
        panel.add(addButton);

        ArrayList<LineItem> items = new ArrayList<LineItem>();
        Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        LineItem item = (LineItem) combo.getSelectedItem();
        jEditorPane.setText(formatter.formatHeader() + formatter.formatLineItem(item) + formatter.formatFooter() + formatter.format(items));

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(textArea),
                BorderLayout.CENTER);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setSize(new Dimension(700, 900));
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
