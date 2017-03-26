package hs.sceneobject;

import hs.physics.Vector2;
import hs.sceneobject.component.Component;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by hshack on 3/25/17.
 */
public class SceneObject
{

    protected Vector2 gravity;
    protected ArrayList<Point2D.Float> vertices = new ArrayList<>();
    protected Point2D.Float origin;
    protected ArrayList<Component> components = new ArrayList<>();
    protected float xScale = 1f, yScale = 1f;
    protected boolean hasPhysics = true;

    private Vector2 velocity = new Vector2(0, 0);

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
    public SceneObject(Vector2 gravity, Point2D.Float origin, int xScale, int yScale)
    {
        this.gravity = gravity;
        this.origin = origin;
        this.xScale = xScale;
        this.yScale = yScale;
    }

    public SceneObject(Vector2 gravity, Point2D.Float origin, int xScale, int yScale, boolean hasPhysics)
    {
        this.gravity = gravity;
        this.origin = origin;
        this.xScale = xScale;
        this.yScale = yScale;
        this.hasPhysics = hasPhysics;
    }

    /**
     *
     * @param deltaTime
     */
    public void update(double deltaTime)
    {
        velocity.add(gravity);
        gravity.multiply((float) deltaTime);
    }

    /**
     *
     * @return gravity as Vector2
     */
    public Vector2 getGravity()
    {
        return gravity;
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
}
