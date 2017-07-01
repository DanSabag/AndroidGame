package com.mygdx.game.Shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameConstants;
import com.mygdx.game.GameShape;
import com.mygdx.game.Utils;

public class RectangleData extends BaseShapeData implements Randomized {
    /* -----------------------------
                Constants
    --------------------------------*/
    public static final int MAX_HEIGHT = 70;
    public static final int MAX_WIDTH = 70;
    public static final int MIN_HEIGHT = 30;
    public static final int MIN_WIDTH = 30;

    /* -----------------------------
                Data members
    --------------------------------*/
    private float height;
    private float width;

    /* -----------------------------
                 Ctors
    --------------------------------*/
    public RectangleData() {}

    public RectangleData(float x, float y, float height, float width) {
        super(x, y, height, EShapes.RECTANGLE);
        this.height = height;
        this.width = width;
    }

    /* -----------------------------
                    Getters & Setters
            --------------------------------*/
    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    /* -----------------------------
                Functions
    --------------------------------*/
    @Override
    public GameShape getRandomGameShapeData(World world, float randomX, float randomY) {
        RectangleData rect = new RectangleData(randomX,
                                randomY,
                                Utils.getRandomInteger(MIN_HEIGHT, MAX_HEIGHT),
                                Utils.getRandomInteger(MIN_WIDTH, MAX_WIDTH));

        if (GameConstants.DEBUG) {
            Gdx.app.log("Created rectangle data", rect.toString());
        }

        return new GameShape(null, rect);
    }

    @Override
    public String toString() {
        return (super.toString() + " dimesions(w:" + this.width + ", h:" + this.height + ")");
    }
}
