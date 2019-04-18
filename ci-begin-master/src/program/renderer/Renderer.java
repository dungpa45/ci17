package program.renderer;

import program.GameObject;

import java.awt.*;

public abstract class Renderer {
    public abstract void render(Graphics g, GameObject master);
}
