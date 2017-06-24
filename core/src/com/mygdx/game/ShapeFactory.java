package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.EShapes;
import com.mygdx.game.GameShape;

public class ShapeFactory {
    public static GameShape getRectangle(World world, Vector2 position, float width, float height, boolean fixedRotation) {
        Body shapeBody;

        // Create the rectangle`s body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        bodyDef.fixedRotation = fixedRotation;

        // Create a body in the world
        shapeBody = world.createBody(bodyDef);

        // Define the body`s shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);
        shapeBody.createFixture(shape, 1);
        shape.dispose();

        return (new GameShape(shapeBody, EShapes.RECTANGLE));
    }

    public static GameShape getCircle(World world, Vector2 position, float radius, boolean fixedRotation) {
        Body shapeBody;

        // Create the rectangle`s body definition
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);
        bodyDef.fixedRotation = fixedRotation;

        // Create a body in the world
        shapeBody = world.createBody(bodyDef);

        // Define the body`s shape
        CircleShape shape = new CircleShape();
        shape.setRadius(radius);
        shapeBody.createFixture(shape, 1);
        shape.dispose();

        return (new GameShape(shapeBody, EShapes.CIRCLE));
    }

    public static GameShape getRandomShape(World world) {
        // TODO return a random shape
        return (getRectangle(world, new Vector2(50, 50), 32, 32, true));
    }
}
