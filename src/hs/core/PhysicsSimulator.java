package hs.core;

import hs.world.Scene;

/**
 * @author Corbin Naderzad
 */
public class PhysicsSimulator implements Runnable
{
    /**
     * The constant tickrate of all calculations.
     */
    public static final int TICK_RATE = 64;
    
    private volatile boolean running;
    private volatile Thread thread;
    private volatile double delta;
    private volatile Renderer renderer;
    private boolean displayInfo;
    private Scene scene;
    
    /**
     * Initializes a PhysicsSimulator object with Renderer.DEFAULT_RENDERER
     */
    public PhysicsSimulator()
    {
        init(Renderer.DEFAULT_RENDERER, Scene.DEMO_SCENE);
    }
    
    /**
     * Initializes a PhysicsSimulator object with Renderer.DEFAULT_RENDERER
     * @param renderer
     */
    public PhysicsSimulator(Renderer renderer)
    {
        init(renderer, Scene.DEFAULT_SCENE);
    }
    
    public PhysicsSimulator(Scene scene)
    {
        init(Renderer.DEFAULT_RENDERER, scene);
    }
    
    public PhysicsSimulator(Renderer renderer, Scene scene)
    {
        init(renderer, scene);
    }
    
    private void init(Renderer renderer, Scene scene)
    {
        displayInfo = false;
        running = false;
        delta = 0f;
        this.renderer = renderer;
        this.scene = scene;
        thread = new Thread(this);
        thread.setName("Main rendering thread");
        thread.setPriority(10);
    }
    
    /**
     * Returns the value of delta.
     * @return delta
     */
    public double getDelta()
    {
        return delta;
    }
    
    public void setDisplayInfo(boolean displayInfo)
    {
        this.displayInfo = displayInfo;
    }
    
    /**
     * Returns the renderer. Use this to add it to a window.
     * @return renderer
     */
    public Renderer getRenderer()
    {
        return renderer;
    }
    
    /**
     * Starts the physics simulator with a new thread called: Main rendering thread.
     */
    public synchronized void start()
    {
        if(!running)
        {
            running = true;
            thread.start();
        }
    }
    
    /**
     * Stops the physics simulator and joins Main rendering thread with the main thread once the run method completes.
     * @throws InterruptedException if the main rendering thread fails to join the main thread.
     */
    public synchronized void stop() throws InterruptedException
    {
        if(running)
        {
            running = false;
            thread.join();
        }
    }
    
    /**
     * Do not run this method, run start instead.
     */
    public void run()
    {
        final int MILLIS_PER_SECOND = 1000;
        final double SECONDS_PER_TICK = (double) 1 / TICK_RATE;
        long lastTime = System.currentTimeMillis();
        double timeCounter = 0;
        long millisCounter = 0;
        long fixedUpdateCounter = 0;
        long now;
        long frames = 0;
        double time = 0f;
        
        if(running)
        {
            // Start updating
            
            renderer.start(Double.NaN, time, frames);
            
            // Stop updating and start rendering
            
            renderer.render();
            
            // Stop rendering
            
            frames++;
            now = System.currentTimeMillis();
            millisCounter += now - lastTime;
            delta =  ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            timeCounter += delta;
            time += delta;
        }
        
        while(running)
        {
            // Start updating


            renderer.update(delta, time, frames);
            
            if(timeCounter >= SECONDS_PER_TICK)
            {
                renderer.fixedUpdate(SECONDS_PER_TICK, SECONDS_PER_TICK * ++fixedUpdateCounter, frames);
                timeCounter -= SECONDS_PER_TICK;
            }
            
            renderer.lateUpdate(delta, time, frames);
            
            // Stop updating
            
            renderer.render();
            
            frames++;
            now = System.currentTimeMillis();
            millisCounter += now - lastTime;
            delta = ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            timeCounter += delta;
            time += delta;

            if(millisCounter >= MILLIS_PER_SECOND)
            {
                millisCounter -= MILLIS_PER_SECOND;
                if(displayInfo)
                    System.out.println(delta + ", " + (1 / delta) + ", " + frames);
            }
        }
    }
}
