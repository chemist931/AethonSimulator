package com.gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;

public class PropulsionSystems extends JPanel {
    public PropulsionSystems(FileSystem fs) {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel ps");
        add(test);
    }
}
