import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Furniture> furnitureList = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ImageLoader imgLoad = new ImageLoader(this);


   int level;
   int DIAMETER = 80;
   int hastighed = 4;





    int fjendeAmount=5;
    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }
    Shop shop;
    Dungeon dungeon;
    Location location;

    Player player = new Player(this);


    @Override
    public void setup() {
        super.setup();
        furnitureList.add(new Furniture(this,Types.shopCounter,50,50));
        shop = new Shop(furnitureList);
        location = new Location(shop,dungeon);
        imgLoad.loadTheImages();

        //enemies = new Enemy[5];
        //for(int i = 0; i <5; i++)
           // enemies[i] = new Enemy((int) random(0, 1000), (int) random(0, 1000), hastighed, DIAMETER);

        //enemies.add(new Enemy((int) random(0, 1000), (int) random(0, 1000), hastighed, DIAMETER));
        // for(int i =0; i<2;i++)
            // enemies[i] = new Enemy((float)random(0,1920), (float)random(0,1080),DIAMETER);

    }

    @Override
    public void draw() {
        clear();
        background(0);
        player.draw();
        location.functions();
        if(enemies.size() < 5)
        enemies.add(new Enemy((int) random(0, 1000), (int) random(0, 1000), hastighed, DIAMETER,player.position,this));

        for(int i = 0;i<enemies.size();i++){
            enemies.get(i).update();
            enemies.get(i).display();




}

        }






    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);

    }


}
