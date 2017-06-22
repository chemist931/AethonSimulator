/* Copyright 2002-2017 CS Systèmes d'Information
 * Licensed to CS Systèmes d'Information (CS) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * CS licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gsaul.AethonSimulator.executors;

import com.gsaul.AethonSimulator.DataExecutor;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.hipparchus.ode.AbstractIntegrator;
import org.hipparchus.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.hipparchus.util.FastMath;
import org.orekit.data.DataProvidersManager;
import org.orekit.data.DirectoryCrawler;
import org.orekit.errors.OrekitException;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.orbits.PositionAngle;
import org.orekit.propagation.BoundedPropagator;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.numerical.NumericalPropagator;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScale;
import org.orekit.time.TimeScalesFactory;

public class EphemerisMode
{
	private static AbsoluteDate initialDate;
	private static AbsoluteDate currentDate;
	private static BoundedPropagator ephemeris;
	private static NumericalPropagator propagator;
	private static double shiftedBy = 0;
	private static double stepSize;
	private static double shiftSize = 15;

	public static void startEphemerisMode()
	{
		try
		{
			File home = new File(System.getProperty("user.home"));
			File orekitData = new File(home, "orekit-data");
			if(! orekitData.exists())
			{
				System.err.format(Locale.US, "Failed to find %s folder%n",
						orekitData.getAbsolutePath());
				System.err.format(Locale.US, "You need to download %s from the %s page and unzip it in %s for this tutorial to work%n",
						"orekit-data.zip", "https://www.orekit.org/forge/projects/orekit/files",
						home.getAbsolutePath());
				System.exit(1);
			}

			DataProvidersManager manager = DataProvidersManager.getInstance();
			manager.addProvider(new DirectoryCrawler(orekitData));

			// Initial orbit parameters
			double a = 24396159; // semi major axis in meters
			double e = 0.72831215; // eccentricity
			double i = FastMath.toRadians(7); // inclination
			double omega = FastMath.toRadians(180); // perigee argument
			double raan = FastMath.toRadians(261); // right ascension of ascending node
			double lM = 0; // mean anomaly

			// Inertial frame
			Frame inertialFrame = FramesFactory.getEME2000();

			// Initial date in UTC time scale
			TimeScale utc = TimeScalesFactory.getUTC();
			initialDate = new AbsoluteDate(2004, 01, 01, 23, 30, 00.000, utc);
			currentDate = initialDate;
			// gravitation coefficient
			double mu = 3.986004415e+14;

			// Orbit construction as Keplerian
			Orbit initialOrbit = new KeplerianOrbit(a, e, i, omega, raan, lM, PositionAngle.MEAN,
					inertialFrame, initialDate, mu);

			// Initialize state
			SpacecraftState initialState = new SpacecraftState(initialOrbit);

			// Numerical propagation with no perturbation (only Keplerian movement)
			// Using a very simple integrator with a fixed step: classical Runge-Kutta
			// the step is ten seconds
			stepSize = 0.5;
			AbstractIntegrator integrator = new ClassicalRungeKuttaIntegrator(stepSize);
			propagator = new NumericalPropagator(integrator);

			// Set the propagator to ephemeris mode
			propagator.setEphemerisMode();

			// Initialize propagation
			propagator.setInitialState(initialState);

			// Propagation with storage of the results in an integrated ephemeris
			SpacecraftState finalState = propagator.propagate(initialDate.shiftedBy(shiftSize)); //one month is 2628000

			System.out.println(" Numerical propagation :");
			System.out.println("  Final date : " + finalState.getDate());
			System.out.println("  " + finalState.getOrbit());

			// Getting the integrated ephemeris
			ephemeris = propagator.getGeneratedEphemeris();
		}
		catch(OrekitException oe)
		{
			System.out.println(oe.getMessage());
		}
	}

	public static Orbit getOrbit()
	{
		try
		{
			AbsoluteDate intermediateDate = initialDate.shiftedBy(shiftedBy);
			return ephemeris.propagate(intermediateDate).getOrbit();
		}
		catch(OrekitException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void updateVars(HashMap<String, DataExecutor> map)
	{
		try
		{
			System.out.println(propagator.propagate(currentDate).getOrbit().toString());
			System.out.println(currentDate.toString());
			currentDate = initialDate.shiftedBy(shiftedBy);
			if(currentDate.equals(ephemeris.getMaxDate().shiftedBy(-0.5)))
			{
				AbstractIntegrator integrator = new ClassicalRungeKuttaIntegrator(stepSize);
				propagator = new NumericalPropagator(integrator);

				// Set the propagator to ephemeris mode
				propagator.setEphemerisMode();

				// Initialize propagation
				propagator.setInitialState(new SpacecraftState(getOrbit()));

				// Propagation with storage of the results in an integrated ephemeris
				SpacecraftState finalState = propagator.propagate(currentDate.shiftedBy(shiftSize)); //one month is 2628000

				System.out.println(" New Ephemerides:");
				System.out.println("  Final date : " + finalState.getDate());
				System.out.println("  " + finalState.getOrbit());

				// Getting the integrated ephemeris
				ephemeris = propagator.getGeneratedEphemeris();
			}
			shiftedBy+=0.5;
		}
		catch(OrekitException e)
		{
			e.printStackTrace();
		}
	}
}
