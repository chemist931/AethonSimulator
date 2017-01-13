package com.gsaul.AethonSimulator;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AethonSimulator
{
   public static void main(String[] args)
   {
      final ScheduleExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
      advancer.scheduleWithFixedDelay(new Runnable()
         {
            @Override
            public void run()
            {
               update();
            }
         }, 0, 1, TimeUnit.SECONDS);   
   }
   
   public void update()
   {
      
   }
}