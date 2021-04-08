import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Bullet {
 PApplet p;
 PVector bulletlocation;
 PVector velocity1 = new PVector(0,0);

 int bullettype;

 Bullet(PApplet p, float x, float y, int bullettype){
     this.p=p;
     bulletlocation.x=x;
     bulletlocation.y=y;
     this.bullettype = bullettype;

     velocity1.set(velocity1.x,velocity1.y);

 }
void drawbullet() {
     p.ellipse(bulletlocation.x,bulletlocation.y,10,10);
}
void movebullet() {
     bulletlocation.add(velocity1);
}
void hit(ArrayList<Bullet> bullets, Enemy enemy, int i) {
     //if(bulletlocation.x <= enemy.x)
}

}
