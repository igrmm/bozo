package com.igrmm.bozo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Bozo extends Game {
	public final AssetManager assets = new AssetManager();

	@Override
	public void create() {
		for (ImageAsset imageAsset : ImageAsset.values()) assets.load(imageAsset.path, Texture.class);
		assets.finishLoading();
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		assets.dispose();
	}
}
