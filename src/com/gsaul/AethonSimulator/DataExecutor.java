package com.gsaul.AethonSimulator;

import java.util.Map;

public interface DataExecutor
{
	void updateVars(Map<String, DataExecutor> map);
	String getValName();
}