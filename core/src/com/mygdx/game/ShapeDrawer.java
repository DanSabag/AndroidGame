package com.mygdx.game;

public class ShapeDrawer {
    private static ShapeDrawer shapeRenderer = new ShapeDrawer();

    public IShapeDrawer drawer[];

    public static ShapeDrawer getInstance() {return (shapeRenderer); }

    private ShapeDrawer() {
        this.drawer = new IShapeDrawer[GameConstants.NUM_OF_SHAPES];
        //TODO get shape dimens
        // ions from gameShape
        this.drawer[EShapes.RECTANGLE.getIndex()] = (renderer, gameShape) -> {
            renderer.rect(50, 50, 32, 32);

        };
    }
}
