package hs.physics;

/**
 * @author Corbin Naderzad
 * @author Will Wright
 */
public class Vector2
{

    private float x;
    private float y;

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = x;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void add(Vector2 v2)
    {
        setX(this.getX() + v2.getX());
        setY(this.getX() + v2.getY());
    }

    public void add(float v2)
    {
        setX(this.getX() + v2);
        setY(this.getX() + v2);
    }

    public static Vector2 createAddedVector(Vector2 ... vector2s)
    {
        Vector2 finalVector = new Vector2(0 ,0);

        for(Vector2 v : vector2s)
        {
            finalVector.add(v);
        }

        return finalVector;
    }

    public void multiply(Vector2 v2)
    {
        setX(this.getX() * v2.getX());
        setY(this.getX() * v2.getY());
    }

    public void multiply(float v2)
    {
        setX(this.getX() * v2);
        setY(this.getX() * v2);
    }

    public static Vector2 createMultipliedVector(Vector2 ... vector2s)
    {
        Vector2 finalVector = new Vector2(0 ,0);

        for(Vector2 v : vector2s)
        {
            finalVector.multiply(v);
        }

        return finalVector;
    }
    @Override
    public String toString()
    {
        return "{" + getX() + ", " + getY() + "}";
    }

}
