package com.mygdx.game;

public enum EShapes {
    RECTANGLE(0), CIRCLE(1);

    private int value;

    EShapes(int value) {
        this.value = value;
    }

    public int getIndex() {
        return (this.value);
    }
}
