package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import gsaul.AethonSimulator.executors.*;
class ElectricalSystems extends JPanel
{
	private JLabel testButton;
    ElectricalSystems()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());

		testButton = new JLabel();
		testButton.setForeground(Color.WHITE.darker());
		add(testButton);
    }

    void updateVars(Map<String, DataExecutor> executorMap)
    {
		testButton.setText("Test: " + ((Reactor) executorMap.get("Reactor")).getTemp());
    }
}
