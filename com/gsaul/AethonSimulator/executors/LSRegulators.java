package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;
import java.util.Map;

public class LSRegulators implements DataExecutor
{
	private String valName;
	private double[] n2TanksPres;
	private double[] o2TanksPres;
	private boolean n2RegState;
	private boolean o2RegState;

	public double[] getN2TanksPres()
	{
		return n2TanksPres;
	}

	public double[] getO2TanksPres()
	{
		return o2TanksPres;
	}

	public boolean isN2RegState()
	{
		return n2RegState;
	}

	public boolean isO2RegState()
	{
		return o2RegState;
	}

	public String getValName()
	{
		return null;
	}

	public LSRegulators()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}
}
