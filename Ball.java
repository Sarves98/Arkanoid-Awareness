/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Arkanoid.BALL_RADIUS;
import static game.Arkanoid.BALL_VELOCITY;
import static game.Arkanoid.FT_STEP;
import static game.Arkanoid.SCREEN_HEIGHT;
import static game.Arkanoid.SCREEN_WIDTH;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Sarves
 */
class Ball extends GameObject {

		double x, y;
		double radius = BALL_RADIUS;
		double velocityX = BALL_VELOCITY;
		double velocityY = BALL_VELOCITY;

		Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void draw(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillOval((int) left(), (int) top(), (int) radius * 2,
					(int) radius * 2);
		}

		void update(ScoreBoard scoreBoard, Paddle paddle) {
			x += velocityX * FT_STEP;
			y += velocityY * FT_STEP;

			if (left() < 0)
				velocityX = BALL_VELOCITY;
			else if (right() > SCREEN_WIDTH)
				velocityX = -BALL_VELOCITY;
			if (top() < 0) {
				velocityY = BALL_VELOCITY;
			} else if (bottom() > SCREEN_HEIGHT) {
				velocityY = -BALL_VELOCITY;
				x = paddle.x;
				y = paddle.y - 50;
				scoreBoard.die();
			}

		}

		double left() {
			return x - radius;
		}

		double right() {
			return x + radius;
		}

		double top() {
			return y - radius;
		}

		double bottom() {
			return y + radius;
		}

	}
