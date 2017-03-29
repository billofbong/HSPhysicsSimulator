package hs.world;

import hs.physics.Vector2;
import hs.sceneobject.Rect;
import hs.sceneobject.SceneObject;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class Scene
{   
    /**
     * Default X Bound
     */
    public static final double DEFAULT_X_BOUND = 10f;
    public static final double DEFAULT_Y_BOUND = 10f;
    
    public static final Scene DEFAULT_SCENE = new Scene();
    
    private ArrayList<SceneObject> sceneObjects;
    private double xBound;
    private double yBound;
    private double x;
    private double y;
    
    public Scene()
    {
    	init(new ArrayList<>(), DEFAULT_X_BOUND, DEFAULT_Y_BOUND, 0f, 0f);
    }
    
    public Scene(double xBound, double yBound)
    {
        init(new ArrayList<>(), xBound, yBound, 0f, 0f);
    }
    
    public Scene(double xBound, double yBound, double x, double y)
    {
        init(new ArrayList<>(), xBound, yBound, x, y);
    }

    public Scene(ArrayList<SceneObject> sceneObjects, double xBound, double yBound)
    {
        init(new ArrayList<>(), xBound, yBound, 0f, 0f);
    }
    public Scene(ArrayList<SceneObject> sceneObjects, double xBound, double yBound, double x, double y)
    {
        init(new ArrayList<>(), xBound, yBound, x, y);
    }

    private void init(ArrayList<SceneObject> sceneObjects, double xBound, double yBound, double x, double y)
    {
        this.sceneObjects = sceneObjects;
        this.xBound = xBound;
        this.yBound = yBound;
        this.x = x;
        this.y = y;
    }
    
    public double getX()
    {
    	return x;
    }
    
    public double getY()
    {
    	return y;
    }
    
    public double getXBound()
    {
        return xBound;
    }
    
    public double getYBound()
    {
        return yBound;
    }

    public ArrayList<SceneObject> getSceneObjects()
    {
        return sceneObjects;
    }

    public void add(SceneObject ... sceneObjects)
    {
        for(SceneObject so : sceneObjects)
        {
            this.sceneObjects.add(so);
        }
    }
}
