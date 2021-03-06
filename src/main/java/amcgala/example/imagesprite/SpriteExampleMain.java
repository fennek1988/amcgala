package amcgala.example.imagesprite;

import amcgala.Framework;
import amcgala.framework.animation.Animation;
import amcgala.framework.shape.Sprite;

import java.io.IOException;
import java.io.InputStream;

public class SpriteExampleMain extends Framework {

    public SpriteExampleMain(int width, int height) {
        super(width, height);

    }

    @Override
    public void initGraph() {
        try {
            InputStream inputStream = ClassLoader
                    .getSystemResourceAsStream("amcgala/example/spriteshape/image.jpg");
            final Sprite a = new Sprite(inputStream, -200, 50);
            a.setAnimation(new Animation<Sprite>() {
                @Override
                public void animate() {
                    if ((a.getX() + 2) < -100) {
                        a.setX((a.getX() + 2));
                    } else {
                        a.setX(-200);
                    }
                }
            });
            add(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpriteExampleMain fp = new SpriteExampleMain(320, 200);
        fp.start();
    }
}