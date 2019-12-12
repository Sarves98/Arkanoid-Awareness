/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Arkanoid.FT_STEP;
import static game.Arkanoid.PADDLE_HEIGHT;
import static game.Arkanoid.PADDLE_VELOCITY;
import static game.Arkanoid.PADDLE_WIDTH;
import static game.Arkanoid.SCREEN_WIDTH;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Sarves
 */
class Paddle extends Rectangle {
                Color c=new Color(255,153,0);
		double velocity = 0.0;

		public Paddle(double x, double y) {
			this.x = x;
			this.y = y;
			this.sizeX = PADDLE_WIDTH;
			this.sizeY = PADDLE_HEIGHT;
		}

		void update() {
			x += velocity * FT_STEP;
		}

		void stopMove() {
			velocity = 0.0;
		}

		void moveLeft() {
			if (left() > 0.0) {
				velocity = -PADDLE_VELOCITY;
			} else {
				velocity = 0.0;
			}
		}

		void moveRight() {
			if (right() < SCREEN_WIDTH) {
				velocity = PADDLE_VELOCITY;
			} else {
				velocity = 0.0;
			}
		}
			void draw(Graphics g,Graphics h) {
			h.setColor(c);    
                        g.setColor(Color.WHITE);
			g.fillRect((int) (left()), (int) (top()), (int) sizeX, (int) sizeY);
                        h.fillRect((int)(left()), (int)(top()), (int) sizeX/3, (int) sizeY);
                        }
		         
                

	}