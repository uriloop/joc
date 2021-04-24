package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nuve {
    Texture nuve1,nuve2,nuve3;
    float x,y;
    int posInicial,posFinal;
    int spritE;

    Nuve(){

        posFinal=1000;
        posInicial-=300;
        x=posInicial;
        y=340;
        spritE=0;
        nuve1=new Texture("nuve1.png");
        nuve2=new Texture("nuve2.png");
        nuve3=new Texture("nuve3.png");

    }
    void update(){
        if (x>posFinal){
            x=posInicial;
        }else {
            x+=0.2f;
        }
    }

    void render(SpriteBatch batch){
        if(spritE==6){
            spritE=0;
        }
        if (spritE<2){
            batch.draw(nuve1,x,y);
        }else if (spritE<4){
            batch.draw(nuve2,x,y);
        }else{
            batch.draw(nuve3,0,0);
        }
    }
}
