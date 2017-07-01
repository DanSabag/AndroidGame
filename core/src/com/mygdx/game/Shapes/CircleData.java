package com.mygdx.game.Shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameConstants;
import com.mygdx.game.GameShape;
import com.mygdx.game.Utils;

public class CircleData extends BaseShapeData implements Randomized {
    /* -----------------------------
                Consts
    --------------------------------*/
    private static final int MAX_RADIUS = Gdx.graphics.getWidth() / 16;
    private static final int MIN_RADIUS = Gdx.graphics.getWidth() / 32;

    /* -----------------------------
            Data members
    --------------------------------*/
    private float radius;

    /* -----------------------------
                 Ctors
    --------------------------------*/
    public CircleData() {}

    public CircleData(float x, float y, float radius) {
        super(x, y, radius * 2, EShapes.CIRCLE);
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
    public GameShape getRandomGameShapeData(World world, float randomX, float randomY) {
        CircleData circle = new CircleData(randomX,
                randomY,
                Utils.getRandomInteger(MIN_RADIUS, MAX_RADIUS));

        if (GameConstants.DEBUG) {
            Gdx.app.log("Created circle data", circle.toString());
        }

        return new GameShape(null, circle);
    }

    @Override
    public String toString() {
        return (super.toString() + " radius(" + this.radius + ")");
    }
}
