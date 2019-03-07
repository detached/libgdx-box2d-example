package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    private Vector2 position;
    private float width, height;

    Entity(Vector2 position, float width, float height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
