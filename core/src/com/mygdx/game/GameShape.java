package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Shapes.BaseShapeData;

public class GameShape {
    /* -----------------------------
                Data members
    --------------------------------*/
    private Body shape;
    private BaseShapeData shapeData;

    /* -----------------------------
                Ctors
    --------------------------------*/
    public GameShape(Body shape, BaseShapeData baseShapeData) {
        this.shape = shape;
        this.shapeData = baseShapeData;
    }

    /* -----------------------------
            Getters & Setters
    --------------------------------*/
    public Body getShape() { return shape; }

    public void setShape(Body shape) {
        this.shape = shape;
    }

    public BaseShapeData getShapeData() {
        return shapeData;
    }

    public void setShapeData(BaseShapeData baseShapeData) {
        this.shapeData = baseShapeData;
    }
}
