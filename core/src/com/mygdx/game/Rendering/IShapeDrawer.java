package com.mygdx.game.Rendering;

import com.badlogic.gdx.graphics.glutils.*;
import com.mygdx.game.GameShape;

/**
 * Created by dan on 23/06/17.
 */
public interface IShapeDrawer {
    public void draw(ShapeRenderer renderer, GameShape gameShape);
}
