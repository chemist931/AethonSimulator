package gsaul.AethonSimulator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import java.awt.Color;
import java.awt.SplashScreen;
import java.io.FileReader;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Map;

import gsaul.AethonSimulator.executors.*;


public class AethonDriver
{
	private static LifeSupport lsPane;
	private static LifeSupportAtmo lsAtPane;
	private static AttNav anPane;
	private static ElectricalSystems esPane;
	private static CargoStates csPane;
	private static Map<String, DataExecutor> executorMap;

	public static void main(String[] args) throws Exception
	{
		final SplashScreen splash = SplashScreen.getSplashScreen();
		splash.createGraphics();

		String uInput = JOptionPane.showInputDialog("Save file name? (\"defaults\" for default parameters))");
		executorMap = objectBuilder(uInput);

		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		UIManager.getLookAndFeelDefaults().put("Panel.background", Color.BLACK);

		lsPane = new LifeSupport();
		lsAtPane = new LifeSupportAtmo();
		anPane = new AttNav();
		esPane = new ElectricalSystems();
		csPane = new CargoStates();

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

		JFrame[] frameArray= new JFrame[] {lsFrame, lsFrameAtmo, attFrame, esFrame, csFrame};
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

	private static HashMap objectBuilder(String uInput) //Thank you StackOverflow user "perception"
	{
		try
		{
			TypeToken<HashMap<String, DataExecutor>> hashMapTypeToken = new TypeToken<HashMap<String, DataExecutor>>()
			{
			};
			RuntimeTypeAdapterFactory<DataExecutor> typeFactory = RuntimeTypeAdapterFactory
					.of(DataExecutor.class, "valName")
					.registerSubtype(Capsule.class)
					.registerSubtype(HVAC.class)
					.registerSubtype(LSRegulators.class)
					.registerSubtype(MOF.class)
					.registerSubtype(Reactor.class)
					.registerSubtype(ServiceModule.class)
					.registerSubtype(WaterManagement.class);

			Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();
			JsonReader objectReader = new JsonReader(new FileReader("vars/varLists/" + uInput + ".json"));
			return gson.fromJson(objectReader, hashMapTypeToken.getClass());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}