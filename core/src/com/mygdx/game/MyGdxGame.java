package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.World;
import com.mygdx.game.physics.PhysicSimulation;
import com.mygdx.game.view.WorldRenderer;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch spriteBatch;

    private World world;

    private WorldRenderer worldRenderer;
    private PhysicSimulation physicSimulation;

    @Override
    public void create() {

        world = World.createWorld();

        spriteBatch = new SpriteBatch();

        worldRenderer = new WorldRenderer(spriteBatch);

        physicSimulation = new PhysicSimulation(world, true);
    }

    @Override
    public void render() {

        physicSimulation.update();

        clear();

        if (physicSimulation.isDebugEnabled()) {
            physicSimulation.setDebugMatrix(spriteBatch.getProjectionMatrix());
        }

        worldRenderer.renderWorld(world);

        if (physicSimulation.isDebugEnabled()) {
            physicSimulation.drawDebug();
        }
    }

    private void clear() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
