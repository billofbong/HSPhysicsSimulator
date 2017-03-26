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
    public static final Scene DEFAULT_SCENE = new Scene(1);

    public static final Scene DEMO_SCENE;

    static
    {
         DEMO_SCENE = new Scene(1);
         DEMO_SCENE.add(new Rect(new Vector2(0, -1f), new Point2D.Float(0, 0), .1f, .1f));
    }
    
    private ArrayList<SceneObject> sceneObjects;
    private double xBound, yBound;

    public Scene(double xBound)
    {
        init(new ArrayList<>(), xBound, xBound);
    }

    public Scene(double xBound, double yBound)
    {
        init(new ArrayList<>(), xBound, yBound);
    }

    public Scene(ArrayList<SceneObject> sceneObjects, double xBound)
    {
        init(sceneObjects, xBound, xBound);
    }

    public Scene(ArrayList<SceneObject> sceneObjects, double xBound, double yBound)
    {
        init(new ArrayList<>(), xBound, yBound);
    }

    private void init(ArrayList<SceneObject> sceneObjects, double xBound, double yBound)
    {
        this.sceneObjects = sceneObjects;
        this.xBound = xBound;
        this.yBound = yBound;
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

    public void updateAllSceneObjects(double delta, double time, long frames)
    {
        for (SceneObject so: sceneObjects)
        {
            so.updatePhysics(delta, time, frames);
        }
    }
}
