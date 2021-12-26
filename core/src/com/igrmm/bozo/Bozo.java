package com.igrmm.bozo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Bozo extends Game {
	private enum ImageAsset {
		PLAYER_IMG("images/player.png");

		private final String path;

		ImageAsset(String path) {
			this.path = path;
		}
	}

	private SpriteBatch batch;
	private final AssetManager assetManager = new AssetManager();
	private Texture img;

	@Override
	public void create() {
		for (ImageAsset imageAsset : ImageAsset.values()) assetManager.load(imageAsset.path, Texture.class);
		assetManager.finishLoading();

		batch = new SpriteBatch();
		img = assetManager.get(ImageAsset.PLAYER_IMG.path);
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		assetManager.dispose();
	}
}
