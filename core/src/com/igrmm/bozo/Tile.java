package com.igrmm.bozo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends GameObject {

	public enum TileType {TOP_FLAT, RIGHT_FLAT, BOTTOM_FLAT, LEFT_FLAT}

	private final TileType tileType;

	public Tile(float x, float y, TileType tileType) {
		this.rectangle.x = x;
		this.rectangle.y = y;
		this.tileType = tileType;
	}

	@Override
	public void render(SpriteBatch batch) {
	}
}
