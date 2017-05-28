package gsaul.AethonSimulator.executors;

import java.util.Map;
import gsaul.AethonSimulator.DataExecutor;

public class Reactor implements DataExecutor
{
	private String valName;
	private int level;
	private double elecOut;
	private double heatOut;
	private double coolingTemp;
	private double coolingPres;
	private boolean ejected;
	private boolean breached;
	private boolean coolingBreached;

	public Reactor()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{
		if(ejected)
			return;
	}

	public int getLevel()
	{
		return level;
	}

	public double getElecOut()
	{
		return elecOut;
	}

	public double getHeatOut()
	{
		return heatOut;
	}

	public double getCoolingTemp()
	{
		return coolingTemp;
	}

	public double getCoolingPres()
	{
		return coolingPres;
	}

	public boolean isEjected()
	{
		return ejected;
	}

	public boolean isBreached()
	{
		return breached;
	}

	public boolean isCoolingBreached()
	{
		return coolingBreached;
	}

	public String getValName()
	{
		return valName;
	}


}
