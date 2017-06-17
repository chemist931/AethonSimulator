package com.gsaul.AethonSimulator.panels;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AttInd extends JPanel
{
	private double pitchAngle;
	private double rollAngle;
	private double yawAngle;
	private BufferedImage horizonImage; //1
	private BufferedImage bezelImage; //2
	private BufferedImage headingImage; //3
	private BufferedImage wingsImage; //4

	private Point ptBoule; //Ground-Sky initial location
	private Point ptHeading; // Heading ticks
	private Point ptRotation; // Point of rotation

	public AttInd()
	{
		setBackground(Color.BLUE.darker());
		try
		{
			horizonImage = ImageIO.read(new File("lib/horizon.bmp"));
			bezelImage = ImageIO.read(new File("lib/bezel.bmp"));
			headingImage = ImageIO.read(new File("lib/heading.bmp"));
			wingsImage = ImageIO.read(new File("lib/wings.bmp"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		ptBoule = new Point(-25, -410);
		ptHeading = new Point(-592, 150);
		ptRotation = new Point(150, 150);
	}

	public void setPitchAngle(double pitchAngle)
	{
		this.pitchAngle = pitchAngle;
	}

	public void setRollAngle(double rollAngle)
	{
		this.rollAngle = rollAngle;
	}

	public void setYawAngle(double yawAngle)
	{
		this.yawAngle = yawAngle;
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		RotateAndTranslate(g2d, horizonImage, rollAngle, 0.00, ptBoule, (4 * pitchAngle), ptRotation, 1);
		RotateAndTranslate2(g2d, headingImage, yawAngle, rollAngle, 0.00, ptHeading, (4 * pitchAngle), ptRotation, 1);
		g2d.drawImage(horizonImage, 0, 0, null);
		g2d.drawImage(wingsImage, 75, 125, null);
	}

	private void RotateAndTranslate(Graphics2D g2d, BufferedImage img, Double alphaRot, Double alphaTrs, Point ptImg, double deltaPx, Point ptRot, float scaleFactor)
	{
			double beta = 0;
			double d = 0;
			float deltaXRot = 0;
			float deltaYRot = 0;
			float deltaXTrs = 0;
			float deltaYTrs = 0;

			// Rotation

			if (ptImg != ptRot)
			{
				// Internals coeffs
				if (ptRot.getX() != 0)
				{
					beta = Math.atan((double)ptRot.getY() / (double)ptRot.getX());
				}

				d = Math.sqrt((ptRot.getX() * ptRot.getX()) + (ptRot.getY() * ptRot.getY()));

				// Computed offset
				deltaXRot = (float)(d * (Math.cos(alphaRot - beta) - Math.cos(alphaRot) * Math.cos(alphaRot + beta) - Math.sin(alphaRot) * Math.sin(alphaRot + beta)));
				deltaYRot = (float)(d * (Math.sin(beta - alphaRot) + Math.sin(alphaRot) * Math.cos(alphaRot + beta) - Math.cos(alphaRot) * Math.sin(alphaRot + beta)));
			}

			// Translation

			// Computed offset
			deltaXTrs = (float)(deltaPx * (Math.sin(alphaTrs)));
			deltaYTrs = (float)(-deltaPx * (-Math.cos(alphaTrs)));

			// Rotate image support
			//g.RotateTransform((float)(alphaRot * 180 / Math.PI));
			AffineTransform transform = new AffineTransform();
			transform.setToTranslation((ptImg.getY() + deltaXRot + deltaXTrs), (ptImg.getY() + deltaYRot + deltaYTrs) * scaleFactor);
			transform.setToScale(scaleFactor, scaleFactor);
			transform.setToRotation(alphaRot * 180 / Math.PI);
			// Dispay image
			g2d.drawImage(img, (int) ((ptImg.getY() + deltaXRot + deltaXTrs) * scaleFactor), (int) ((ptImg.getY() + deltaYRot + deltaYTrs) * scaleFactor), (int) (img.getWidth() * scaleFactor), (int) (img.getHeight() * scaleFactor), null);
			g2d.drawImage(img, transform, null);
			// Put image support as found
			//g.RotateTransform((float)(-alphaRot * 180 / Math.PI));
	}

	private void RotateAndTranslate2(Graphics2D g2d, BufferedImage img, double yawRot, double alphaRot, double alphaTrs, Point ptImg, double deltaPx, Point ptRot, float scaleFactor)
	{
		double beta = 0;
		double d = 0;
		float deltaXRot = 0;
		float deltaYRot = 0;
		float deltaXTrs = 0;
		float deltaYTrs = 0;

		// Rotation

		if (ptImg != ptRot)
		{
			// Internals coeffs
			if (ptRot.getX() != 0)
			{
				beta = Math.atan(ptRot.getY() / ptRot.getX());
			}

			d = Math.sqrt((ptRot.getX() * ptRot.getX()) + (ptRot.getY() * ptRot.getY()));

			// Computed offset
			deltaXRot = (float)(d * (Math.cos(alphaRot - beta) - Math.cos(alphaRot) * Math.cos(alphaRot + beta) - Math.sin(alphaRot) * Math.sin(alphaRot + beta) + yawRot));
			deltaYRot = (float)(d * (Math.sin(beta - alphaRot) + Math.sin(alphaRot) * Math.cos(alphaRot + beta) - Math.cos(alphaRot) * Math.sin(alphaRot + beta)));
		}

		// Translation

		// Computed offset
		deltaXTrs = (float)(deltaPx * (Math.sin(alphaTrs)));
		deltaYTrs = (float)(-deltaPx * (-Math.cos(alphaTrs)));

		// Rotate image support
		//g.RotateTransform((float)(alphaRot * 180 / Math.PI));
		AffineTransform transform = new AffineTransform();
		transform.setToTranslation((ptImg.getX() + deltaXRot + deltaXTrs) * scaleFactor, (ptImg.getY() + deltaYRot + deltaYTrs) * scaleFactor);
		transform.setToScale(scaleFactor, scaleFactor);
		transform.setToRotation(alphaRot * 180 / Math.PI);
		// Dispay image
		g2d.drawImage(img, (int) ((ptImg.getX() + deltaXRot + deltaXTrs) * scaleFactor), (int) ((ptImg.getY() + deltaYRot + deltaYTrs) * scaleFactor), (int) (img.getWidth() * scaleFactor), (int) (img.getHeight() * scaleFactor), null);

		// Put image support as found
		//g.RotateTransform((float)(-alphaRot * 180 / Math.PI));
	}
}