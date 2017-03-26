package hs.sceneobject;

import hs.physics.Vector2;

/**
 * Created by hshack on 3/25/17.
 */
public class Rect extends Polygon
{

    private int numSides = 4;

    public Rect(Vector2 gravity)
    {
        super(gravity);
    }

    public Rect(Vector2 gravity, int xScale, int yScale)
    {
        super(gravity, xScale, yScale);
    }

    public Rect(Vector2 gravity, int xScale, int yScale, boolean hasPhysics, int numSides, int numSides1)
    {
        super(gravity, xScale, yScale, hasPhysics, numSides);
        this.numSides = numSides1;
    }
}
