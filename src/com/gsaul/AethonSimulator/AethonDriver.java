package com.gsaul.AethonSimulator;

import com.gsaul.AethonSimulator.panels.*;
import com.gsaul.AethonSimulator.executors.*;
import com.gsaul.AethonSimulator.StaticHelpers.Audio;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.SplashScreen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class AethonDriver
{
	private static LifeSupport lsPane;
	private static LifeSupportAtmo lsAtPane;
	private static AttNav anPane;
	private static ElectricalSystems esPane;
	private static CargoStates csPane;
	private static WarningAnnunciator waPane;
	private static Map<String, DataExecutor> executorMap;
	private static PanelBase[] paneArray;
	private static DataExecutor[] executorArray;

	public static void main(String[] args)
	{
		final SplashScreen splash = SplashScreen.getSplashScreen();
		splash.createGraphics();

		executorMap = new HashMap<>();
		executorArray = objectBuilder();
		for(DataExecutor de : executorArray)
		{
			executorMap.put(de.getValName(), de);
		}
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);
		}
		catch(ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException e) //Damn this thing is dangerous
		{
			e.printStackTrace();
		}
		lsPane = new LifeSupport();
		lsAtPane = new LifeSupportAtmo();
		anPane = new AttNav();
		esPane = new ElectricalSystems();
		csPane = new CargoStates();
		waPane = new WarningAnnunciator();

		JFrame lsFrame = new JFrame();
		JFrame lsFrameAtmo = new JFrame();
		JFrame attFrame = new JFrame();
		JFrame esFrame = new JFrame();
		JFrame csFrame = new JFrame();
		JFrame waFrame = new JFrame();

		JFrame[] frameArray = new JFrame[]{lsFrame, lsFrameAtmo, attFrame, esFrame, csFrame, waFrame};
		paneArray = new PanelBase[]{lsPane, lsAtPane, anPane, esPane, csPane, waPane};

		for(int a = 0; a < frameArray.length; a++)
			frameArray[a].setContentPane((JPanel) paneArray[a]);

		/*for(int a=0; a< frameArray.length; a++)
		{y
            frameArray[a].setExtendedState(JFrame.MAXIMIZED_BOTH);
            frameArray[a].setUndecorated(true);
            frameArray[a].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameArray[a].setVisible(true);
        }*/

		for(JFrame aFrameArray : frameArray)
		{
			aFrameArray.setSize(1280, 1024);
			aFrameArray.setUndecorated(true);
			aFrameArray.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			aFrameArray.setVisible(true);
		}

		waFrame.setAlwaysOnTop(true);
		waFrame.requestFocus();
		final ScheduledExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
		advancer.scheduleWithFixedDelay(AethonDriver:: updateVars, 250, 250, TimeUnit.MILLISECONDS);

		waFrame.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				keyDown(e);
			}
		});

		try
		{
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/info.wav")));
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/urgent.wav")));
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/warning.wav")));
		}
		catch(IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
	}

	private static void updateVars()
	{
		for(PanelBase jp : paneArray)
			jp.updateVars(executorMap);
		for(DataExecutor de : executorMap.values())
			de.updateVars(executorMap);
	}

	private static DataExecutor[] objectBuilder() //Thank you StackOverflow user "perception"
	{
		try
		{
			String uInput = JOptionPane.showInputDialog("Save file name?");
			if(uInput == null)
				uInput = "defaults";
			RuntimeTypeAdapterFactory<DataExecutor> typeFactory = RuntimeTypeAdapterFactory
					.of(DataExecutor.class, "type")
					.registerSubtype(Capsule.class, "Capsule")
					.registerSubtype(HVAC.class, "HVAC")
					.registerSubtype(LSRegulators.class, "LSRegulators")
					.registerSubtype(MOF.class, "MOF")
					.registerSubtype(Reactor.class, "Reactor")
					.registerSubtype(ServiceModule.class, "ServiceModule")
					.registerSubtype(WaterManagement.class, "WaterManagement")
					.registerSubtype(OrbitalMechanics.class, "OrbitalMechanics")
					.registerSubtype(Communications.class, "Communications")
					.registerSubtype(RCS.class, "RCS")
					.registerSubtype(CargoMonitoring.class, "CargoMonitoring")    //This whole thing is disgusting but I
					.registerSubtype(IRPointers.class, "IRPointers");            //have no idea how to make it pretty
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();
			JsonReader objectReader = new JsonReader(new FileReader("vars/varLists/" + uInput + ".json"));
			return gson.fromJson(objectReader, DataExecutor[].class);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(0);
			return new DataExecutor[]{};
		}
	}

	private static void keyDown(KeyEvent e)
	{
		switch(e.getKeyChar())
		{
			case 'q':
				exit();
		}
	}

	private static void exit()
	{
		try
		{
			String uInput = JOptionPane.showInputDialog("File to save to?");
			if(uInput == null || uInput.equals(""))
				System.exit(0);
			Gson gson = new Gson();
			FileWriter fw = new FileWriter("vars/varLists/" + uInput + ".json");
			fw.write(gson.toJson(executorMap.values().toArray()));
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}