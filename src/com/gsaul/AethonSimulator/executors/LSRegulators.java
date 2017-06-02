package com.gsaul.AethonSimulator.executors;

import com.gsaul.AethonSimulator.DataExecutor;
import java.util.Map;

public class LSRegulators implements DataExecutor
{
	private String valName;
	private double[] n2TanksPres;
	private double[] o2TanksPres;
	private double n2RegState;
	private double o2RegState;

	public double[] getN2TanksPres()
	{
		return n2TanksPres;
	}

	public double[] getO2TanksPres()
	{
		return o2TanksPres;
	}

	public double isN2RegState()
	{
		return n2RegState;
	}

	public double isO2RegState()
	{
		return o2RegState;
	}

	public String getValName()
	{
		return valName;
	}

	public LSRegulators()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}
}
