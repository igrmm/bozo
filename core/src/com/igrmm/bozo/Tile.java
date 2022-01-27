package com.igrmm.bozo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends GameObject {
	public static final int TILE_SIZE = 8;

	public enum TileType {
		FLAT_TOP(TILE_SIZE, 0),
		FLAT_RIGHT(2 * TILE_SIZE, TILE_SIZE),
		FLAT_BOTTOM(TILE_SIZE, 2 * TILE_SIZE),
		FLAT_LEFT(0, TILE_SIZE);

		public final int srcX, srcY;

		TileType(int srcX, int srcY) {
			this.srcX = srcX;
			this.srcY = srcY;
		}
	}

	private final TileType tileType;
	private final Texture tileset;

	public Tile(Texture tileset, float x, float y, TileType tileType) {
		this.rectangle.x = x;
		this.rectangle.y = y;
		this.tileset = tileset;
		this.tileType = tileType;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(tileset, rectangle.x, rectangle.y, tileType.srcX, tileType.srcY, TILE_SIZE, TILE_SIZE);
	}
}
