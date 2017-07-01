package com.mygdx.game.Shapes;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.EShapes;

public abstract class BaseShapeData {
    /* -----------------------------
                Data members
    --------------------------------*/
    private float x;
    private float y;
    private float height;
    private EShapes shapeType;

    /* -----------------------------
                Ctors
    --------------------------------*/
    public BaseShapeData() {}

    public BaseShapeData(float x, float y, float height, EShapes shapeType) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.shapeType = shapeType;
    }

    /* -----------------------------
            Getters & Setters
    --------------------------------*/
    public float getX() {
        return x;
    }

    public void setX(float x) { this.x = x; }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getHeight() { return height; }

    public void setHeight(float height) { this.height = height; }

    public EShapes getShapeType() { return shapeType; }

    public void setShapeType(EShapes shapeType) { this.shapeType = shapeType; }

    /* -----------------------------
                Functions
    --------------------------------*/

    @Override
    public String toString() {
        return ("position(x:" + this.x+ ", y:" + this.y + ")");
    }
}