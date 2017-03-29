package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by hshack on 3/25/17.
 */
public class Circle extends Polygon
{

    public Circle(Vector2 gravity, Point2D.Float origin)
    {
        super(gravity, origin);
    }

    public Circle(Vector2 gravity, Point2D.Float origin, int xScale, int yScale)
    {
        super(gravity, origin, xScale, yScale);
    }

    public Circle(Vector2 gravity, Point2D.Float origin, float xScale, float yScale, boolean hasPhysics, int numSides)
    {
        super(gravity, origin, xScale, yScale, hasPhysics, numSides);
    }
}
