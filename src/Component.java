package hs.components;

public abstract class Component
{
	protected Component()
	{
		
	}
	
	public void start(double delta, double time, long frames)
	{}
	
	public void update(double delta, double time, long frames)
	{}
	
	public void fixedUpdate(double delta, double time, long frames)
	{}
	
	public void lateUpdate(double delta, double time, long frames)
	{}
}
