package gsaul.AethonSimulator;

class Reactor
{
    private double heat=0;
    private int myPercent=0;
    private double ECGen=0;

    Reactor(int nPercent)
    {
        myPercent=nPercent;
        ECGen=myPercent/100;
        heat=ECGen;
    }

    double getHeat()
    {
        return heat;
    }

    int getPercent()
    {
        return myPercent;
    }

    double getEC()
    {
        return ECGen;
    }

    void setPercent(int x)
    {
        myPercent=x;
        ECGen=myPercent*100;
        heat=ECGen;
    }
}
