package com.igrmm.bozo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends GameObject {
	public static final int TILE_SIZE = 8;

	public enum TileType {FLAT_TOP, FLAT_RIGHT, FLAT_BOTTOM, FLAT_LEFT}

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