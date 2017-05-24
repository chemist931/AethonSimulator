package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.Color;
import java.awt.SplashScreen;
import java.io.FileReader;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.lang.Class;
import java.lang.reflect.Constructor;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class AethonDriver
{
	private static LifeSupport lsPane = new LifeSupport();
	private static LifeSupportAtmo lsAtPane = new LifeSupportAtmo();
	private static AttNav anPane = new AttNav();
	private static ElectricalSystems esPane = new ElectricalSystems();
	private static CargoStates csPane = new CargoStates();
	private static Map<String, DataExecutor> executorMap;

	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);
		final SplashScreen splash = SplashScreen.getSplashScreen();
		splash.createGraphics();

		JsonReader jsonReader = new JsonReader(new FileReader("vars/masterKeys/prod.json"));
		String[] executorStringList = new Gson().fromJson(jsonReader, String[].class);
		executorMap = new HashMap<>();
		for(String name : executorStringList)
		{
			Class aClass = Class.forName("gsaul.AethonSimulator.executors." + name);
			Constructor ctor = aClass.getConstructor();
			DataExecutor de = (DataExecutor) ctor.newInstance();
			executorMap.put(name, de);
		}
		executorStringList = null; //garbage collection
		JFrame lsFrame = new JFrame();
		JFrame lsFrameAtmo = new JFrame();
		JFrame attFrame = new JFrame();
		JFrame esFrame = new JFrame();
		JFrame csFrame = new JFrame();

		lsFrame.setContentPane(lsPane);
		lsFrameAtmo.setContentPane(lsAtPane);
		attFrame.setContentPane(anPane);
		esFrame.setContentPane(esPane);
		csFrame.setContentPane(csPane);

		JFrame[] frameArray = new JFrame[]{lsFrame, lsFrameAtmo, attFrame, esFrame, csFrame};
		/*for(int a=0; a< frameArray.length; a++)
		{
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

		final ScheduledExecutorService advancer = Executors.newScheduledThreadPool(4);
		advancer.scheduleWithFixedDelay(AethonDriver:: updateVars, 0, 125, TimeUnit.MILLISECONDS);
	}

	private static void updateVars()
	{
		lsPane.updateVars(executorMap);
		lsAtPane.updateVars(executorMap);
		anPane.updateVars(executorMap);
		esPane.updateVars(executorMap);
		csPane.updateVars(executorMap);
		for(DataExecutor de : executorMap.values())
			de.updateVars(executorMap);
	}
}