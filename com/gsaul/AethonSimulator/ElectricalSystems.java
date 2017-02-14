package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;

class ElectricalSystems extends JPanel
{
    Reactor reactor=new Reactor(50);
    private double[] batts=new double[4];
    private double battTot; //Ah of all batteries total
    private final double battInMax=0; //Ah of individual battery maximum
    private final double battMax=0; //Ah of all batteries maximum

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

    void updateVars(double draw)
    {
        calcBattDelta(draw);
    }

    private double calcBattDelta(double draw)
    {
        double first=battTot;
        double net=(reactor.getEC()-draw)/batts.length;
        for(int a=0; a<batts.length; a++)
        {
            batts[a]+=net;
            if(batts[a]>battInMax)
                batts[a]=battInMax;
        }
        for(double batt : batts) battTot+=batt;

        return battTot-first;
    }
}
