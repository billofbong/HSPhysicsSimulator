package hs.core;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author Corbin Naderzad
 */
public class Renderer extends Canvas
{
    public static final Renderer DEFAULT_RENDERER = new Renderer();
    
    private BufferedImage image;
    private int pixels[];
    private int updatePixels[];
    private final int width, height;
    
    public Renderer()
    {
        width = 1200;
        height = 720;
        init(width, height);
    }
    
    public Renderer(int width, int height)
    {
        this.width = width;
        this.height = height;
        init(width, height);
    }
    
    private void init(int width, int height)
    {
        setSize(width, height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        updatePixels = new int[pixels.length];
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta NaN, because a previous frame hasn't occurred.
     * @param time 0, because no time has passed.
     * @param frames 0, because no frames have been rendered.
     */
    public void start(double delta, double time, long frames)
    {
    
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta time since the last frame.
     * @param time the amount of time that has passed since the PhysicsSimulator started.
     * @param frames the amount of frames that have been rendered.
     */
    public void update(double delta, double time, long frames)
    {
        for(int i = 0; i < updatePixels.length; i++)
        {
            updatePixels[i] = (int) (0x00ff00 + frames);
        }
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta set on a constant tickrate set by PhysicsSmulator as 64. This value should be equal to time / frames.
     * @param time the amount of the time that has passed. This value should be equal to delta * frames.
     * @param frames the amount of frames that have been rendered. This value should be equal to time / delta.
     */
    public void fixedUpdate(double delta, double time, long frames)
    {
    
    }
    
    /**
     * System.out.println(1000 / delta);
     * @param delta time since the last frame.
     * @param time the amount of time that has passed since the PhysicsSimulator started.
     * @param frames the amount of frames that have been rendered.
     */
    public void lateUpdate(double delta, double time, long frames)
    {
    
    }
    
    
    protected void updatePixels()
    {
        
        for(int i = 0; i < pixels.length; i++)
        {
            pixels[i] = updatePixels[i];
        }
    }
    
    protected void drawLine(float x1, float y1, float x2, float y2)
    {
    
    }
    
    /**
     * This is called after when all the updates have ran and it will update the screen.
     */
    public void render()
    {
        updatePixels();
        BufferStrategy bs = getBufferStrategy();
        
        if(bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        g.dispose();
        bs.show();
    }
}
