package com.mygdx.game;

import com.mygdx.game.Shapes.CircleData;
import com.mygdx.game.Shapes.Randomized;
import com.mygdx.game.Shapes.RectangleData;

public enum EShapes {
    RECTANGLE(0), CIRCLE(1);

    /* -----------------------------
                Data members
    --------------------------------*/
    private int value;

    /* -----------------------------
                  Ctors
    --------------------------------*/
    EShapes(int value) { this.value = value; }

    /* -----------------------------
                Functions
    --------------------------------*/
    public int getIndex() {
        return (this.value);
    }
}
