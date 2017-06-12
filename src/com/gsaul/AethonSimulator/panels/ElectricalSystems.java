package com.gsaul.AethonSimulator.panels;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import com.gsaul.AethonSimulator.DataExecutor;
import com.gsaul.AethonSimulator.executors.Reactor;

public class ElectricalSystems extends JPanel implements PanelBase
{
	private JLabel testButton;
    public ElectricalSystems()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
        setBackground(Color.RED.darker());

		testButton = new JLabel();
		testButton.setForeground(Color.WHITE.darker());
		add(testButton);
    }

    public void updateVars(Map<String, DataExecutor> executorMap)
    {
		testButton.setText("Test: " + ((Reactor) executorMap.get("Reactor")).getTemp());
    }
}
