package program.enemy;

import program.GameObject;
import program.physics.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRanferer;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;
    public Enemy(){
        renderer = new AnimationRenderer("assets/images/enemies/level0/pink");
//        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.set(200,150);
        hitBox = new BoxCollider(this, 28,28);
        hp = 3;
    }
    public void takeDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            this.deactive();
        }
    }
}
