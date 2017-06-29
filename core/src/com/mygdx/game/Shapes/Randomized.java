package com.mygdx.game.Shapes;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameShape;

public interface Randomized {
    public GameShape getRandomGameShape(World world, float randomX, float randomY);
}
