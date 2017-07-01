package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameShape;
import com.mygdx.game.Shapes.CircleData;
import com.mygdx.game.Shapes.Randomized;
import com.mygdx.game.Shapes.RectangleData;

public class ShapeFactory {

    private static ShapeFactory shapeFactory = new ShapeFactory();
    private Randomized factory[];

    /* -----------------------------
                Ctors
    --------------------------------*/
    private ShapeFactory() {
        this.factory = new Randomized[GameConstants.NUM_OF_SHAPES];
        this.factory[EShapes.RECTANGLE.getIndex()] = (world, randomX, randomY) -> (
                this.initRectangleBody(
                        (new RectangleData()).getRandomGameShapeData(world, randomX, randomY),
                        world,
                        false
                )
        );
        this.factory[EShapes.CIRCLE.getIndex()] = (world, randomX, randomY) -> (
                this.initCircleBody(
                        (new CircleData()).getRandomGameShapeData(world, randomX, randomY),
                        world,
                        false
                )
        );
    }

    /* -----------------------------
            Getters & Setters
    --------------------------------*/
    public static ShapeFactory getInstance() {return (shapeFactory); }

    public GameShape initRectangleBody(GameShape rect, World world, boolean fixedRotation) {
        Body shapeBody;
        RectangleData rectData = (RectangleData) rect.getShapeData();

        // Create the rectangle`s body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(rectData.getX(), rectData.getY());
        bodyDef.fixedRotation = fixedRotation;

        // Create a body in the world
        shapeBody = world.createBody(bodyDef);

        // Define the body`s shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(rectData.getWidth() / 2, rectData.getHeight() / 2);
        shapeBody.createFixture(shape, 1);
        shape.dispose();

        rect.setShape(shapeBody);

        return (rect);
    }

    private GameShape initCircleBody(GameShape circle, World world, boolean fixedRotation) {
        Body shapeBody;
        CircleData circleData = (CircleData) circle.getShapeData();

        // Create the rectangle`s body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(circleData.getX(), circleData.getY());
        bodyDef.fixedRotation = fixedRotation;

        // Create a body in the world
        shapeBody = world.createBody(bodyDef);

        // Define the body`s shape
        CircleShape shape = new CircleShape();
        shape.setRadius(circleData.getRadius());
        shapeBody.createFixture(shape, 1);
        shape.dispose();

        circle.setShape(shapeBody);

        return (circle);
    }

    public GameShape getRandomShape(World world, int screenWidth, int screenHeight) {
        int shapeIndex = Utils.getRandomInteger(0, GameConstants.NUM_OF_SHAPES);

        GameShape randomShape = this.factory[shapeIndex].getRandomGameShapeData(
                world,
                Utils.getRandomInteger(-screenWidth / 4 + screenWidth / 16, screenWidth / 4 + screenWidth / 16),
                screenHeight / 4 + GameConstants.MAX_SHAPE_HEIGHT
        );

        return (randomShape);
    }
}
