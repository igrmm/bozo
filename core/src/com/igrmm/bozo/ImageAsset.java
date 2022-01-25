package com.igrmm.bozo;

public enum ImageAsset {
	PLAYER("images/player.png"),
	TILESET("images/tileset.png");

	public final String path;

	ImageAsset(String path) {
		this.path = path;
	}
}
