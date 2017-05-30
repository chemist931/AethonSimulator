package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class HVAC implements DataExecutor
{
	private String valName;
	private boolean state;
	private double aim;
	private double coolingTemp;
	private double coolingPres;

	public boolean getState()
	{
		return state;
	}

	public double getAim()
	{
		return aim;
	}

	public double getCoolingTemp()
	{
		return coolingTemp;
	}

	public double getCoolingPres()
	{
		return coolingPres;
	}

	public HVAC()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}

	public String getValName()
	{
		return valName;
	}
}
