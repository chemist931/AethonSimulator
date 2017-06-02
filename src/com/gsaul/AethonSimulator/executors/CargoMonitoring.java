package com.gsaul.AethonSimulator.executors;

import com.gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class CargoMonitoring implements DataExecutor
{
	private String valName;
	@Override
	public void updateVars(Map<String, DataExecutor> map)
	{

	}

	@Override
	public String getValName()
	{
		return valName;
	}
}
