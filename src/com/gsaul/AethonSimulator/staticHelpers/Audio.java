package com.gsaul.AethonSimulator.staticHelpers;

import javax.sound.sampled.*;
import java.util.HashMap;
import java.util.Map;

public class Audio
{
	private static Map<AudioInputStream, Clip> map = new HashMap<>();
	public static void soundOff(AudioInputStream audioIn)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			map.put(audioIn, clip);
		}
		catch(Exception e)
		{
			System.out.println("Audio machine broke");
			e.printStackTrace();
		}
	}
	public static void soundKill(AudioInputStream stream)
	{
		Clip clip = map.get(stream);
		if(clip.isRunning())
		{
			clip.stop();
			map.remove(stream);
		}
	}
}