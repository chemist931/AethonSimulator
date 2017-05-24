package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.io.FileReader;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
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
	private static DataExecutor[] executorList;

	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);
		final SplashScreen splash = SplashScreen.getSplashScreen();
		Graphics2D g = splash.createGraphics();

		JsonReader jsonReader = new JsonReader(new FileReader("vars/masterKeys/prod.json"));
		executorList = new Gson().fromJson(jsonReader, DataExecutor[].class);
		executorMap = new HashMap<String, DataExecutor>();
		for(DataExecutor de : executorList)
			executorMap.put(de.getName(), de);
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
		for(DataExecutor de : executorList)
			de.updateVars(executorMap);
	}
}