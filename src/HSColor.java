package hs.util;

import java.awt.Color;

public class HSColor extends Color
{	
	public HSColor(float r, float g, float b, float a)
	{
		super(r, g, b, a);
	}
	
	public String toString()
	{
		return "#" + Integer.toHexString(getRed()) + Integer.toHexString(getGreen()) + Integer.toHexString(getBlue());
	}
}
