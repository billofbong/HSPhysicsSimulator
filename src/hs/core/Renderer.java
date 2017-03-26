package hs.core;
import hs.physics.Vector2;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class Renderer implements Runnable
{
    private boolean running;
    private Thread thread;

    public Renderer()
    {
        running = false;
        thread = new Thread(this);
        thread.setName("Main renderering Thread");
        thread.setPriority(8);
    }

    public void start()
    {
        if(!running)
        {
            running = true;

        }
    }

    public void stop()
    {

    }

    public void run()
    {

    }
}
