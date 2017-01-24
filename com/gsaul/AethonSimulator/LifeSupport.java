package gsaul.AethonSimulator;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LifeSupport extends JPanel {
    private boolean inFans; //intake fans on/off
    private boolean airFil; //air filter on/off
    private double airFilPres; //air filter pressure
    private boolean coScrub; //co2 scrubber on/off
    private double coScrubPres; //co2 scrubber pressure
    private boolean oReg; //o2 regulator on/off
    private double oRegPres; //o2 regulator pressure
    private double oTankPres; //o2 tank pressure
    private boolean nReg; //n2 regulator on/off
    private double nRegPres; //n2 regulator pressure
    private double nTankPres; //n2 tank pressure
    private boolean tReg; //heater on/off
    private double tRegTemp; //heater output temperature
    private boolean hReg; //humidity regulator on/off
    private boolean oFans; //output fans on/off
    private double dFill; //dumper fill level
    private boolean dOpen; //dumper open/closed
    private boolean oProd; //o2 producer on/off
    private double oProdCoTank; //o2 producer co2 tank pressure
    private double oProdOTank; //o2 producer o2 tank pressure
    private double oProdPres; //o2 producer chamber pressure
    private double oProdTemp; //o2 producer chamber temperature
    private double WWTankLev; //wastewater tank level
    private boolean ROFil; //RO filter on/off
    private double ROPres; //RO filter pressure
    private double pTankLev; //purewater tank level
    private boolean uBoil; //urine boiler on/off
    private double uTankLev; //urine tank level
    private double uBoilTemp; //urine boiler temperature
    private double uBoilPres; //urine boiler pressure
    private double capPres; //capsule pressure
    private double capTemp; //capsule temperature
    private double capHum; //capsule humidity
    private double wattDraw; //wattage draw
    private Object[] boolArr = new Object[]{inFans, 0.75, airFil, 5, coScrub, 5, oReg, 5, nReg, 5, tReg, 5, hReg, 5, oFans, 5, dOpen, 5, oProd, 5, ROFil, 5, uBoil, 5};

    LifeSupport() {
        JLabel test = new JLabel("JLabel ls");
        add(test);

        //check if save file exists
        Path oldSave = Paths.get("/var/ls/ls.json");
        Path masterKey = Paths.get("/var/ls/masterKey.json");
        if(!Files.exists(oldSave))
            readSaveIntoMemory(masterKey);
        else
            readSaveIntoMemory(oldSave);
    }

    private static void readSaveIntoMemory(Path save) {

    }

    public double getDraw() {
        return wattDraw;
    }

    void updateVars(double soc) {
        if(soc<0) { //check for out of power
            turnAllOff();
        }
        doDraw(Draw.makeDrawArray(boolArr));
    }

    private void turnAllOff() {
        inFans = false;
        airFil = false;
        coScrub = false;
        oReg = false;
        nReg = false;
        uBoil = false;
        tReg = false;
        oReg = false;
        oFans = false;
        oProd = false;
        ROFil = false;
        hReg = false;
        wattDraw = 0;
    }

    private void doDraw(Draw[] drawArr) {
    }
}
