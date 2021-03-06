package pl.ogiba.spaceshooter.Engine.Utils.Collisions;


import android.graphics.RectF;

import pl.ogiba.spaceshooter.Engine.Utils.Vector2;

/**
 * Created by robertogiba on 24.10.2017.
 */
public interface ICollisionInterpreter {
    boolean checkForCollision(ICollisionInvoker invoker, Vector2 currentVector, float x, float y);

    boolean checkForCollision(ICollisionInvoker invoker, Vector2 currentVector, RectF sourceRect);
}
