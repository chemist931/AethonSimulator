package gsaul.AethonSimulator;

import javax.swing.*;

class ControlPane extends JPanel
{
    private LifeSupport ls = new LifeSupport();
    private AttNav an = new AttNav();
    private ElectricalSystems es = new ElectricalSystems();
    private CargoStates cs = new CargoStates();
    private Attitude currAtt;

    ControlPane()
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch(Exception e)
        {
            System.out.println("Look and Feel failed");
        }
        JTabbedPane tbp = new JTabbedPane();
        tbp.setTabPlacement(JTabbedPane.LEFT);

        tbp.addTab("Life Support", ls);
        tbp.addTab("Attitude/Navigation", an);
        tbp.addTab("Electrical Systems", es);
        tbp.addTab("Cargo States", cs);
        add(tbp);
    }

    void updateVars()
    {
        double soc=es.getSOC();
        ls.updateVars(soc);
        currAtt=an.updateVars(soc);
        cs.updateVars(soc);
        es.updateVars(ls.getDraw()+cs.getDraw()+an.getDraw());
    }
}