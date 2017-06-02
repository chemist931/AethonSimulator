package com.gsaul.AethonSimulator.executors;

import com.gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class RCS implements DataExecutor
{
	private String valName;
	private boolean thrusters[][] = new boolean[4][4]; //[blocks][individuals]
	private int state;
	public int PASSTHROUGH = 0;
	public int HEAT_ONLY = 1;
	public int HEAT_AND_ACCELERATE = 2;
	public int throttleLevel;

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
