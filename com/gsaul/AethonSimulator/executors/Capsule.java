package gsaul.AethonSimulator.executors;

import gsaul.AethonSimulator.DataExecutor;
import java.util.HashMap;
import java.util.Map;

public class Capsule implements DataExecutor
{
	private String valName;
	private double temp;
	private double pres;
	private double o2PartPres;
	private double n2PartPres;
	private double co2PartPres;
	private int gCounter;

	public double getTemp()
	{
		return temp;
	}

	public double getPres()
	{
		return pres;
	}

	public double getO2PartPres()
	{
		return o2PartPres;
	}

	public double getN2PartPres()
	{
		return n2PartPres;
	}

	public double getCo2PartPres()
	{
		return co2PartPres;
	}

	public int getgCounter()
	{
		return gCounter;
	}

	public Capsule()
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