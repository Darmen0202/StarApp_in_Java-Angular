//package com.example.stars.components;
//
//
//import org.springframework.stereotype.Component;
//
//import javax.swing.*;
//import java.awt.*;
//
//@Component
//public class DiscovererPanel extends JPanel {
//    private JComboBox<Discoverer> discovererCombo = new JComboBox<>(Discoverer.values());
//    private JTextField newDiscovererField = new JTextField();
//
//    public DiscovererPanel() {
//        setLayout(new BorderLayout());
//        add(discovererCombo, BorderLayout.CENTER);
//        add(newDiscovererField, BorderLayout.EAST);
//    }
//
//    public Discoverer getSelectedDiscoverer() {
//        return (Discoverer) discovererCombo.getSelectedItem();
//    }
//
//    public String getNewDiscoverer() {
//        return newDiscovererField.getText().trim();
//    }
//
//    public void clearFields() {
//        discovererCombo.setSelectedIndex(0);
//        newDiscovererField.setText("");
//    }
//}
