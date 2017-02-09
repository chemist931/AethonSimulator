package gsaul.AethonSimulator;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class ControlPane extends JPanel
{
    private LifeSupport ls = new LifeSupport();
    private AttNav an = new AttNav();
    private PropulsionSystems ps = new PropulsionSystems();
    private ElectricalSystems es = new ElectricalSystems();
    private CargoStates cs = new CargoStates();
    private Bearing currBear;

    ControlPane()
    {
        JTabbedPane tbp = new JTabbedPane();
        tbp.setTabPlacement(JTabbedPane.LEFT);

        tbp.addTab("Life Support", ls);
        tbp.addTab("Attitude/Navigation", an);
        tbp.addTab("Propulsion Systems", ps);
        tbp.addTab("Electrical Systems", es);
        tbp.addTab("Cargo States", cs);
        add(tbp);
    }

    void updateVars()
    {
        double soc=es.getSOC();
        ls.updateVars(soc);
        currBear=an.updateVars(soc, ps.updateVars(soc, es.getHeat()));
        cs.updateVars(soc);
        es.updateVars(ls.getDraw()+an.getDraw()+ps.getDraw()+cs.getDraw());
    }
}