/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Arkanoid.BLOCK_HEIGHT;
import static game.Arkanoid.BLOCK_WIDTH;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Sarves
 */

class Brick extends Rectangle {
                
		boolean destroyed = false;

		Brick(double x, double y) {
			this.x = x;
			this.y = y;
			this.sizeX = BLOCK_WIDTH;
			this.sizeY = BLOCK_HEIGHT;
		}

		void draw(Graphics g) {
			g.setColor(Color.PINK);
			g.fillRect((int) left(), (int) top(), (int) sizeX, (int) sizeY);
		}
	}