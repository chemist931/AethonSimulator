package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;

public class PropulsionSystems extends JPanel
{
    private double draw;
    public PropulsionSystems()
    {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel ps");
        add(test);
    }

    public double updateVars(double soc, double heat)
    {
        return 555.555;
    }

    public double getDraw()
    {
        return draw;
    }
}
