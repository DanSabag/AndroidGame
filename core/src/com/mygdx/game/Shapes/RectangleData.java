package com.mygdx.game.Shapes;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameShape;
import com.mygdx.game.Utils;

public class RectangleData extends BaseShapeData implements Randomized {
    /* -----------------------------
                Constants
    --------------------------------*/
    public static final float MAX_HEIGHT = 70;
    public static final float MAX_WIDTH = 70;
    public static final float MIN_HEIGHT = 20;
    public static final float MIN_WIDTH = 20;

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
        super(x, y, EShapes.RECTANGLE);
        this.height = height;
        this.width = width;
    }

    /* -----------------------------
                    Getters & Setters
            --------------------------------*/
    public float getHeight() {
        return height;
    }

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
    public GameShape getRandomGameShape(World world, float randomX, float randomY) {
        float fHeightMeanAndVariance = (MAX_HEIGHT + MIN_HEIGHT) / 2f;
        float fWidthMeanAndVariance = (MAX_WIDTH + MIN_WIDTH) / 2f;

        RectangleData rect = new RectangleData(randomX,
                                randomY,
                                Utils.getGussian(fHeightMeanAndVariance, fHeightMeanAndVariance),
                                Utils.getGussian(fWidthMeanAndVariance, fWidthMeanAndVariance));

        return new GameShape(null, rect);
    }
}
