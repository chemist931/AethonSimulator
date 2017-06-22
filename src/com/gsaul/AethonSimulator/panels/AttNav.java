package com.gsaul.AethonSimulator.panels;

import com.gsaul.AethonSimulator.DataExecutor;
import com.gsaul.AethonSimulator.executors.EphemerisMode;
import com.gsaul.AethonSimulator.executors.MasterMode;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;

public class AttNav extends JPanel implements PanelBase
{
	private double shiftedBy;

	private JLabel UTCTime = new JLabel();
	private JLabel inclinationLabel = new JLabel();
	private JLabel eccentricityLabel = new JLabel();
	public AttNav()
	{
		//setLayout(new GridLayout(10, 2));
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY.darker());
	   /* attInd = new AttInd();
        add(attInd, BorderLayout.CENTER);*/
	}

	public void updateVars(Map<String, DataExecutor> executorMap)
	{
		//System.out.println(em.getOrbit(shiftedBy));
		shiftedBy+=0.5;

		/*
		attInd.repaint();
		attInd.setPitchAngle(Math.random()*90);
		attInd.setRollAngle(Math.random()*90);
		attInd.setYawAngle(Math.random()*90);
		*/
	}
}