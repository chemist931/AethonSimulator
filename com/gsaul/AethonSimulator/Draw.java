package gsaul.AethonSimulator;

public class Draw
{
    private Object myObj;
    private double myDraw;

    public Draw(Object obj, double draw)
    {
        myObj = obj;
        if(Boolean.FALSE.equals(myObj))
            myDraw=0;
        else
            myDraw=draw;
    }

    double getDraw()
    {
        return myDraw;
    }

    public Object getObj()
    {
        return myObj;
    }

    static Draw[] makeDrawArrayBool(Object[] arr)
    {
        int a=0;
        int b=0;
        Draw[] ret=new Draw[arr.length/2];
        while(a<arr.length)
        {
            ret[b]=new Draw(arr[a], Double.parseDouble((String) arr[a+1]));
            a+=2;
            b++;
        }
        return ret;
    }

}