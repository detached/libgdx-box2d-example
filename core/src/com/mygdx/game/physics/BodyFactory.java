package com.mygdx.game.physics;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.model.Blob;
import com.mygdx.game.model.Player;

import static com.mygdx.game.physics.ConversionUtil.toMeter;

class BodyFactory {

    private World world;

    BodyFactory(World world) {
        this.world = world;
    }

    Body createBodyFromBlob(Blob blob) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(toMeter(blob.getPosition()));

        CircleShape shape = new CircleShape();
        shape.setRadius(toMeter(blob.getWidth()) / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.1f;

        Body body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);

        shape.dispose();

        return body;
    }

    Body createBodyFromPlayer(Player player) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(toMeter(player.getPosition()));

        CircleShape shape = new CircleShape();
        shape.setRadius(toMeter(player.getWidth()) / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.1f;
        fixtureDef.restitution = 0.1f;

        Body body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);

        shape.dispose();

        return body;
    }
}
