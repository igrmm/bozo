package com.igrmm.bozo;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
	private final Bozo game;
	private final Assets assets;
	private final SpriteBatch batch;
	private final Viewport viewport;

	private final Player player;

	public GameScreen(Bozo game) {
		this.game = game;
		assets = new Assets(game.assetManager);
		batch = new SpriteBatch();
		viewport = new ExtendViewport(Bozo.VIEWPORT_WIDTH, Bozo.VIEWPORT_HEIGHT, new OrthographicCamera());

		player = new Player(assets.playerTex);
	}

	@Override
	public void render(float delta) {
		viewport.getCamera().position.x = player.rectangle.x + player.rectangle.width / 2f;
		viewport.getCamera().position.y = player.rectangle.y + player.rectangle.height / 2f;

		ScreenUtils.clear(1f, 1f, 0.66f, 1f);
		viewport.apply();
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		player.draw(batch);
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
