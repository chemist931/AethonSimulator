package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class MOF implements DataExecutor
{
	private String valName;
	private boolean state;
	private double temp;
	private int saturation;

	public MOF()
	{

	}

	public boolean isState()
	{
		return state;
	}

	public double getTemp()
	{
		return temp;
	}

	public int getSaturation()
	{
		return saturation;
	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}

	public String getValName()
	{
		return valName;
	}
}
