package com.gsaul.AethonSimulator.subobjects;

import javax.sound.sampled.AudioInputStream;

public class Warning
{
	public final int INFO = 0;
	public final int LOW_ATTENTION = 1;
	public final int MID_WARNING = 2;
	public final int HIGH_WARNING = 3;
	public final int HIGH_ERROR = 4;
	public final int FIRE = 5;
	public final int DEPRESS = 6;
	private String issuingPanel;
	private String name;
	private String reason;
	private String extraData;
	private int severity;
	private AudioInputStream stream;

	public String getIssuingPanel()
	{
		return issuingPanel;
	}

	public String getName()
	{
		return name;
	}

	public String getReason()
	{
		return reason;
	}

	public String getExtraData()
	{
		return extraData;
	}

	public int getSeverity()
	{
		return severity;
	}

	public AudioInputStream getStream()
	{
		return stream;
	}

	public Warning(String issuingPanel, String name, String reason, String extraData, int severity, AudioInputStream stream)
	{
		this.issuingPanel = issuingPanel;
		this.name = name;
		this.reason = reason;
		this.extraData = extraData;
		this.severity = severity;
		this.stream = stream;
	}
}
