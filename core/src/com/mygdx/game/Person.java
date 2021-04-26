package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Person {

    float x,y,h,w;
    float posInicialX,posInicialY;
    Texture quiet1, quiet2, dispar1,dispar2,dispar3,left1,left2,left3,left4,right1,right2,right3,right4;
    Raig raig;
    int spriteNum;
    String spriteType;
    int dispar;
    boolean haDisparat,haDisparat2,estaQuiet;
    List<Bala> balas;
    Sound passos,copDeBasto,wolololo;

    int parat;

    Person(int jugador){
        posInicialX=200;
        x=posInicialX;
        posInicialY=105;
        y=posInicialY;

        h=40;
        w=14;
        quiet1=new Texture("quiet1.png");
        quiet2=new Texture("quiet2.png");
        right1=new Texture("right1.png");
        right2=new Texture("right2.png");
        right3=new Texture("right3.png");
        right4=new Texture("right4.png");
        left1=new Texture("left1.png");
        left2=new Texture("left2.png");
        left3=new Texture("left3.png");
        left4=new Texture("left4.png");
        dispar1=new Texture("dispar1.png");
        dispar2=new Texture("dispar2.png");
        dispar3=new Texture("dispar3.png");

        spriteType="quiet";
        spriteNum=0;
        dispar=501;
        haDisparat=false;
        haDisparat2=false;
        estaQuiet=false;
        parat=0;

        balas=new ArrayList<>();

        if(jugador==2){
            posInicialX=100;
            x=posInicialX;
            posInicialY=105;
            y=posInicialY;
        }



        /// sons

        passos= Gdx.audio.newSound(Gdx.files.internal("sons/ticuticuti.ogg"));

        copDeBasto= Gdx.audio.newSound(Gdx.files.internal("sons/copDeBasto.ogg"));

        wolololo= Gdx.audio.newSound(Gdx.files.internal("sons/wololo.ogg"));
        passos.play(0.5f);

        passos.loop(0.5f);
        passos.pause();


    }

    public void update() {



        for (Bala bala: balas) {

            bala.update();

            if (bala.y>=1000){
                balas.remove(bala);
            }
        }

        if(haDisparat&&dispar!=100) {
            dispar++;
            spriteType = "dispar";

        }else if (haDisparat2&&dispar!=50){
            dispar++;
            spriteType = "dispar2";

        }else{
            haDisparat=false;
            haDisparat2=false;
            spriteType="quiet";

            if (Gdx.input.isKeyJustPressed(Input.Keys.COMMA)){
                haDisparat=true;
                spriteType="dispar";
                dispar=0;
                raig=new Raig(x,y,w,h);


            }else if (Gdx.input.isKeyJustPressed(Input.Keys.M)){
                spriteType="dispar2";
                balas.add(new Bala(x,y,w,h));
                haDisparat2=true;
                dispar=0;


            }else if (Gdx.input.isKeyPressed(Input.Keys.D)){
                x+=3;
                spriteType="dreta";


            }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
                x-=3;
                spriteType="esquerre";


            }else{
                parat++;
                if(parat==300)parat=0;
                if (parat==200)wolololo.play();
            }
            spriteNum++;


        }





    }

    void render(SpriteBatch batch){
        passos.pause();

        for (Bala bala: balas) {
            bala.render(batch);
        }
        if (spriteType.equals("quiet")){

            if (spriteNum>=80)spriteNum=0;
            if (spriteNum<35){
                batch.draw(quiet1,x,y);
            }else{
                batch.draw(quiet2,x,y);
            }

        }else if(spriteType.equals("dreta")){
            if (spriteNum>=20)spriteNum=0;
            if(spriteNum<5){
                batch.draw(right1,x,y);
            }else if(spriteNum<10){
                batch.draw(right2,x,y);
            }else if(spriteNum<15){
                batch.draw(right3,x,y);
            }else {
                batch.draw(right4,x,y);
            }
            passos.resume();

        }else if(spriteType.equals("esquerre")){
            if (spriteNum>=20)spriteNum=0;
            if(spriteNum<5){
                batch.draw(left1,x,y);
            }else if(spriteNum<10){
                batch.draw(left2,x,y);
            }else if(spriteNum<15){
                batch.draw(left3,x,y);
            }else {
                batch.draw(left4,x,y);
            }
            passos.resume();
        }else if(spriteType.equals("dispar")){
            raig.render(batch,dispar);
            if (dispar==55)copDeBasto.play();
            if(dispar<44){
                batch.draw(dispar1,x,y);
            }else if(dispar<60){
                batch.draw(dispar2,x,y);
            }else if (dispar<100){
                batch.draw(dispar3,x,y);
            }

        }else if (spriteType.equals("dispar2")){
            if (dispar==3)copDeBasto.play();

            if (dispar>=20){
                dispar=0;
                haDisparat2=false;
            }
            if (dispar<1){
                batch.draw(dispar1,x,y);
            }else if (dispar<15){
                batch.draw(dispar3,x,y);
            }else if (dispar<20){
                batch.draw(dispar1,x,y);
            }
        }





    }
}
