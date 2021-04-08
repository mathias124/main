import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.*;

public class Player {


    PVector position = new PVector();
    PVector velocity = new PVector();


boolean showAim = false;

    PApplet p;
    int playerWidth = 10;
    int playerHeight=10;
    boolean down,up,left,right = false;
    boolean ready = true;
    float maximumhealth = 100;
    float healthbarWidth  = 200;
    float healthbarHeight = 40;
    float playerhealth  = 100 ;
    float maxhealthupgrade;
    boolean bullet;
    boolean isBullet;


    Player(PApplet p){
        this.playerhealth = playerhealth;
        this.p = p;



        position.set(100,this.p.height/2);

    }


    void changePosition(){

        position.add(velocity);
        position.x =p.constrain(position.x,0,p.width-playerWidth);
        position.y=  p.constrain(position.y,0,p.height-playerHeight);
    }
   void setVolicityaim(){
        if(showAim == true);
        p.stroke(255,0,0,180);
        p.strokeWeight(3);
p.line(p.mouseX,p.mouseY,position.x,position.y);
   }

    void draw(){

        changePosition();
        //if(level ==1) {
            //p.image(captaincheese,position.x,position.y);
            p.stroke(204,102,0);
            p.rect(position.x,position.y,playerWidth,playerHeight);

        //}
        changePosition();
        setVolicityaim();
        setHealth();
        simulate();
        interact();



    }

    void setHealth() {
        if (playerhealth < 50) {
            p.fill(175, 215, 0);
        }
        else if ( playerhealth > 50) {
            p.fill(0,255,0);
        }
        else if ( playerhealth < 25) {
            p.fill(0,255,0);
        }
        //p.noStroke();
        float calculateplayerHP = (playerhealth/maximumhealth) * healthbarWidth;

        //der er 2 rect tilstede grundet til at der skal være en omkreds om cirkel (da det andet areal/længde går nedad når den mister liv).
        p.stroke(0);
        p.rect(740,25,calculateplayerHP,healthbarHeight);
        //Til at vise den maximale HP bar stadig selvom HP forsvinder.
        p.rect(740,25,healthbarWidth,healthbarHeight);
        p.fill(255);
        p.textSize(20);
        p.text(calculateplayerHP/2+" HP",805,50);
    }
 void simulate() {

     //if (level == 1) {
    // }
 }

    void interact(){


    }



    void controls(char key, int keyCode,  boolean pressed){
        velocity.set(0,0);
        if (key != p.CODED)
            switch(key) {


                case 'f': {
                    if ((pressed) && (ready))
                        showAim = true;

            }break;



                case 's': {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case 'w': {
                    if((pressed) &&(ready))
                        up = true;
                    else
                        up=false;

                }break;
                case 'a': {
                    if((pressed) &&(ready))
                        left=true;
                    else
                        left=false;

                }break;
                case 'd': {
                    if((pressed) &&(ready))
                        right=true;
                    else
                        right=false;



                }break;



            }
        else{
            switch (keyCode){

                case DOWN: {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case UP: {
                    if((pressed) &&(ready))
                        up=true;
                    else{
                        up=false;}

                }break;
                case RIGHT: {
                    if((pressed) &&(ready))
                        right=true;
                    else{
                        right=false;}


                }break;
                case LEFT: {
                    if((pressed) &&(ready))
                        left=true;
                    else{
                        left=false;}


                }break;

            }


        }
        velocity.set(((right)?1:0) +((left)?-1:0),(((up)?-1:0) +((down)?1:0)));
    }



}
