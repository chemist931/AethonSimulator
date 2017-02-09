package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;

class ElectricalSystems extends JPanel
{
    Reactor reactor=new Reactor();
    private double batt1Ah; //if reactor power doesn't cover all draw, remove from batts equally
    private double batt2ah;
    private double batt3ah;
    private double batt4ah;
    private double battTot; //Ah of all batteries total
    private final double battInMax=0; //Ah of individual battery maximum
    private final double battMax=0; //Ah of all batteries maximum
    private double wasteHeat; //waste reactor heat

    ElectricalSystems()
    {
        setLayout(new FlowLayout());
        JLabel test=new JLabel("JLabel es");
        add(test);
    }

    double getSOC()
    {
        return battMax-battTot;
    }

    public double getHeat()
    {
        return wasteHeat;
    }

    public void updateVars(double draw)
    {
        return;
    }

    //set reactor percent button/field
}
