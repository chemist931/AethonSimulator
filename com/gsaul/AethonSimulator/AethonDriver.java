package gsaul.AethonSimulator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class AethonDriver
{
    static ControlPane control = new ControlPane();

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Aethon Control Panel");
        frame.setSize(1366, 768);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(control);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("lib/icon.png").getImage());
        final ScheduledExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
        advancer.scheduleWithFixedDelay(new Runnable()
        {
            @Override
            public void run()
            {
                control.updateVars();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}

