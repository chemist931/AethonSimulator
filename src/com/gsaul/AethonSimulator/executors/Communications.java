package com.gsaul.AethonSimulator.executors;

import com.gsaul.AethonSimulator.DataExecutor;
import java.util.Map;

public class Communications implements DataExecutor
{
	private String valName;
	private boolean sBandDataXCV; //Transceivers ON/OFF
	private boolean sBandVoiceXCV;
	private boolean vhfDataXCV;
	private boolean vhfVoiceXCV;
	private boolean kuBandDataXCV;
	private boolean sBandDataXCVBack; //Backup transceivers ON/OFF
	private boolean sBandVoiceXCVBack;
	private boolean vhfDataXCVBack;
	private boolean vhfVoiceXCVBack;
	private boolean kuBandDataXCVBack;
	private boolean sBandMDM; //Data modems ON/OFF
	private boolean vhfMDM;
	private boolean kuBandMDM;
	private boolean sBandMDMBack; //Backup data modems ON/OFF
	private boolean vhfMDMBack;
	private boolean kuBandMDMBack;
	private boolean emergencyBeacon;

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
