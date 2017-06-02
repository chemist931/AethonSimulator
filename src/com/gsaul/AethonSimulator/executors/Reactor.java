package com.gsaul.AethonSimulator.executors;

import java.util.Map;

import com.gsaul.AethonSimulator.DataExecutor;

public class Reactor implements DataExecutor
{
	private String valName;
	private int level; //0-100
	private double elecOut; //in kW
	private double temp; //in C
	private double coolantTemp; //in C
	private double coolantPres; //in PSI
	private double coolantLevel;
	private boolean ejected;
	private boolean breached;
	private boolean coolingBreached;
	private boolean autoEject;

	public Reactor()
	{
	}

	public void updateVars(Map<String, DataExecutor> map)
	{
		if(ejected)
			return;
		if(temp > 2000)
		{
			setLevel(level / 2);
			if(level < 0)
				setLevel(0);
		}
		if(temp > 2500)
		{
			if(autoEject)
			{
				setEjected();
				return;
			}
		}
		if(coolingBreached)
		{
			setCoolantLevel(coolantLevel - 15);
		}
		if(breached)
		{
			temp+=(2.5*level)+50;
		}
		temp+=5;
	}

	public int getLevel()
	{
		return level;
	}

	public double getElecOut()
	{
		return elecOut;
	}

	public double getTemp()
	{
		return temp;
	}

	public double getCoolantTemp()
	{
		return coolantTemp;
	}

	public double getCoolantPres()
	{
		return coolantPres;
	}

	public double getCoolantLevel()
	{
		return coolantLevel;
	}

	public boolean isEjected()
	{
		return ejected;
	}

	public boolean isBreached()
	{
		return breached;
	}

	public boolean isCoolingBreached()
	{
		return coolingBreached;
	}

	public void setEjected()
	{
		ejected = true;
		elecOut = 0;
		temp = 0;
		coolantTemp = 0;
		coolantPres = 0;
		level = 0;
	}

	public void setLevel(int a)
	{
		level = a;
		elecOut = a;
	}

	public void setCoolantLevel(double a)
	{
		coolantLevel = a;
	}

	public void setCoolingBreached()
	{
		coolingBreached = true;
	}
	public String getValName()
	{
		return valName;
	}


}
