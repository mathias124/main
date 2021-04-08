import processing.core.PApplet;
import processing.core.PVector;


public class Enemy {
    boolean followingplayer = false;

    int hastighed;
    PApplet p;
    PVector getEnemyposition = new PVector();
    float maximumhealth = 100;
    float healthbarWidth = 100;
    float healthbarHeight = 20;
    float health = 100;
    //float calculateHP;
    PVector getGetEnemyvelocity = new PVector();
    float movespeed = 4;
    float Playeradius = 10;
    float Enemyradius = 10;

    PVector position;


    Enemy(float xPos, float yPos, int hastighed, int DIAMETER, PVector position, PApplet p) {
        getEnemyposition.x = xPos;
        getEnemyposition.y = yPos;
        this.hastighed = hastighed;
        this.p = p;
        this.position = position;


    }

    void update() {
        if (followingplayer) {
            //Identificere spillerens lokation.
            PVector targetVector = new PVector();

            targetVector.x = position.x;
            targetVector.y = position.y;
            // Fjendens position forhold til playeren.
            PVector enemychase = new PVector();
            enemychase.x = getEnemyposition.x;
            enemychase.y = getEnemyposition.y;

            PVector direction = PVector.sub(targetVector, enemychase);
            //for at lave det til en normalvektor med en længde på 1.
            direction.normalize();

            direction.mult(movespeed);
            getEnemyposition.x += direction.x;
            getEnemyposition.y += direction.y;


            if (health < 50) {
                p.fill(175, 215, 0);
            } else if (health > 50) {
                p.fill(0, 255, 0);
            } else if (health < 25) {
                p.fill(0, 255, 0);
            }
        }
    }

    public void display() {
        p.ellipse(getEnemyposition.x, getEnemyposition.y, Enemyradius, Enemyradius);
        //Laver enemies Healthbar.

        float calculateHP = (health / maximumhealth) * healthbarWidth;

        p.stroke(153);
        p.rect(getEnemyposition.x - 50, getEnemyposition.y - 50, calculateHP, healthbarHeight);
        boolean hit = pointRadius(position.x, position.y, Playeradius, getEnemyposition.x, getEnemyposition.y, Enemyradius);
        if (hit) {
            p.fill(255, 150, 0);
            p.text("u dead now",200,200);
        }

    }

    boolean pointRadius(float positionx, float positiony, float Activeradius, float getEnemypositionx, float getEnemypositiony, float Enemyradius) {
    float distanceX = position.x - getEnemyposition.x;
    float distanceY = position.y - getEnemyposition.y;
    float distance = p.sqrt((distanceX*distanceX)+(distanceY*distanceY));
    Activeradius = 350;
    if(distance <=Activeradius) {
        followingplayer = true;
    }
    if(distance <=Enemyradius) {
        return true;
    }

    return false;
    }

}