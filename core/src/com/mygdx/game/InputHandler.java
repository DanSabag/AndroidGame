package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.sun.corba.se.spi.orbutil.fsm.Input;

/**
 * Created by dan on 17/06/17.
 */
public class InputHandler implements InputProcessor {

    private static InputHandler inputHandler;

    private InputHandler() {

    }

    public static InputHandler getInputHandler() {
        if (inputHandler == null) {
            inputHandler = new InputHandler();
        }

        return (inputHandler);
    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)  {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)  {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode)  {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)  {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
