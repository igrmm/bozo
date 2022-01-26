package com.igrmm.bozo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
	public final Rectangle rectangle = new Rectangle();

	public boolean overlaps(Rectangle r) {
		return this.rectangle.overlaps(r);
	}

	public abstract void draw(SpriteBatch batch);
}
