package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class HVAC implements DataExecutor
{
	private String valName;
	private double state;
	private double temperature;
	private double coolingTemp;
	private double coolingPres;

	public double getState()
	{
		return state;
	}

	public double getTemperature()
	{
		return temperature;
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
