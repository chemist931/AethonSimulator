package gsaul.AethonSimulator.executors;

import java.util.Map;
import gsaul.AethonSimulator.DataExecutor;
import gsaul.AethonSimulator.Subobjects.Computer;

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
