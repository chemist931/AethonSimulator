package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;
import java.util.Map;

public class WaterManagement implements DataExecutor
{
	private String valName;
	private Boolean bval;
	private Double dval;
	private String executeString;
	private String description;

	public WaterManagement()
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
