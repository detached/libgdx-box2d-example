package com.mygdx.game.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import static com.mygdx.game.physics.ConversionUtil.toMeter;

public class TouchControl implements InputProcessor {

    private final Body body;

    TouchControl(Body body) {
        this.body = body;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        var source = body.getPosition();
        var target = new Vector2(toMeter(screenX), toMeter((screenY - Gdx.graphics.getHeight()) * -1));
        var force = target.sub(source).scl(5);

        Gdx.app.log(this.getClass().getName(), String.format("velocity (%s)", force));

        body.applyForceToCenter(force, true);

        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
