package com.gsaul.AethonSimulator.panels;

import com.gsaul.AethonSimulator.DataExecutor;
import com.gsaul.AethonSimulator.executors.Reactor;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ElectricalSystems extends JPanel implements PanelBase
{
	private JLabel testButton;

	public ElectricalSystems()
	{
		setLayout(new GridLayout(10, 2));
		//setBackground(Color.DARK_GRAY.darker());
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