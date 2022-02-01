package com.igrmm.bozo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {
	private final Bozo game;
	private final Assets assets;
	private final SpriteBatch batch;
	private final Viewport viewport;
	private final Stage stageUI;

	private final Player player;
	private final World world;

	public GameScreen(Bozo game) {
		this.game = game;
		assets = new Assets(game.assetManager);
		batch = new SpriteBatch();
		viewport = new ExtendViewport(Bozo.VIEWPORT_WIDTH, Bozo.VIEWPORT_HEIGHT, new OrthographicCamera());
		stageUI = new Stage(new ScreenViewport());

		player = new Player(assets.playerTex);
		world = new World(assets.tilesetTex);
	}

	@Override
	public void show() {
		stageUI.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("clicked");
			}
		});
		Gdx.input.setInputProcessor(stageUI);
	}

	@Override
	public void render(float delta) {
		viewport.getCamera().position.x = player.rectangle.x + player.rectangle.width / 2f;
		viewport.getCamera().position.y = player.rectangle.y + player.rectangle.height / 2f;

		ScreenUtils.clear(1f, 1f, 0.66f, 1f);
		viewport.apply();
		stageUI.act(delta);
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		world.draw(batch);
		player.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		stageUI.getViewport().update(width, height, true);
	}

	@Override
	public void hide() {
		batch.dispose();
	}
}
