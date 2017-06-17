package com.gsaul.AethonSimulator;

import com.gsaul.AethonSimulator.subobjects.Warning;
import java.util.ArrayList;

public class WarningCollector
{
	private static ArrayList<Warning> warnings = new ArrayList<Warning>();

	public static void addWarning(Warning nWarning)
	{
		warnings.add(nWarning);
	}

	public static ArrayList<Warning> getWarnings()
	{
		return warnings;
	}
}
