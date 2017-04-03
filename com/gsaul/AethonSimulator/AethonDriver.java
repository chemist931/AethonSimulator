package gsaul.AethonSimulator;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.SplashScreen;

public class AethonDriver
{
    private static LifeSupport lsPane = new LifeSupport();
    private static LifeSupportAtmo lsAtPane = new LifeSupportAtmo();
    private static AttNav anPane = new AttNav();
    private static ElectricalSystems esPane = new ElectricalSystems();
    private static CargoStates csPane = new CargoStates();

    public static void main(String[] args) throws Exception
    {
        ControlService controller = new ControlService();
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);
        final SplashScreen splash = SplashScreen.getSplashScreen();
        Graphics2D g = splash.createGraphics();

        JFrame lsFrame = new JFrame();
        JFrame lsFrameAtmo = new JFrame();
        JFrame attFrame = new JFrame();
        JFrame esFrame = new JFrame();
        JFrame csFrame = new JFrame();

        lsFrame.setContentPane(lsPane);
        lsFrameAtmo.setContentPane(lsAtPane);
        attFrame.setContentPane(anPane);
        esFrame.setContentPane(esPane);
        csFrame.setContentPane(csPane);

        JFrame[] frameArray = new JFrame[] {lsFrame, lsFrameAtmo, attFrame, esFrame, csFrame};
        /*for(int a=0; a< frameArray.length; a++)
        {
            frameArray[a].setExtendedState(JFrame.MAXIMIZED_BOTH);
            frameArray[a].setUndecorated(true);
            frameArray[a].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameArray[a].setVisible(true);
        }*/

        for(int a=0; a<frameArray.length; a++)
        {
            frameArray[a].setSize(1280, 1024);
            frameArray[a].setUndecorated(true);
            frameArray[a].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameArray[a].setVisible(true);
        }
    }
}