package com.igrmm.bozo;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public final Texture playerTex;
	public final Texture tilesetTex;

	public Assets(AssetManager assetManager) {
		this.playerTex = assetManager.get("images/player.png", Texture.class);
		this.tilesetTex = assetManager.get("images/tileset.png", Texture.class);
	}
}
