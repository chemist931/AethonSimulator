package com.gsaul.AethonSimulator;

import com.gsaul.AethonSimulator.executors.*;
import com.gsaul.AethonSimulator.panels.*;
import com.gsaul.AethonSimulator.staticHelpers.Audio;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Frame;
import java.awt.SplashScreen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
	private static Map<String, DataExecutor> executorMap;
	private static PanelBase[] paneArray;
	private static Frame root = JOptionPane.getRootFrame();

	public static void main(String[] args)
	{
		final SplashScreen splash = SplashScreen.getSplashScreen();
		splash.createGraphics();

		executorMap = new HashMap<>();
		DataExecutor[] executorArray = objectBuilder();
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
		LifeSupport lsPane = new LifeSupport();
		LifeSupportAtmo lsAtPane = new LifeSupportAtmo();
		AttNav anPane = new AttNav();
		ElectricalSystems esPane = new ElectricalSystems();
		CargoStates csPane = new CargoStates();
		WarningAnnunciator waPane = new WarningAnnunciator();
		AttInd attInd = new AttInd();
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
        }
		*/
		for(JFrame aFrameArray : frameArray)
		{
			aFrameArray.setSize(1280, 1024);
			aFrameArray.setUndecorated(true);
			aFrameArray.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			aFrameArray.setVisible(true);
		}

		final ScheduledExecutorService advancer = Executors.newSingleThreadScheduledExecutor();
		advancer.scheduleWithFixedDelay(AethonDriver:: updateVars, 500, 500, TimeUnit.MILLISECONDS); //UPDATE THIS WITH ATTNAV

		esFrame.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				keyDown(e);
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
		});
		/*
		try
		{
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/info.wav")));
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/urgent.wav")));
			Audio.soundOff(AudioSystem.getAudioInputStream(new File("lib/sounds/warning.wav")));
		}
		catch(IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}*/
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
			if(uInput == null || uInput.equals(""))
				uInput = "defaults";
			String fileName = "vars/varLists/" + uInput + ".json";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			if(br.readLine() == null)
				throw new IOException("Save file empty");
			RuntimeTypeAdapterFactory<DataExecutor> typeFactory = RuntimeTypeAdapterFactory
					.of(DataExecutor.class, "valName")
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
			JsonReader objectReader = new JsonReader(new FileReader(fileName));
			return gson.fromJson(objectReader, DataExecutor[].class);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(root, "Save file bork", "Error", JOptionPane.ERROR_MESSAGE);
			return objectBuilder();
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
			if(uInput.equalsIgnoreCase("defaults"))
			{
				JOptionPane.showMessageDialog(root, "Cannot save over defaults!", "Error", JOptionPane.ERROR_MESSAGE);
				exit();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			File myFile = new File("vars/varLists/" + uInput + ".json");
			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			myOutWriter.append(gson.toJson(executorMap.values().toArray()));
			myOutWriter.close();
			fOut.close();
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(root, "Cannot write to file", "Error", JOptionPane.ERROR_MESSAGE);
			exit();
		}
	}
}