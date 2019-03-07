package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class World {

    private final Player player;
    private final Collection<Blob> blobs;

    private World(Player player, Collection<Blob> blobs) {
        this.player = player;
        this.blobs = blobs;
    }

    public static World createWorld() {

        var player = new Player(new Vector2(0 + Player.SIZE / 2,0 + Player.SIZE / 2));

        Collection<Blob> blobs = new HashSet<>();

        var width = Gdx.graphics.getWidth();
        var height = Gdx.graphics.getHeight();
        var random = new Random();

        for (int i = 0; i < 10; i++) {

            var randx = random.nextInt(width - Math.round(Blob.SIZE));
            var randy = random.nextInt(height - Math.round(Blob.SIZE));

            var blob = new Blob(new Vector2(randx, randy));

            blobs.add(blob);
        }

        return new World(player, blobs);
    }

    public Player getPlayer() {
        return player;
    }

    public Collection<Blob> getBlobs() {
        return blobs;
    }
}
