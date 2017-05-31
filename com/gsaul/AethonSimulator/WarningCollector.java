package gsaul.AethonSimulator;

import java.util.ArrayList;

public class WarningCollector
{
	private static ArrayList<String> warnings = new ArrayList<String>();

	public static void addWarning(String string)
	{
		warnings.add(string);
		String list = string.split(",")[1];
		switch(list)
		{
			case "URGENT": Audio.soundOff("urgent");
				break;
			case "WARNING": Audio.soundOff("warning");
				break;
			case "DEPRESS": Audio.soundOff("depress");
				break;
			case "FIRE": Audio.soundOff("fire");
				break;
			case "INFOWARNING": Audio.soundOff("infowarning");
				break;
			case "INFO": Audio.soundOff("info");
				break;
			default: System.out.println("Sound not available!");
		}
	}

	public static ArrayList<String> getWarnings()
	{
		return warnings;
	}
}
