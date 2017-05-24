package gsaul.AethonSimulator;

import java.util.Map;
class DataExecutor
{
	private String valName;
	private Boolean bval;
	private Double dval;
	private String executeString;
	private String description;

	DataExecutor()
	{
	}

	void updateVars(Map<String, DataExecutor> map)
	{

	}

	Object getVal()
	{
		if(bval != null)
			return bval;
		else
			return dval;
	}

	String getName()
	{
		return valName;
	}
}
