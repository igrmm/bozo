package com.igrmm.bozo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class World {
	private final Map<Float, Map<Float, Tile>> tiles;
	private final Texture tilesetTex;
	private final Rectangle bounds;

	public World(Texture tilesetTex) {
		tiles = new HashMap<>();
		this.tilesetTex = tilesetTex;
		bounds = new Rectangle();

		Tile tile = new Tile(tilesetTex, 0f, -Tile.TILE_SIZE, Tile.TileType.FLAT_TOP);
		putTile(tile);
	}

	private void putTile(Tile tile) {
		if (tiles.containsKey(tile.rectangle.x)) {
			Map<Float, Tile> tilesY = tiles.get(tile.rectangle.x);
			tilesY.put(tile.rectangle.y, tile);
		} else {
			Map<Float, Tile> tilesY = new HashMap<>();
			tilesY.put(tile.rectangle.y, tile);
			tiles.put(tile.rectangle.x, tilesY);
		}
	}

	public void draw(SpriteBatch batch) {
		Set<Float> Xs = tiles.keySet();
		for (float x : Xs) {
			Map<Float, Tile> tilesY = tiles.get(x);
			Set<Float> Ys = tilesY.keySet();
			for (float y : Ys) {
				tilesY.get(y).draw(batch);
			}
		}
	}

	public void setSize(float worldWidth, float worldHeight) {
		bounds.setSize(worldWidth, worldHeight);
	}
}
