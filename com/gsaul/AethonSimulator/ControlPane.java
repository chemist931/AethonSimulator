package com.gsaul.AethonSimulator;

import javax.swing.*;
import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class ControlPane extends JPanel {
    public ControlPane() {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path vars = fs.getPath("/vars");
        try {
            Files.createDirectory(vars);
        }
        catch(Exception e) {
            System.out.println("Files.createDirectory(vars) failed!");
        }

        JTabbedPane tbp = new JTabbedPane();
        tbp.setTabPlacement(JTabbedPane.RIGHT);
        LifeSupport ls = new LifeSupport(fs);
        AttNav an = new AttNav(fs);
        PropulsionSystems ps = new PropulsionSystems(fs);
        ElectricalSystems es = new ElectricalSystems(fs);
        CargoStates cs = new CargoStates(fs);
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