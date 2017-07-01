package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class ShapeEvader extends ApplicationAdapter {
    /* -----------------------------
                Constants
    --------------------------------*/
    private static final float SHAPE_LOAD_DELAY = 1;

    /* -----------------------------
                Data members
    --------------------------------*/
    private int nHeight;
    private int nWidth;
    private float fCurrentTimePassed;

    private ArrayList<GameShape> loadedShapes;

	private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private World gameWorld;

    /* -----------------------------
                Functions
    --------------------------------*/
	@Override
	public void create () {
		// Get screen size
		this.nHeight = Gdx.graphics.getHeight();
		this.nWidth = Gdx.graphics.getWidth();
        this.fCurrentTimePassed = 0;

		if (GameConstants.DEBUG) {
		    Gdx.app.log("Screen size", "width = " + nWidth + " height = " + nHeight);
        }

		loadedShapes = new ArrayList<GameShape>();

		this.shapeRenderer = new ShapeRenderer();
		this.camera = new OrthographicCamera(nWidth / 2, nHeight/ 2);
		gameWorld = new World(new Vector2(0, -20f), false);
		//Gdx.input.setInputProcessor(InputHandler.getInputHandler());
	}

	@Override
	public void render () {
	    float deltaTime = Gdx.graphics.getDeltaTime();
        fCurrentTimePassed += deltaTime;
	    Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.updateWorld();
        gameWorld.step(deltaTime, 6, 2);

        // Draw the shapes
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
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

	private void updateWorld () {
        updateShapes();

        if (loadedShapes.size() == 0 ||
           (loadedShapes.size() < GameConstants.MAX_LOADED_SHAPES &&
           this.fCurrentTimePassed > SHAPE_LOAD_DELAY)) {

            // Reset timer and load new shape
            this.fCurrentTimePassed = 0;
            this.loadedShapes.add(ShapeFactory.getInstance().getRandomShape(this.gameWorld, nWidth, nHeight));
            if (GameConstants.DEBUG) {
                Gdx.app.log("memory", "JavaHeap: " + Gdx.app.getJavaHeap() + " NativeHeap: " + Gdx.app.getNativeHeap());
                Gdx.app.log("Loaded shape", "amount of loaded shapes: " + loadedShapes.size());
            }
        }

        //TODO? what is this shape type
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        // Draw all loaded shapes on the screen
        for (GameShape currShape : this.loadedShapes) {
            ShapeDrawer.getInstance().
                    drawer[currShape.getShapeData().getShapeType().getIndex()]
                    .draw(this.shapeRenderer, currShape);
        }

        shapeRenderer.end();
    }

    private void updateShapes() {
        for (int nShapeIndex = 0; nShapeIndex < this.loadedShapes.size(); nShapeIndex++) {
            GameShape currShape = this.loadedShapes.get(nShapeIndex);

            // Remove out of frame shapes
            if (currShape.getShape().getPosition().y + currShape.getShapeData().getHeight() < -nHeight / 4) {
                if (GameConstants.DEBUG) {
                    Gdx.app.log("Removed shape", this.loadedShapes.get(nShapeIndex).getShapeData().toString());
                    Gdx.app.log("Shape velocity", "velocity: " + this.loadedShapes.get(nShapeIndex).getShape().getLinearVelocity());
                }

                this.gameWorld.destroyBody(this.loadedShapes.get(nShapeIndex).getShape());
                this.loadedShapes.remove(nShapeIndex);
            }
        }
    }
}
