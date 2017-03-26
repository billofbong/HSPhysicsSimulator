package hs.world;

import hs.sceneobject.SceneObject;

import java.util.ArrayList;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class Scene
{
    public static final Scene DEFAULT_SCENE = new Scene(1);
    
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
        init(sceneObjects, xBound, xBound / 16 * 9);
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

    public void add(SceneObject ... sceneObjects)
    {
        for(SceneObject so : sceneObjects)
        {
            this.sceneObjects.add(so);
        }
    }
}
