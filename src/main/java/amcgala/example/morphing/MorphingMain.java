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
package amcgala.example.morphing;

import amcgala.Framework;
import amcgala.framework.shape.BresenhamLine;

/**
 * Dieses Programm morpht zwischen zwei Bildern.
 *
 * @author Robert Giacinto
 */
public class MorphingMain extends Framework {

    public MorphingMain(int width, int height) {
        super(width, height);
    }

    @Override
    public void initGraph() {
        add(new MorphingItem(new BresenhamLine(0, 0, 0, 200), new BresenhamLine(0, 200, 200, -100), 200));
    }

    public static void main(String[] args) {
        MorphingMain morphing = new MorphingMain(800, 800);
        morphing.start();
    }
}
