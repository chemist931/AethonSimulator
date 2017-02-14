package gsaul.AethonSimulator;

public class Attitude
{
    double x, y, z;

    public Attitude()
    {
        x=0;
        y=0;
        z=0;
    }

    public Attitude(double a, double b, double c)
    {
        x=a;
        y=b;
        z=c;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public void setX(double x)
    {
        this.x=x;
    }

    public void setY(double y)
    {
        this.y=y;
    }

    public void setZ(double z)
    {
        this.z=z;
    }

    public boolean equals(Attitude b)
    {
        return x==b.getX() && y==b.getY() && z==b.getZ();
    }

    public String toString()
    {
        return x+", "+y+", "+z;
    }
}
