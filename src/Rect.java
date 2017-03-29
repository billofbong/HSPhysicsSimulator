package hs.sceneobject;

import hs.physics.Vector2;

import java.awt.geom.Point2D;

/**
 * @author Will Wright
 */
public class Rect extends Polygon
{

    private int numSides = 4;


    public Rect(Vector2 gravity, Point2D.Float origin)
    {
        super(gravity, origin);
        vertices.add(new Point2D.Float(-xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, -yScale));
        vertices.add(new Point2D.Float(-xScale, -yScale));
    }

    public Rect(Vector2 gravity, Point2D.Float origin, float xScale, float yScale)
    {
        super(gravity, origin, xScale, yScale);
        
        /*
        vertices.add(new Point2D.Float(-xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, -yScale));
        vertices.add(new Point2D.Float(-xScale, -yScale));
        //*/
        
        /*
        vertices.add(new Point2D.Float(0, yScale));
        vertices.add(new Point2D.Float(xScale / 2, yScale / 2));
        vertices.add(new Point2D.Float(-xScale / 2, yScale / 2));
        //*/
    }

    public Rect(Vector2 gravity, Point2D.Float origin, float xScale, float yScale, boolean hasPhysics, int numSides)
    {
        super(gravity, origin, xScale, yScale, hasPhysics, numSides);
        vertices.add(new Point2D.Float(-xScale, yScale));
        vertices.add(new Point2D.Float(xScale, yScale));
        vertices.add(new Point2D.Float(xScale, -yScale));
        vertices.add(new Point2D.Float(-xScale, -yScale));
    }
}
