package com.gsaul.AethonSimulator;

import javax.swing.*;

public class ControlPane extends JPanel {
    public ControlPane() {
        JTabbedPane tbp = new JTabbedPane();
        tbp.setTabPlacement(JTabbedPane.RIGHT);
        LifeSupport ls = new LifeSupport();
        AttNav an = new AttNav();
        PropulsionSystems ps = new PropulsionSystems();
        ElectricalSystems es = new ElectricalSystems();
        CargoStates cs = new CargoStates();
        tbp.addTab("Life Support", ls);
        tbp.addTab("Attitude/Navigation", an);
        tbp.addTab("Propulsion Systems", ps);
        tbp.addTab("Electrical Systems", es);
        tbp.addTab("Cargo States", cs);
        add(tbp);
    }

    public void updateVars() {
        //subsystems.updateVars();
    }
}