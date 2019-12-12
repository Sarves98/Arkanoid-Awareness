/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import static game.Arkanoid.COUNT_BLOCKS_X;
import static game.Arkanoid.COUNT_BLOCKS_Y;
import static game.Arkanoid.PLAYER_LIVES;
import static game.Arkanoid.SCREEN_HEIGHT;
import static game.Arkanoid.SCREEN_WIDTH;
import static game.Arkanoid.FONT;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 *
 * @author Sarves
 */
class ScoreBoard {

		int score = 0;
		int lives = PLAYER_LIVES;
		boolean win = false;
		boolean gameOver = false;
		String text = "";

		Font font;

		ScoreBoard() {
			font = new Font(FONT, Font.PLAIN, 12);
			text = "Hello!\n\nWelcome to Arkanoid Java version";
		}

		void increaseScore() {
			score++;
			if (score == 80) {
				win = true;
				text = "You have won! \nYour score was: " + score
						+ "\n\nPress Enter to restart";
			} else {
				updateScoreboard();
			}
		}

		void die() {
			lives--;
			if (lives == 0) {
				gameOver = true;
				text = "You have lost! \nYour score was: " + score
						+ "\n\nPress Enter to restart";
			} else {
				updateScoreboard();
			}
		}

		void updateScoreboard() {
			text = "\nScore:" + score + "\nLives: " + lives;
		}

		void draw(Graphics g) {
			if (win || gameOver) {
				font = font.deriveFont(50f);
				FontMetrics fontMetrics = g.getFontMetrics(font);
				g.setColor(Color.WHITE);
				g.setFont(font);
				int titleHeight = fontMetrics.getHeight();
				int lineNumber = 1;
				for (String line : text.split("\n")) {
					int titleLen = fontMetrics.stringWidth(line);
					g.drawString(line, (SCREEN_WIDTH / 2) - (titleLen / 2),
							(SCREEN_HEIGHT / 4) + (titleHeight * lineNumber));
					lineNumber++;

				}
			} else {
				font = font.deriveFont(34f);
				FontMetrics fontMetrics = g.getFontMetrics(font);
				g.setColor(Color.WHITE);
				g.setFont(font);
				//int titleLen = fontMetrics.stringWidth(text);
				int titleHeight = fontMetrics.getHeight();
                                int lineNumber =1;
				//g.drawString(text, (SCREEN_WIDTH / 2) - (titleLen / 2),
						//titleHeight + 5);
                                                for (String line : text.split("\n")) {
					int titleLen = fontMetrics.stringWidth(line);
					g.drawString(line, (SCREEN_WIDTH / 2) - (titleLen / 2),
							(SCREEN_HEIGHT / 16) + (titleHeight * lineNumber));
					lineNumber++;

				}
                                                

			}
		}
}
