package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;

public class AttNav extends JPanel
{
    private Attitude currBear=new Attitude();
    private double draw;

    public AttNav()
    {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel an");
        add(test);
    }

    Attitude updateVars(double soc)
    {
        return currBear;
    }

    double getDraw()
    {
        return draw;
    }
}