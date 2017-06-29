package com.mygdx.game;

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
            renderer.rect(rectData.getX(), rectData.getY(), rectData.getWidth(), rectData.getHeight());
        };
        this.drawer[EShapes.CIRCLE.getIndex()] = (renderer, gameShape) -> {
            CircleData circleData = (CircleData) gameShape.getShapeData();
            renderer.circle(circleData.getX(), circleData.getY(), circleData.getRadius());
        };
    }

    /* -----------------------------
            Getter & Setters
    --------------------------------*/
    public static ShapeDrawer getInstance() {return (shapeRenderer); }
}