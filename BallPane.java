
//U10111003朱永捷

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
	public final double radius1 = 20;
	public final double radius2 = 10;
	private double x1 = radius1, y1 = radius1;
	private double x2 = radius2+100, y2 = radius2+100;
	private double dx1 = 1, dy1 = 1;
	private double dx2 = 1, dy2 = 1;
	private Circle circle1 = new Circle(x1, y1, radius1);
	private Circle circle2 = new Circle(x2, y2, radius2);
	private Timeline animation;
	
	public BallPane() {

		// Set color
		circle1.setFill(Color.BLUE);
		circle2.setFill(Color.RED);
		// Place a ball into this pane
		getChildren().add(circle1);
		getChildren().add(circle2); 

		// Create an animation for moving the ball
		animation = new Timeline(
			new KeyFrame(Duration.millis(50), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation
	}

	public void play() {
		animation.play();
	}

	public void pause() {
		animation.pause();
	}

	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.1);
	}

	public void decreaseSpeed() {
		animation.setRate(
			animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}

	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
  
	protected void moveBall() {
		for(int i = 0;i < 2;i++){
			if (i == 0){
				// Check boundaries
				if (x1 < radius1 || x1 > getWidth() - radius1) {
					dx1 *= -1; // Change ball move direction
				}
				if (y1 < radius1 || y1 > getHeight() - radius1) {
					dy1 *= -1; // Change ball move direction
				}

				// Adjust ball position
			
				x1 += dx1;
				y1 += dy1;

				circle1.setCenterX(x1);
				circle1.setCenterY(y1);
			} else {
				// Check boundaries
				if (x2 < radius2 || x2 > getWidth() - radius2) {
					dx2 *= -1; // Change ball move direction
				}
				if (y2 < radius2 || y2 > getHeight() - radius2) {
					dy2 *= -1; // Change ball move direction
				}

				// Adjust ball position
			
				x2 += dx2;
				y2 += dy2;

				circle2.setCenterX(x2);
				circle2.setCenterY(y2);
			}
		}
  	}
}
