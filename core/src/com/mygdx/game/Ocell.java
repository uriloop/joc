package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ocell {
    float x,y,w,h,rellotge;
    int spriteNum;
    Sound so,crit;
    Texture un,dos,tres,quatre,cinc,sis;

    Ocell(){
        x=800;
        y= 300;
        spriteNum=0;
        //crit= Gdx.audio.newSound(Gdx.files.internal("pajarraco/          .png"));
        un=new Texture("pajarraco/Impulsa.png");
        dos=new Texture("pajarraco/cau.png");
        tres= new Texture("pajarraco/cauBoca.png");
        quatre= new Texture("pajarraco/ImpulsaBoca.png");

        crit= Gdx.audio.newSound(Gdx.files.internal("pajarraco/sons/quak.ogg"));
    }
    void update(){
        if (rellotge==140)rellotge=0;

        if (spriteNum<3){
            y+=4f;
        }else if (spriteNum<7){
            y+=3f;
        }else if (spriteNum<12){
            y+=1f;
        }else if (spriteNum<=20){
            y-=0.5f;
        }else if (spriteNum<40){
            y-=1f;
        }else{
            y-=1.5f;
        }

        x-=2;
    }
    void render(SpriteBatch batch){
        if(spriteNum==40){
            spriteNum=0;
        }
        if (rellotge<110){
            if (spriteNum<20){
                batch.draw(un,x,y,80f,50f);
            }else{
                batch.draw(dos,x,y,80f,50f);

            }
        }else if (rellotge<140){
            if (rellotge==110)crit.play(0.8f);
            if (spriteNum<20){
                batch.draw(quatre,x,y,80f,50f);
            }else{
                batch.draw(tres,x,y,80f,50f);

            }

        }

        spriteNum++;
        rellotge++;
    }
}
