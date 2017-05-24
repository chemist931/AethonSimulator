package gsaul.AethonSimulator.executors;

import java.util.Map;

import gsaul.AethonSimulator.DataExecutor;

public class Reactor implements DataExecutor
{
	private String valName;
	private Boolean bval;
	private Double dval;
	private String executeString;
	private String description;

	public Reactor()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}

	public Object getVal()
	{
		if(bval!=null)
			return bval;
		else
			return dval;
	}

	public String getName()
	{
		return valName;
	}
}
