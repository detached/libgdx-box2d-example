package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;

class Textures {

    private final Texture playerTexture;
    private final Texture blobTexture;

    Textures() {

        playerTexture = new Texture("circle-red.png");
        blobTexture = new Texture("circle.png");
    }

    Texture getPlayerTexture() {
        return playerTexture;
    }

    Texture getBlobTexture() {
        return blobTexture;
    }
}
