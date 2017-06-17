package com.gsaul.AethonSimulator.panels;

import com.gsaul.AethonSimulator.DataExecutor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Map;

public class AttNav extends JPanel implements PanelBase
{
    private AttInd attInd;
    public AttNav()
    {
        //setLayout(new GridLayout(10, 2));
		setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY.darker());
        attInd = new AttInd();
        add(attInd, BorderLayout.CENTER);
    }

    public void updateVars(Map<String, DataExecutor> executorMap)
	{
		attInd.repaint();
		attInd.setPitchAngle(Math.random()*90);
		attInd.setRollAngle(Math.random()*90);
		attInd.setYawAngle(Math.random()*90);
    }
}