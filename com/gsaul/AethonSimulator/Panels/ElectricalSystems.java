package gsaul.AethonSimulator.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import gsaul.AethonSimulator.DataExecutor;
import gsaul.AethonSimulator.executors.*;
public class ElectricalSystems extends JPanel
{
	private JLabel testButton;
    public ElectricalSystems()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());

		testButton = new JLabel();
		testButton.setForeground(Color.WHITE.darker());
		add(testButton);
    }

    public void updateVars(Map<String, DataExecutor> executorMap)
    {
		testButton.setText("Test: " + ((Reactor) executorMap.get("Reactor")).getTemp());
    }
}
