package com.gsaul.AethonSimulator.panels;

import com.gsaul.AethonSimulator.DataExecutor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LifeSupportAtmo extends JPanel implements PanelBase
{
    public LifeSupportAtmo()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
    }
    public void updateVars(Map<String, DataExecutor> executorMap)
    {

    }
}
