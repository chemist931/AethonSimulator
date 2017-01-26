package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LifeSupport extends JPanel
{
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
    private double ampDraw; //wattage draw
    private Object[] boolArr=new Object[]{inFans, 0.75, airFil, 1.25, coScrub, 1.5, oReg, 6, nReg, 6, tReg, 8, hReg, 3, oFans, 0.75, dOpen, 0.2, oProd, 25, ROFil, 9, uBoil, 20};

    LifeSupport()
    {
        setLayout(new GridLayout(10, 1));
        //check if save file exists
        Path oldSave=Paths.get("/var/ls/ls.json");
        Path masterKey=Paths.get("/var/ls/masterKey.json");
        if(!Files.exists(oldSave))
            readSaveIntoMemory(masterKey);
        else
            readSaveIntoMemory(oldSave);

        JButton inFBut=new JButton("Intake Fans: "+Boolean.toString(inFans));
        inFBut.setEnabled(false);
        JButton airFBut=new JButton("Air Filter: "+Boolean.toString(airFil));
        airFBut.setEnabled(false);
        JButton coSBut=new JButton("CO2 Scrubber: "+Boolean.toString(airFil));
        coSBut.setActionCommand("coScrub");
        JButton oRBut=new JButton("O2 Regulator: "+Boolean.toString(oReg));
        oRBut.setActionCommand("oReg");
        JButton nRBut=new JButton("N2 Regulator: "+Boolean.toString(nReg));
        nRBut.setActionCommand("nReg");
    }

    private static void readSaveIntoMemory(Path save)
    {

    }

    public double getDraw()
    {
        return ampDraw;
    }

    void updateVars(double soc)
    {
        ampDraw=0;
        if(soc<=0) //check for out of power
            turnAllOff();
        else
        {
            for(int a=0; a<boolArr.length; a+=2)
                if(Boolean.parseBoolean(boolArr[a].toString()))
                    ampDraw+=Double.parseDouble((String) boolArr[a+1]);
        }
        calcDraw(Draw.makeDrawArrayBool(boolArr));
    }

    private void turnAllOff()
    {
        inFans=false;
        airFil=false;
        coScrub=false;
        oReg=false;
        nReg=false;
        uBoil=false;
        tReg=false;
        oReg=false;
        oFans=false;
        oProd=false;
        ROFil=false;
        hReg=false;
        ampDraw=0;
    }

    private double calcDraw(Draw[] drawArr)
    {
        double ret=0;
        for(int a=0; a<drawArr.length; a++)
            ret+=drawArr[a].getDraw();
        return ret;
    }
}
