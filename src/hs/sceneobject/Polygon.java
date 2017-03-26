package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by hshack on 3/25/17.
 */
public class Polygon extends SceneObject
{
    private int numSides;

    public Polygon(Vector2 gravity, Point2D.Float origin)
    {
        super(gravity, origin);
    }

    public Polygon(Vector2 gravity, Point2D.Float origin, int xScale, int yScale)
    {
        super(gravity, origin, xScale, yScale);
    }

    public Polygon(Vector2 gravity, Point2D.Float origin, int numSides, int xScale, int yScale)
    {
        super(gravity, origin, xScale, yScale);
    }

    public Polygon(Vector2 gravity, Point2D.Float origin, int xScale, int yScale, boolean hasPhysics, int numSides)
    {
        super(gravity, origin, xScale, yScale, hasPhysics);
        this.numSides = numSides;
    }
}
