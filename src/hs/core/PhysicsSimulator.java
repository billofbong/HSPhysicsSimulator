package hs.core;

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
    private Renderer renderer;
    
    /**
     * Initializes a PhysicsSimulator object with Renderer.DEFAULT_RENDERER
     */
    public PhysicsSimulator()
    {
        init(Renderer.DEFAULT_RENDERER);
    }
    
    /**
     * Initializes a PhysicsSimulator object with Renderer.DEFAULT_RENDERER
     * @param renderer
     */
    public PhysicsSimulator(Renderer renderer)
    {
        init(renderer);
    }
    
    private void init(Renderer renderer)
    {
        running = false;
        delta = 0f;
        this.renderer = renderer;
        thread = new Thread(this);
        thread.setName("Main rendering Thread");
        thread.setPriority(10);
    }

    public synchronized void start()
    {
        if(!running)
        {
            running = true;
            thread.start();
        }
    }
    
    /**
     * Stops the main rendering thread.
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
        final double MILLIS_PER_TICK = (double) 1000 / TICK_RATE;
        double tickCount = 0f;
        long lastTime = System.currentTimeMillis();
        long now;
        double time = 0f;
        if(running)
        {
            // Start rendering
            
            renderer.start(Double.NaN);
            
            // Stop rendering
            now = System.currentTimeMillis();
            delta = ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            time += delta;
        }
        
        while(running)
        {
            // Start rendering
            
            renderer.update(delta);
            
            // Stop rendering
    
            now = System.currentTimeMillis();
            delta = ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            time += delta;
        }
    }
}
