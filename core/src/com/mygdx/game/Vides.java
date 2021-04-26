package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Vides {
    float x,y,h,w;
    Texture nou,vuit,set,sis,cinc,quat,tres,dos,un,gameOver;

    Vides(){
        nou=new Texture("vides9.png");
        x=50;
        y=5;
    }

    void render(SpriteBatch batch){
        batch.draw(nou,x,y);
    }
}
