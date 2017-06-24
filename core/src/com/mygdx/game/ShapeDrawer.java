package com.mygdx.game.Rendering;

import com.mygdx.game.EShapes;

/**
 * Created by dan on 24/06/17.
 */
public class ShapeDrawer {
    private static final int NUM_OF_SHAPES = 2;

    private static ShapeDrawer shapeRenderer = new ShapeDrawer();

    public com.mygdx.game.Rendering.IShapeDrawer drawer[];

    public static ShapeDrawer getInstance() {return (shapeRenderer); }

    private ShapeDrawer() {
        this.drawer = new com.mygdx.game.Rendering.IShapeDrawer[NUM_OF_SHAPES];
        // TODO make array better
        this.drawer[EShapes.RECTANGLE.ordinal()] = (renderer, gameShape) -> {
            renderer.rect(50, 50, 32, 32);
            
        };
    }
}
