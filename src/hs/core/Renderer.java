package hs.core;

import hs.sceneobject.SceneObject;
import hs.world.Scene;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

/**
 * @author Corbin Naderzad
 */
public class Renderer extends Canvas
{
    public static final Renderer DEFAULT_RENDERER = new Renderer(Scene.DEMO_SCENE);
    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 1280;
    
    private BufferedImage image;
    private int pixels[];
    private int updatePixels[];
    private final int width, height;
    private Scene referenceScene;
    private boolean reset;
    
    public Renderer()
    {
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        init(width, height, Scene.DEFAULT_SCENE);
    }
    
    public Renderer(Scene referenceScene)
    {
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;
        init(width, height, referenceScene);
    }
    
    public Renderer(int width, int height)
    {
        this.width = width;
        this.height = height;
        init(width, height, Scene.DEFAULT_SCENE);
    }
    
    public Renderer(int width, int height, Scene referenceScene)
    {
        this.width = width;
        this.height = height;
        init(width, height, referenceScene);
    }
    
    private void init(int width, int height, Scene referenceScene)
    {
        setSize(width, height);
        reset = true;
        this.referenceScene = referenceScene;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        updatePixels = new int[pixels.length];
    }
    
    public void setReset(boolean doReset)
    {
        reset = doReset;
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta NaN, because a previous frame hasn't occurred.
     * @param time 0, because no time has passed.
     * @param frames 0, because no frames have been rendered.
     */
    public void start(double delta, double time, long frames)
    {

        //drawLine(-.5f, -.5f, .5f, .5f);
        //drawLine(.5f, .5f, 1f, .5f);
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta time since the last frame.
     * @param time the amount of time that has passed since the PhysicsSimulator started.
     * @param frames the amount of frames that have been rendered.
     */
    public void update(double delta, double time, long frames)
    {
        //drawLine(-1f, -1f, 1f, 1f);
        //drawLine(1f, -1f, -1f, 1f);
        //drawLine(-.5f, -.25f, .5f, .5f);
    
        //drawLine(-.5f, .5f, .5f, .5f);
        //drawLine(.5f, .5f, .5f, -.5f);
        //drawLine(.5f, -.5f, -.5f, -.5f);
        //drawLine(-.5f, -.5f, -.5f, .5f);
        
        
    }
    
    /**
     * Do not run this, make a PhysicsSimulator instead.
     * @param delta set on a constant tickrate set by PhysicsSmulator as 64. This value should be equal to time / frames.
     * @param time the amount of the time that has passed. This value should be equal to delta * frames.
     * @param frames the amount of frames that have been rendered. This value should be equal to time / delta.
     */
    public void fixedUpdate(double delta, double time, long frames)
    {
        referenceScene.updateAllSceneObjects(delta, time, frames);
        drawShapes(referenceScene.getSceneObjects());
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
    
    /**
     * Draws a line between point one and point two
     * @param x0 vertex-1 x value
     * @param y0 vertex-1 y value
     * @param x1 vertex-2 x value
     * @param y1 vertex-2 y value
     */
    protected void drawLine(float x0, float y0, float x1, float y1)
    {
        if(x0 > x1)
        {
            drawLine(x1, y1, x0, y0);
            return;
        }
        x0 = xCoordToPixel(x0);
        x1 = xCoordToPixel(x1);
        y0 = yCoordToPixel(y0);
        y1 = yCoordToPixel(y1);

        //System.out.println("(" + x0 + ", " + y0 + ") (" + x1 + ", " + y1 + ")");

        float deltaX = x1 - x0;
        float deltaY = y0 - y1;

        if(deltaX != 0)
        {
            if(deltaY >= 0)
            {
                float deltaErr = deltaY / deltaX;
                //System.out.println(deltaY / deltaX);
                float error = deltaErr - 0.5f;
                int y = (int) y0;
    
                for(float x = x0; x <= x1; x++)
                {
                    //plot
                    //System.out.println(x + ", " + y);
                    plot((int) x, y, 0xffffff);
                    error += deltaErr;
                    if(error >= 0.5)
                    {
                        y -= 1;
                        error -= 1;
                    }
                }
            }
            else
            {
                float deltaErr = deltaY / deltaX;
                //System.out.println(deltaY / deltaX);
                float error = deltaErr - 0.5f;
                int y = (int) y0;
    
                for(float x = x0; x <= x1; x++)
                {
                    //plot
                    //System.out.println(x + ", " + y);
                    plot((int) x, y, 0xffffff);
                    error -= deltaErr;
                    if(error >= 0.5)
                    {
                        y += 1;
                        error -= 1;
                    }
                }
            }
        }
        else
        {
            for(int y = (int) Math.min(y0, y1); y <= Math.max(y0, y1); y++)
            {
                plot((int) x0, y, 0xffffff);
            }
        }
    }
    
    protected void drawShapes(ArrayList<SceneObject> sceneObjects)
    {
        //System.out.println(sceneObjects.size());
        for(SceneObject so : sceneObjects)
        {
            ArrayList<Point2D.Float> p2D = so.getVertices();
            Point2D.Float origin = so.getOrigin();
        
            for(int i = 0; i < p2D.size(); i++)
            {
                float x0, y0, x1, y1;
                if(i == p2D.size() - 1)
                {
                    x0 = origin.x + p2D.get(i).x;
                    y0 = origin.y + p2D.get(i).y;
                    x1 = origin.x + p2D.get(0).x;
                    y1 = origin.y + p2D.get(0).y;
                }
                else
                {
                    x0 = origin.x + p2D.get(i).x;
                    y0 = origin.y + p2D.get(i).y;
                    x1 = origin.x + p2D.get(i + 1).x;
                    y1 = origin.y + p2D.get(i + 1).y;
                }
                
                //System.out.println(x0 + ", " + y0 + "\t" + x1 + ", " + y1);
                drawLine(x0, y0, x1, y1);
            }
        }
    }

    private void plot(int x, int y, int color)
    {
        updatePixels[x + y * width] = color;
    }

    protected int xCoordToPixel(float cx)
    {
        double xBound = referenceScene.getXBound();
        return (int) ((width - 1) * ((cx + xBound) / 2 * xBound));

    }

    protected int yCoordToPixel(float cy)
    {
        double yBound = referenceScene.getYBound();
        //return (int) ((height - 1) * (Math.abs(cy - yBound) / (2 * yBound)));
        //return (int) (height/2 - cy);
        return (int) ((height - 1) * ((Math.abs(cy - yBound)) / (2 * yBound)));
    }

    /**
     * This is called after when all the updates have ran and it will updatePhysics the screen.
     */
    public void render()
    {
        updatePixels();
        BufferStrategy bs = getBufferStrategy();
        
        if(bs == null)
        {
            createBufferStrategy(2);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        g.dispose();
        bs.show();
        
        if(reset)
            reset(0x000000);
    }

    public void reset(int color)
    {
        for(int i = 0; i < updatePixels.length; i++)
        {
            updatePixels[i] = color;
        }

        for(int i = 0; i < pixels.length; i++)
        {
            pixels[i] = color;
        }
    }
}
