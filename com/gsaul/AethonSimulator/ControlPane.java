package gsaul.AethonSimulator;

import javax.swing.*;
public class ControlPane extends JPanel {
    private LifeSupport ls = new LifeSupport();
    private AttNav an = new AttNav();
    private PropulsionSystems ps = new PropulsionSystems();
    private ElectricalSystems es = new ElectricalSystems();
    private CargoStates cs = new CargoStates();

    public ControlPane() {
        JTabbedPane tbp = new JTabbedPane();
        tbp.setTabPlacement(JTabbedPane.LEFT);

        tbp.addTab("Life Support", ls);
        tbp.addTab("Attitude/Navigation", an);
        tbp.addTab("Propulsion Systems", ps);
        tbp.addTab("Electrical Systems", es);
        tbp.addTab("Cargo States", cs);
        add(tbp);
    }

    public void updateVars() {
        ls.updateVars(es.getSOC());
    }
}