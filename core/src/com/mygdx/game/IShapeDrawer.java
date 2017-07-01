package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.*;
import com.mygdx.game.GameShape;

/**
 * Created by dan on 23/06/17.
 */
public interface IShapeDrawer {
    void draw(ShapeRenderer renderer, GameShape gameShape);
}
