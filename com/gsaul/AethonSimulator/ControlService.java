package gsaul.AethonSimulator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ControlService
{
    ControlService()
    {
        final ScheduledExecutorService advancer = Executors.newScheduledThreadPool(4);
        advancer.scheduleWithFixedDelay(ControlService::updateVars, 0, 125, TimeUnit.MILLISECONDS);
    }

    private static void updateVars()
    {
    }
}