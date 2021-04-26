package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bala {
    float x,y,h,w;
    Texture bala1,bala2,bala3,bala4;
    int spriteNum;
    Sound so,crit;

    Bala(float xPerson,float yPerson,float wPerson,float hPerson){
        x=xPerson+wPerson/2+10;
        y=yPerson+hPerson;
        spriteNum=0;
        bala1=new Texture("bala1.png");
        bala2=new Texture("bala2.png");
        bala3= new Texture("bala3.png");
        bala4=new Texture("bala4.png");
        so= Gdx.audio.newSound(Gdx.files.internal("sons/waterDrum.ogg"));
        so.play(0.5f);
        crit=Gdx.audio.newSound(Gdx.files.internal("sons/hey.ogg"));
        crit.play();
    }
    void update(){
        y+=2;
    }
    void render(SpriteBatch batch){
        if(spriteNum>=28)spriteNum=0;
        if (spriteNum<8){
            batch.draw(bala1,x,y);
        }else if (spriteNum<15){
            batch.draw(bala2,x,y);
        }else if (spriteNum<23){
            batch.draw(bala3,x,y);
        }   else if (spriteNum<28){
            batch.draw(bala4,x,y);
        }
        spriteNum++;
    }
}
