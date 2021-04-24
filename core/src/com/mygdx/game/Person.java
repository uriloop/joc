package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Person {

    float x,y,h,w;
    float posInicialX,posInicialY;
    Texture quiet1, quiet2, dispar1,dispar2,dispar3,left1,left2,left3,left4,right1,right2,right3,right4;

    int spriteNum;
    String spriteType;
    int dispar;
    boolean haDisparat;

    Person(){
        posInicialX=200;
        x=posInicialX;
        posInicialY=100;
        y=posInicialY;
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


    }

    public void update() {

        if(haDisparat&&dispar!=100){
            dispar++;
            spriteType="dispar";
        }else{
            haDisparat=false;
            spriteType="quiet";
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                haDisparat=true;
                spriteType="dispar";
                dispar=0;

            }else if (Gdx.input.isKeyPressed(Input.Keys.D)){
                x+=3;
                spriteType="dreta";
            }else if(Gdx.input.isKeyPressed(Input.Keys.A)){
                x-=3;
                spriteType="esquerre";
            }
            spriteNum++;
        }





    }

    void render(SpriteBatch batch){
        if (spriteType.equals("quiet")){
            if (spriteNum>=80)spriteNum=0;
            if (spriteNum<35){
                batch.draw(quiet1,x,y);
            }else{
                batch.draw(quiet2,x,y);
            }

        }else if(spriteType.equals("dreta")){
            if (spriteNum>=40)spriteNum=0;
            if(spriteNum<10){
                batch.draw(right1,x,y);
            }else if(spriteNum<20){
                batch.draw(right2,x,y);
            }else if(spriteNum<30){
                batch.draw(right3,x,y);
            }else {
                batch.draw(right4,x,y);
            }


        }else if(spriteType.equals("esquerre")){
            if (spriteNum>=40)spriteNum=0;
            if(spriteNum<10){
                batch.draw(left1,x,y);
            }else if(spriteNum<20){
                batch.draw(left2,x,y);
            }else if(spriteNum<30){
                batch.draw(left3,x,y);
            }else {
                batch.draw(left4,x,y);
            }
        }else if(spriteType.equals("dispar")){

            if(dispar<5){
                batch.draw(dispar1,x,y);
            }else if(dispar<10){
                batch.draw(dispar2,x,y);
            }else if (dispar<100){
                batch.draw(dispar3,x,y);
            }

        }



        spriteNum++;

    }
}
