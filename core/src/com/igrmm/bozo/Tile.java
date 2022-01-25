package com.igrmm.bozo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends GameObject {
	public static final int TILE_SIZE = 8;

	public enum TileType {FLAT_TOP, FLAT_RIGHT, FLAT_BOTTOM, FLAT_LEFT}

	private final TileType tileType;
	private final int srcX, srcY;
	private final Texture tileset;

	public Tile(Texture tileset, float x, float y, TileType tileType) {
		this.rectangle.x = x;
		this.rectangle.y = y;
		this.tileset = tileset;
		this.tileType = tileType;

		switch (tileType) {
			case FLAT_TOP:
				this.srcX = TILE_SIZE;
				this.srcY = 0;
				break;

			case FLAT_RIGHT:
				this.srcX = 2 * TILE_SIZE;
				this.srcY = TILE_SIZE;
				break;

			case FLAT_BOTTOM:
				this.srcX = TILE_SIZE;
				this.srcY = 2 * TILE_SIZE;
				break;

			case FLAT_LEFT:
				this.srcX = 0;
				this.srcY = TILE_SIZE;
				break;

			default:
				throw new IllegalStateException("Undefined tileType.");
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(tileset, rectangle.x, rectangle.y, srcX, srcY, TILE_SIZE, TILE_SIZE);
	}
}
