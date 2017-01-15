package com.gsaul.AethonSimulator;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class AethonSimulator
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
      
      final ScheduledExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
      advancer.scheduleWithFixedDelay(new Runnable()
         {
            @Override
            public void run()
            {
               updateVars();
            }
         }, 0, 1, TimeUnit.SECONDS);   
   }
   
   public static void updateVars()
   {
      control.updateVars();
   }
}

class ControlPane extends JPanel
{
   public ControlPane()
   {
   }
   
   public BufferedImage updateVars()
   {
      return new BufferedImage(1, 1, 1);
   }
}