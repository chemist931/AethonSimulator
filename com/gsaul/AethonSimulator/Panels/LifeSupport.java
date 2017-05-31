package gsaul.AethonSimulator.Panels;

import gsaul.AethonSimulator.DataExecutor;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Map;

public class LifeSupport extends JPanel
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
