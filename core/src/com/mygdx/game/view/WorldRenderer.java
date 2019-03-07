package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Blob;
import com.mygdx.game.model.Entity;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.World;

import java.util.Collection;

public class WorldRenderer {

    private final Textures textures;
    private final SpriteBatch batch;

    public WorldRenderer(SpriteBatch batch) {
        this.batch = batch;
        this.textures = new Textures();
    }

    public void renderWorld(World world) {

        batch.begin();

        renderPlayer(world.getPlayer());
        renderBlobs(world.getBlobs());

        batch.end();
    }

    private void renderBlobs(Collection<Blob> blobs) {

        var texture = textures.getBlobTexture();
        blobs.forEach(blob -> drawEntity(blob, texture));
    }

    private void renderPlayer(Player player) {

        drawEntity(player, textures.getPlayerTexture());
    }

    private void drawEntity(Entity entity, Texture texture) {
        batch.draw(texture, entity.getPosition().x - entity.getWidth() / 2,
                entity.getPosition().y - entity.getHeight() / 2);
    }
}
