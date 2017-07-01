package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Shapes.CircleData;
import com.mygdx.game.Shapes.RectangleData;

public class ShapeDrawer {
    /* -----------------------------
            Data members
    --------------------------------*/
    private static ShapeDrawer shapeRenderer = new ShapeDrawer();

    public IShapeDrawer drawer[];

    /* -----------------------------
                Ctors
    --------------------------------*/
    private ShapeDrawer() {
        this.drawer = new IShapeDrawer[GameConstants.NUM_OF_SHAPES];
        this.drawer[EShapes.RECTANGLE.getIndex()] = (renderer, gameShape) -> {
            RectangleData rectData = (RectangleData) gameShape.getShapeData();
            Body rectBody = gameShape.getShape();
            renderer.rect(rectBody.getPosition().x, rectBody.getPosition().y, rectData.getWidth(), rectData.getHeight());
        };
        this.drawer[EShapes.CIRCLE.getIndex()] = (renderer, gameShape) -> {
            CircleData circleData = (CircleData) gameShape.getShapeData();
            Body circleBody = gameShape.getShape();
            renderer.circle(circleBody.getPosition().x, circleBody.getPosition().y, circleData.getRadius());
        };
    }

    /* -----------------------------
            Getter & Setters
    --------------------------------*/
    public static ShapeDrawer getInstance() {return (shapeRenderer); }
}