package program.physics;

import program.GameObject;

public class BoxCollider extends Rectangle{
    public BoxCollider(GameObject object, int width, int height){
        super(object.position, width, height);
    }
}
