/*
 * Copyright 2011 Cologne University of Applied Sciences Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package amcgala.example.concurrency;

import amcgala.framework.camera.Camera;
import amcgala.framework.event.InputHandler;
import amcgala.framework.math.Matrix;
import amcgala.framework.renderer.Color;
import amcgala.framework.renderer.Renderer;
import amcgala.framework.shape.Shape;
import amcgala.framework.shape2d.Cross;

import com.google.common.eventbus.Subscribe;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Dieses Shape fügt einer internen, nichtsynchronisierten Liste Instanzen von
 * Cross2d hinzu, um neue Synchronisierungsstrategien testen zu können.
 *
 * @author Robert Giacinto
 */
public class RandomCrossArray extends Shape implements InputHandler {

    private List<Cross> crosses;
    private Random random;

    public RandomCrossArray() {
        crosses = new CopyOnWriteArrayList<Cross>();
        random = new Random(System.nanoTime());
    }

    public void addCross(Cross cross) {
        crosses.add(cross);
    }

    @Override
    public void render(Matrix transformation, Camera camera, Renderer renderer) {
        for (Cross cross : crosses) {
            cross.render(transformation, camera, renderer);
        }
    }

    @Subscribe
    public void handleKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            Cross c2d = new Cross(random.nextInt(800) - 400, random.nextInt(600) - 300, random.nextInt(50));
            c2d.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            addCross(c2d);
        }
    }
}
