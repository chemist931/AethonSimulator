package com.gsaul.AethonSimulator.Panels;

import com.gsaul.AethonSimulator.DataExecutor;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Map;

public class LifeSupport extends JPanel implements PanelBase
{
    public LifeSupport()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
    }

    public void updateVars(Map<String, DataExecutor> executorMap)
    {

    }
}
