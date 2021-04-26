package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Raig {
    float x,y,h;
    Texture raig1,raig2,raig3;
    int tempsRaig;
    Sound crit,so;

    Raig(float xPerson, float yPerson,float wPerson,float hPerson){
        raig1=new Texture("raig1.png");
        raig2=new Texture("raig2.png");
        raig3=new Texture("raig3.png");
        x=xPerson+wPerson/2;
        y=yPerson+hPerson/2;
        tempsRaig=0;
        crit = Gdx.audio.newSound(Gdx.files.internal("sons/raig.ogg"));
        so= Gdx.audio.newSound(Gdx.files.internal("sons/strike.ogg"));




    }

    void render(SpriteBatch batch,int dispar){
        if(dispar==99){
            so.stop();
        }
        if(dispar==50){
            so.play(0.5f);
        }
        if(dispar==10)crit.play();
        if (dispar<50){
            batch.draw(raig1,x,y);
        }else if (dispar<70){
            batch.draw(raig2,x,y);
        }else if (dispar<88){
            batch.draw(raig3,x,y);
        }else if (dispar<100){
            batch.draw(raig1,x,y);
        }
    }
}
