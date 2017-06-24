package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by dan on 23/06/17.
 */
public class GameShape {
    private Body shape;
    private EShapes shapeType;

    public GameShape(Body shape, EShapes shapeType) {
        this.shape = shape;
        this.shapeType = shapeType;
    }

    public Body getShape() {
        return shape;
    }

    public EShapes getShapeType() {
        return shapeType;
    }

    public void setShape(Body shape) {
        this.shape = shape;
    }

    public void setShapeType(EShapes shapeType) {
        this.shapeType = shapeType;
    }
}
