package pl.ogiba.spaceshooter.Engine.Utils;

/**
 * Created by robertogiba on 23.10.2017.
 */

public class Vector2 {
    public float x;
    public float y;

    public Vector2(){
    }
    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2 normalize(){
        float vectorLenght = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return new Vector2(x/vectorLenght, y/vectorLenght);
    }

    public static Vector2 createVector2FromTwoPoints(float xA, float yA, float xB, float yB){
        return new Vector2(xB-xA, yB-yA);
    }

    public Vector2 add(Vector2 sum){
        return new Vector2(x + sum.x, y + sum.y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
