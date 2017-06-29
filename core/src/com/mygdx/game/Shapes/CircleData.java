package com.mygdx.game.Shapes;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameShape;
import com.mygdx.game.Utils;

public class CircleData extends BaseShapeData implements Randomized {
    /* -----------------------------
                Consts
    --------------------------------*/
    private static final float MAX_RADIUS = 40;
    private static final float MIN_RADIUS = 15;

    /* -----------------------------
            Data members
    --------------------------------*/
    private float radius;

    /* -----------------------------
                 Ctors
    --------------------------------*/
    public CircleData() {}

    public CircleData(float x, float y, float radius) {
        super(x, y, EShapes.CIRCLE);
        this.radius = radius;
    }

    /* -----------------------------
                Getters & Setters
        --------------------------------*/
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    /* -----------------------------
                Functions
    --------------------------------*/
    @Override
    public GameShape getRandomGameShape(World world, float randomX, float randomY) {
        float fRadiusMeanAndVariance = (MAX_RADIUS + MIN_RADIUS) / 2f;

        CircleData circle = new CircleData(randomX,
                randomY,
                Utils.getGussian(fRadiusMeanAndVariance, fRadiusMeanAndVariance));

        return new GameShape(null, circle);
    }
}
