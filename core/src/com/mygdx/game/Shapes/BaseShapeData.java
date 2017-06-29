package com.mygdx.game.Shapes;

import com.mygdx.game.EShapes;

public abstract class BaseShapeData {
    /* -----------------------------
                Data members
    --------------------------------*/
    private float x;
    private float y;
    private EShapes shapeType;

    /* -----------------------------
                Ctors
    --------------------------------*/
    public BaseShapeData() {}

    public BaseShapeData(float x, float y, EShapes shapeType) {
        this.x = x;
        this.y = y;
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

    public EShapes getShapeType() { return shapeType; }

    public void setShapeType(EShapes shapeType) { this.shapeType = shapeType; }
}