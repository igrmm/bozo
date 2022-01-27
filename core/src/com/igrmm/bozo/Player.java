package com.igrmm.bozo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends GameObject {
	private final Texture playerTex;

	public Player(Texture playerTex) {
		this.playerTex = playerTex;
		this.rectangle.set(0f, 0f, 16f, 16f);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(playerTex, this.rectangle.x, this.rectangle.y);
	}
}
