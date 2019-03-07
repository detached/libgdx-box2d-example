package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {

    static final float SIZE = 64;

    Player(Vector2 position) {
        super(position, SIZE, SIZE);
    }
}
