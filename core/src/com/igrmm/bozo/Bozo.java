package com.igrmm.bozo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class Bozo extends Game {
	public static final int VIEWPORT_WIDTH = 320, VIEWPORT_HEIGHT = 180;

	public final AssetManager assetManager = new AssetManager();

	@Override
	public void create() {
		FileHandle textures = Gdx.files.internal("images/");
		for (FileHandle texture : textures.list())
			assetManager.load(texture.path(), Texture.class);
		assetManager.finishLoading();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		assetManager.dispose();
	}
}
