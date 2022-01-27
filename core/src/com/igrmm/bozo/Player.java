package com.igrmm.bozo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject {
	private final Texture playerTex;

	public Player(Texture playerTex) {
		this.playerTex = playerTex;
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(playerTex, 0, 0);
	}
}
