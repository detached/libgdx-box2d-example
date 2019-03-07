package com.mygdx.game.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.model.Entity;

import java.util.HashSet;
import java.util.Set;

import static com.mygdx.game.physics.ConversionUtil.toPixel;

public class PhysicSimulation {

    private final World box2dWorld;
    private final Set<Body> bodies = new HashSet<>();

    private boolean debug;
    private Matrix4 debugMatrix;
    private Box2DDebugRenderer box2DDebugRenderer;

    public PhysicSimulation(com.mygdx.game.model.World modelWorld, boolean debug) {
        this.debug = debug;

        Box2D.init();
        this.box2dWorld = new World(Vector2.Zero, true);


        if (debug) {
            box2DDebugRenderer = new Box2DDebugRenderer();
        }

        var bodyFactory = new BodyFactory(box2dWorld);

        addPlayerBodyToWorld(modelWorld, bodyFactory);
        addBlobBodiesToWorld(modelWorld, bodyFactory);
    }

    public void update() {

        box2dWorld.step(1f / 60f, 6, 2);
        bodies.forEach(body -> {

            var entity = (Entity) body.getUserData();
            entity.setPosition(toPixel(body.getPosition()));
        });
    }

    public boolean isDebugEnabled() {
        return debug;
    }

    public void drawDebug() {

        box2DDebugRenderer.render(box2dWorld, debugMatrix);
    }

    public void setDebugMatrix(Matrix4 debugMatrix) {

        this.debugMatrix = debugMatrix;
    }

    private void addBlobBodiesToWorld(com.mygdx.game.model.World modelWorld, BodyFactory bodyFactory) {

        modelWorld.getBlobs().forEach(blob -> {
            var blobBody = bodyFactory.createBodyFromBlob(blob);
            blobBody.setUserData(blob);
            bodies.add(blobBody);
        });
    }

    private void addPlayerBodyToWorld(com.mygdx.game.model.World modelWorld, BodyFactory bodyFactory) {

        var player = modelWorld.getPlayer();
        var playerBody = bodyFactory.createBodyFromPlayer(player);
        playerBody.setUserData(player);

        Gdx.input.setInputProcessor(new TouchControl(playerBody));

        bodies.add(playerBody);
    }
}
