package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class ServiceModule implements DataExecutor
{
	private String valName;
	private boolean docked;
	private double h2TankLevel;
	private double[] n2TankPres;
	private double[] o2TankPres;

	public boolean isDocked()
	{
		return docked;
	}

	public double getH2TankLevel()
	{
		return h2TankLevel;
	}

	public double[] getN2TankPres()
	{
		return n2TankPres;
	}

	public double[] getO2TankPres()
	{
		return o2TankPres;
	}

	public ServiceModule()
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
