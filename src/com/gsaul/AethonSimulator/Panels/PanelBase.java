package com.gsaul.AethonSimulator.Panels;

import com.gsaul.AethonSimulator.DataExecutor;

import java.util.Map;

public interface PanelBase
{
	void updateVars(Map<String, DataExecutor> executorMap);
}
