package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

public class Blob extends Entity {

    static final float SIZE = 64;

    Blob(Vector2 position) {
        super(position, SIZE, SIZE);
    }
}
