package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by hshack on 3/25/17.
 */
public class Triangle extends Polygon
{

    public Triangle(Vector2 gravity, Point2D.Float origin)
    {
        super(gravity, origin);
    }

    public Triangle(Vector2 gravity, Point2D.Float origin, float xScale, float yScale)
    {
        super(gravity, origin, xScale, yScale);
    }

    public Triangle(Vector2 gravity, Point2D.Float origin, float xScale, float yScale, boolean hasPhysics, int numSides)
    {
        super(gravity, origin, xScale, yScale, hasPhysics, numSides);
    }
}
