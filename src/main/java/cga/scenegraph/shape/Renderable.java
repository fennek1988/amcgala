package cga.scenegraph.shape;

import cga.scenegraph.animation.Animation;
import cga.scenegraph.camera.DefaultCamera;
import cga.scenegraph.math.Matrix;
import cga.scenegraph.renderer.Renderer;


public abstract class Renderable {
  private Animation animation;

  public abstract void render(Matrix transformation, DefaultCamera camera, Renderer renderer);

  public void setAnimation(Animation animation) {
    this.animation = animation;
    this.animation.setShape(this);
  }

  public Animation getAnimation() {
    return animation;
  }
}
