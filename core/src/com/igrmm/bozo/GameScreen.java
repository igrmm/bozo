package com.igrmm.bozo;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
	private final Bozo game;
	private final SpriteBatch batch;
	private final Texture img;

	private final Viewport viewport;

	public GameScreen(Bozo game) {
		this.game = game;
		batch = new SpriteBatch();
		img = game.assetManager.get(ImageAsset.PLAYER.path);

		viewport = new ExtendViewport(Bozo.VIEWPORT_WIDTH, Bozo.VIEWPORT_HEIGHT, new OrthographicCamera());
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(1.0f, 1.0f, 0.66f, 1.0f);
		viewport.apply();
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void hide() {
		batch.dispose();
	}
}
