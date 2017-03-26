package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by hshack on 3/25/17.
 */
public class SceneObject
{

    private Vector2 gravity;
    private ArrayList<Point2D> vertices = new ArrayList<>();
    private Point2D origin = new Point2D.Float();
    private ArrayList<Component> components = new ArrayList<>();
    private float xScale, yScale = 1;

    private Vector2 speed = new Vector2(0, 0);

    /**
     *
     * @param gravity the gravity in units/sec^2 as a vector
     */
    public SceneObject(Vector2 gravity)
    {
        this.gravity = gravity;
    }

    /**
     *
     * @param gravity the gravity in units/sec^2 as a vector
     * @param xScale the scaling of the object on the x-axis
     * @param yScale the scaling of the object on the y-axis
     */
    public SceneObject(Vector2 gravity, int xScale, int yScale)
    {
        this.gravity = gravity;
        this.xScale = xScale;
        this.yScale = yScale;
    }

    /**
     *
     * @param deltaTime
     */
    public void update(float deltaTime)
    {
        speed.add(gravity);
        gravity.multiply(deltaTime);
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
    public ArrayList<Point2D> getVertices()
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
    public Point2D getOrigin()
    {
        return origin;
    }
}
