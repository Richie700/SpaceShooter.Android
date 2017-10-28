package pl.ogiba.spaceshooter.Engine.Physics;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by robertogiba on 28.10.2017.
 */

public class World {
    private ArrayList<Body> items;
    @Nullable
    private OnCollisionListener collisionCallback;

    public World() {
        this.items = new ArrayList<>();
    }

    public void update() {
        for (int i = 0; i < items.size(); i++) {
            final Body item = items.get(i);
            item.update();

            checkCollisionsWithItems(i);

            if (item.isDestroyed()) {
                items.remove(i);
                i--;
            }
        }
    }

    public void checkCollisionsWithItems(int position) {
        final Body item1 = items.get(position);
        for (int j = position + 1; j < items.size(); j++) {
            final Body item2 = items.get(j);

            if (item1.getRect().intersect(item2.getRect()))
                invokeCollisionCallback(item1, item2);
        }
    }

    private void invokeCollisionCallback(Body source, Body dest) {
        if (collisionCallback == null)
            return;

        collisionCallback.onCollision(source, dest);
    }

    private Body createBody() {
        final Body body = new Body(this);
        items.add(body);
        return body;
    }

    public ArrayList<Body> getItems() {
        return items;
    }

    public void setCollisionCallback(@Nullable OnCollisionListener collisionCallback) {
        this.collisionCallback = collisionCallback;
    }
}
