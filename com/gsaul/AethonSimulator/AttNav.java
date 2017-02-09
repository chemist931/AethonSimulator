package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class AttNav extends JPanel
{
    Bearing currBear=new Bearing();
    private double draw;

    public AttNav()
    {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel an");
        add(test);
    }

    Bearing updateVars(double soc, double kilometers)
    {
        return currBear;
    }

    public double getDraw()
    {
        return draw;
    }
}