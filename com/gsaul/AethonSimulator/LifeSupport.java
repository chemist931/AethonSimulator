package gsaul.AethonSimulator;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Map;

public class LifeSupport extends JPanel
{
    LifeSupport()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
    }

    void updateVars(Map<String, DataExecutor> executorMap)
    {

    }
}
