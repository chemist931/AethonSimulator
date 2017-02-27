package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AethonDriver
{
    private static ControlPane control=new ControlPane();

    public static void main(String[] args)
    {
        final SplashScreen splash = SplashScreen.getSplashScreen();
        Graphics2D g = splash.createGraphics();
        JFrame frame = new JFrame("Aethon Control Panel");
        frame.setSize(1366, 768);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(control);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("lib/icon.png").getImage());
        final ScheduledExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
        advancer.scheduleWithFixedDelay(() -> control.updateVars(), 0, 1, TimeUnit.SECONDS);
    }
}

