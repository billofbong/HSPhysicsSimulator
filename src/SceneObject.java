package hs.sceneobject;

import hs.core.PhysicsSimulator;
import hs.physics.Vector2;
import hs.components.Component;
import hs.world.Scene;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class SceneObject
{

    public static final Vector2 DEFAULT_GRAVITY = new Vector2(0, -.1f);
    protected Vector2 gravity;
    protected ArrayList<Point2D.Float> vertices = new ArrayList<>();
    protected Point2D.Float origin;
    protected ArrayList<Component> components = new ArrayList<>();
    protected float xScale = .1f, yScale = .1f;
    protected boolean hasPhysics = true;

    /**
     *
     * @param gravity the gravity in units/sec^2 as a vector
     */
    public SceneObject(Vector2 gravity, Point2D.Float origin)
    {
        this.gravity = gravity;
        this.origin = origin;

    }

    /**
     *
     * @param gravity the gravity in units/sec^2 as a vector
     * @param xScale the scaling of the object on the x-axis
     * @param yScale the scaling of the object on the y-axis
     */
    public SceneObject(Vector2 gravity, Point2D.Float origin, float xScale, float yScale)
    {
        this.gravity = gravity;
        this.origin = origin;
        this.xScale = xScale;
        this.yScale = yScale;

        //System.out.println(this.gravity);
    }

    public SceneObject(Vector2 gravity, Point2D.Float origin, float xScale, float yScale, boolean hasPhysics)
    {
        this.gravity = gravity;
        this.origin = origin;
        this.xScale = xScale;
        this.yScale = yScale;
        this.hasPhysics = hasPhysics;
    }

    /**
     *
     * @param delta
     * @param frames
     * @param time
     */
    public void updatePhysics(double delta, double time, long frames)
    {
    	
    }

    /**
     *
     * @return ArrayList of vertices
     */
    public ArrayList<Point2D.Float> getVertices()
    {
        return vertices;
    }

    /**
     *
     * @return ArrayList of components
     */
    public ArrayList<Component> getComponents()
    {
        return components;
    }

    /**
     *
     * @return origin as Point2D
     */
    public Point2D.Float getOrigin()
    {
        return origin;
    }
    
    public void setOrigin(Point2D.Float origin)
    {
        this.origin = origin;
    }
    
    public void setOrigin(float x, float y)
    {
        origin = new Point2D.Float(x, y);
    }
    
    public void addToOrigin(Point2D.Float addedVal)
    {
        origin.x += addedVal.x;
        origin.y += addedVal.y;
    }
    
    public void addToOrigin(float x, float y)
    {
        origin.x = x;
        origin.y = y;
    }
}
