package com.gsaul.AethonSimulator.executors;

import java.util.Map;

import com.gsaul.AethonSimulator.DataExecutor;
import com.gsaul.AethonSimulator.subobjects.Computer;

public class Computers implements DataExecutor
{
	String valName;
	Computer[] computers = new Computer[5];
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
