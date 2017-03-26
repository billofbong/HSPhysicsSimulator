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
    private volatile Renderer renderer;
    
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
    
    public Renderer getRenderer()
    {
        return renderer;
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
        final double SECONDS_PER_TICK = (double) 1 / TICK_RATE;
        long lastTime = System.currentTimeMillis();
        double timeCounter = 0;
        long fixedUpdateCounter = 0;
        long now;
        double time = 0f;
        if(running)
        {
            // Start rendering
            
            renderer.start(Double.NaN, time);
            
            // Stop rendering
            now = System.currentTimeMillis();
            delta =  ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            timeCounter += delta;
            time += delta;
        }
        
        while(running)
        {
            // Start rendering
            
            renderer.update(delta, time);
            
            if(timeCounter >= SECONDS_PER_TICK)
            {
                renderer.fixedUpdate(SECONDS_PER_TICK, SECONDS_PER_TICK * ++fixedUpdateCounter);
                timeCounter -= SECONDS_PER_TICK;
            }
            
            renderer.lateUpdate(delta, time);
            
            // Stop rendering
            
            renderer.render();
            System.out.println(1000 / delta);
    
            now = System.currentTimeMillis();
            delta = ((double) now - lastTime) / MILLIS_PER_SECOND;
            lastTime = now;
            time += delta;
        }
    }
}
