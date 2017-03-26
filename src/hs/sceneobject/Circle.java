package hs.sceneobject;

import hs.physics.Vector2;

/**
 * Created by hshack on 3/25/17.
 */
public class Circle extends Polygon
{

    public Circle(Vector2 gravity)
    {
        super(gravity);
    }

    public Circle(Vector2 gravity, int xScale, int yScale)
    {
        super(gravity, xScale, yScale);
    }
}
