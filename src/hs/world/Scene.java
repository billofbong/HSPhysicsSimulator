package hs.world;

import hs.sceneobject.SceneObject;

import java.util.ArrayList;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class Scene
{

    private ArrayList<SceneObject> sceneObjects = new ArrayList<>();

    public Scene(ArrayList<SceneObject> sceneObjects)
    {
        this.sceneObjects = sceneObjects;
    }
}
