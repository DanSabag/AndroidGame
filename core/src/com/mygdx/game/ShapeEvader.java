package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class ShapeEvader extends ApplicationAdapter {
    /* -----------------------------
                Data members
    --------------------------------*/
    //TODO 1 Change max size of circle
    //TODO 2 track shape removal
    //TODO 3 organize project
    //TODO 4 add comments
    private static final boolean DEBUG  = true;
    private int nHeight;
    private int nWidth;

    private ArrayList<GameShape> loadedShapes;

//TODO? Debug memory
//	long javaHeap = Gdx.app.getJavaHeap();
//	long nativeHeap = Gdx.app.getNativeHeap();

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

		loadedShapes = new ArrayList<GameShape>();

		this.shapeRenderer = new ShapeRenderer();
		this.camera = new OrthographicCamera(nWidth / 2, nHeight/ 2);
		gameWorld = new World(new Vector2(0, -10f), false);
		//Gdx.input.setInputProcessor(InputHandler.getInputHandler());
	}

	@Override
	public void render () {
	    float deltaTime = Gdx.graphics.getDeltaTime();
        this.updateWorld();
        gameWorld.step(deltaTime, 6, 2);

        // Draw the shapes
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

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

	private void updateWorld () {
        removeOutOfFrameShapes();

        // Load the amount of missing shapes to the world
        int numOfRequiredShapes = GameConstants.MAX_LOADED_SHAPES - loadedShapes.size();
        if (numOfRequiredShapes > 0) {
            loadRandomShapes(numOfRequiredShapes);
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

    private void loadRandomShapes(int numOfRequiredShapes) {
        for (;numOfRequiredShapes > 0; numOfRequiredShapes--) {
            this.loadedShapes.add(ShapeFactory.getInstance()
                    .getRandomShape(this.gameWorld, nWidth, nHeight));
        }
    }

    private void removeOutOfFrameShapes() {
        for (GameShape currShape : this.loadedShapes) {
            if (currShape.getShapeData().getY() < 0) {
                this.gameWorld.destroyBody(currShape.getShape());
            }
        }
    }
}
