package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public class RCS implements DataExecutor
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
