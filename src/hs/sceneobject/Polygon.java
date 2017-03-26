package hs.sceneobject;

import hs.physics.Vector2;

/**
 * Created by hshack on 3/25/17.
 */
public class Polygon extends SceneObject
{
    private int numSides;

    public Polygon(Vector2 gravity)
    {
        super(gravity);
    }

    public Polygon(Vector2 gravity, int xScale, int yScale)
    {
        super(gravity, xScale, yScale);
    }

    public Polygon(Vector2 gravity, int numSides, int xScale, int yScale)
    {
        super(gravity, xScale, yScale);
    }

}
