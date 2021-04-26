// All images are mine, for free use.
// All sound are from https://bigsoundbank.com/detail-1588-gavel-1-blow.html
// The music is from https://www.purple-planet.com/


package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Fondo fondo;
	Person person1,person2;
	Vides vides;
	Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		fondo=new Fondo();
		person1=new Person(1);
		vides=new Vides();
		music= Gdx.audio.newMusic(Gdx.files.internal("sons/MusicaAfrica.mp3"));
		music.setVolume(0.50f);
		music.play();
		music.setLooping(true);
		person2=new Person(2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//ScreenUtils.clear(1, 0, 0, 1);

		/// carreguem / Update de tots el processos que s'executin al mateix temps. PODEM FER UNA BANDERA Y CREAR DOS LINIES DE TEMPS? UNA ON PASSA MÉS RAPID QUE L'ALTRE.
		// ELS COMANDAMENTS ELS HAURIEM DE POSAR A LA PRIMERA PERO PER EXEMPLE A L'HORA DE CREAR sPRITES?...
		fondo.update();
		person1.update();
		//person2.update();


		batch.begin();
		fondo.render(batch);
		vides.render(batch);
		person1.render(batch);
		//person2.render(batch);
		batch.end();
	}
	

}
