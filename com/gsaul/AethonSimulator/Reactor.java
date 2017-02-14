package gsaul.AethonSimulator;

public class Reactor
{
    private double wasteHeat=0;
    private int myPercent=0;
    private double ECGen=0;

    Reactor(int nPercent)
    {
        myPercent=nPercent;
        ECGen=myPercent/100;
        wasteHeat=ECGen;
    }

    public double getHeat()
    {
        return wasteHeat;
    }

    public int getPercent()
    {
        return myPercent;
    }

    public double getEC()
    {
        return ECGen;
    }

    public void setPercent(int x)
    {
        myPercent=x;
        ECGen=x/100;
        wasteHeat=ECGen;
    }
}
