package com.mygdx.game.physics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

class ConversionUtil {

    private static final float PIXEL_TO_METER = 100f;

    static Vector2 toMeter(Vector2 pixel) {

        return new Vector2(toMeter(pixel.x), toMeter(pixel.y));
    }

    static float toMeter(float pixel) {

        return pixel / PIXEL_TO_METER;
    }

    static Matrix4 toMeter(Matrix4 pixel) {

        return pixel.cpy();
    }

    static Vector2 toPixel(Vector2 meter) {

        return meter.cpy().scl(PIXEL_TO_METER);
    }
}
