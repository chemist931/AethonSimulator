package com.gsaul.AethonSimulator;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ControlPane extends JPanel {
    public ControlPane() {
        setLayout(new FlowLayout());
        JRadioButton b0 = new JRadioButton("Life Support");
        JRadioButton b1 = new JRadioButton("Navigation");
        JRadioButton b2 = new JRadioButton("Propulsion Systems");
        JRadioButton b3 = new JRadioButton("Electrical Systems");
        JRadioButton b4 = new JRadioButton("Cargo");

        b0.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });

        b1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });

        b2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });

        b3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });

        b4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });

        ButtonGroup sysgroup = new ButtonGroup();
        sysgroup.add(b0);
        sysgroup.add(b1);
        sysgroup.add(b2);
        sysgroup.add(b3);
        sysgroup.add(b4);

        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }

    public void updateVars() {
    }
}