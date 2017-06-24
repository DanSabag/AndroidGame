package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class ShapeEvader extends ApplicationAdapter {
    //TODO organize project
    //TODO add comments
    private static final boolean DEBUG  = true;
    private int nHeight;
    private int nWidth;

//TODO Debug memory
//	long javaHeap = Gdx.app.getJavaHeap();
//	long nativeHeap = Gdx.app.getNativeHeap();

	private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private World gameWorld;

	@Override
	public void create () {
		// Get screen size
		this.nHeight = Gdx.graphics.getHeight();
		this.nWidth = Gdx.graphics.getWidth();

		this.shapeRenderer = new ShapeRenderer();
		this.camera = new OrthographicCamera(nWidth / 2, nHeight/ 2);
		gameWorld = new World(new Vector2(0, -10f), false);
		//Gdx.input.setInputProcessor(InputHandler.getInputHandler());
	}

	@Override
	public void render () {
	    float deltaTime = Gdx.graphics.getDeltaTime();
		update(deltaTime);
        gameWorld.step(deltaTime, 6, 2);

        // Draw the shapes
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        GameShape gs = ShapeFactory.getRandomShape(gameWorld);
        //TODO what is this shape type
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        ShapeDrawer.getInstance().drawer[gs.getShapeType().ordinal()].draw(shapeRenderer, gs);
        shapeRenderer.end();

		// MANIPULATE SHAPE
//		shapeRenderer.begin(ShapeType.Line);
//		shapeRenderer.identity();
//		shapeRenderer.translate(20, 12, 2);
//		shapeRenderer.rotate(0, 0, 1, 90);
		// This will cause the rect to rotate, then translate
//		shapeRenderer.rect(-width / 2, -height / 2, width, height);
//		shapeRenderer.end();
	}

	@Override
	public void dispose () {
        gameWorld.dispose();
        shapeRenderer.dispose();
	}

	@Override
	public void pause () {

	}

	@Override
	public void resume () {

	}

	private void update (float deltaTime) {

    }
}
