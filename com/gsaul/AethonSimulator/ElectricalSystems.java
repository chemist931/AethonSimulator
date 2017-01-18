package com.gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;

public class ElectricalSystems extends JPanel {
    public ElectricalSystems(FileSystem fs) {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel es");
        add(test);
    }
}
