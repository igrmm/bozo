package com.igrmm.bozo;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen extends ScreenAdapter {
	private final Bozo game;
	private final SpriteBatch batch;
	private final Texture img;

	public GameScreen(Bozo game) {
		this.game = game;
		batch = new SpriteBatch();
		img = game.assets.get(ImageAsset.PLAYER_IMG.path);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(1.0f, 1.0f, 0.66f, 1.0f);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void hide() {
		batch.dispose();
	}
}
