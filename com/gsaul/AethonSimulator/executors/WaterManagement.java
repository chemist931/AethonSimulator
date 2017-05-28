package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;
import java.util.Map;

public class WaterManagement implements DataExecutor
{
	private String valName;
	private double wasteTankLevel;
	private double pureTankLevel;
	private double urineTankLevel;
	private boolean ROFilterState;
	private boolean urineBoilState;
	private double urineBoilTemp;
	private boolean dumperState;

	public double getWasteTankLevel()
	{
		return wasteTankLevel;
	}

	public double getPureTankLevel()
	{
		return pureTankLevel;
	}

	public double getUrineTankLevel()
	{
		return urineTankLevel;
	}

	public boolean isROFilterState()
	{
		return ROFilterState;
	}

	public boolean isUrineBoilState()
	{
		return urineBoilState;
	}

	public double getUrineBoilTemp()
	{
		return urineBoilTemp;
	}

	public boolean isDumperState()
	{
		return dumperState;
	}

	public WaterManagement()
	{

	}

	public void updateVars(Map<String, DataExecutor> map)
	{

	}

	public String getValName()
	{
		return valName;
	}
}
