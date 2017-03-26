package hs.core;

import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * @author Corbin Naderzad
 */
public class Renderer extends Canvas
{
    public static final Renderer DEFAULT_RENDERER;
    
    static
    {
        DEFAULT_RENDERER = new Renderer();
    }
    
    private BufferedImage image;
    private int pixels[];
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
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta NaN
     */
    public void start(double detla)
    {
    
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta time since the last frame.
     */
    public void update(double delta)
    {
    
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta set on a constant tickrate set by PhysicsSmulator as 64.
     */
    public void fixedUpdate(double delta)
    {
    
    }
}
