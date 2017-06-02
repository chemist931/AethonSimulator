package com.gsaul.AethonSimulator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio
{
	public static void soundOff(String sound)
	{
		try
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("lib/sounds/" + sound + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
