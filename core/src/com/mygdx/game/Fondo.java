package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Fondo {

    Nuve nuve;
    Texture fondo1,fondo2,fondo3;
    int h,w,x,y;
    int posSprite=0;

    Fondo(){
        fondo1=new Texture("fondo1.png");
        fondo2=new Texture("fondo2.png");
        fondo3=new Texture("fondo3.png");

        nuve = new Nuve();
        x=0;
        y=0;
        h=500;
        y=400;
    }

    void update(){
        posSprite++;
        nuve.update();
    }

    void render(SpriteBatch batch){

        if (posSprite==90){
            posSprite=0;
        }
        if (posSprite<30){
            batch.draw(fondo2,0,0);
        }else if (posSprite<60){
            batch.draw(fondo1,0,0);
        }else{
            batch.draw(fondo3,0,0);
        }
        nuve.render(batch);
    }
}
