package program.player;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.enemy.Enemy;
import program.physics.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRanferer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public int damage;
    public PlayerBullet(){
        renderer = new AnimationRenderer("assets/images/player-bullets/a");
//        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        position = new Vector2D();// vector (0;0)
        velocity.set(0,-Settings.P_BULLET_SPEED);
        hitBox = new BoxCollider(this,24,24);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
        this.intersectsEnemy();
    }

    private void intersectsEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.hitBox);
        if(enemy != null){
            this.deactive();
            enemy.takeDamage(this.damage);
        }
    }

    public void deactiveIfNeeded(){
        if(position.y < -30){
//            System.out.println("Deactive");
            this.deactive();
        }
    }

}
