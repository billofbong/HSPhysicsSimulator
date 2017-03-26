package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by hshack on 3/25/17.
 */
public class Rect extends Polygon
{

    private int numSides = 4;


    public Rect(Vector2 gravity, Point2D.Float origin)
    {
        super(gravity, origin);
        addVertices();
    }

    public Rect(Vector2 gravity, Point2D.Float origin, int xScale, int yScale)
    {
        super(gravity, origin, xScale, yScale);
        addVertices();
    }

    public Rect(Vector2 gravity, Point2D.Float origin, int xScale, int yScale, boolean hasPhysics, int numSides)
    {
        super(gravity, origin, xScale, yScale, hasPhysics, numSides);
        addVertices();
    }

    private void addVertices()
    {
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
    }
}
