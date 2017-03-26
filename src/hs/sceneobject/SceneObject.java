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
    private float xScale = 1;
    private float yScale = 1;

    private Vector2 speed = new Vector2(0, 0);

    public SceneObject(Vector2 gravity)
    {
        this.gravity = gravity;
    }
    public SceneObject(Vector2 gravity, int xScale, int yScale)
    {
        this.gravity = gravity;
        this.xScale = xScale;
        this.yScale = yScale;
    }

    public void update(float deltaTime)
    {
        speed.add(gravity);
        gravity.multiply(deltaTime);
    }

    public Vector2 getGravity()
    {
        return gravity;
    }

    public ArrayList<Point2D> getVertices()
    {
        return vertices;
    }

    public ArrayList<Component> getComponents()
    {
        return components;
    }

    public Point2D getOrigin()
    {
        return origin;
    }
}
