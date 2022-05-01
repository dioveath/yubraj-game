import java.awt.*;

public class Obstacle extends AABB {

  enum obsPosition {
    up, middle, down
  };
  obsPosition currentPos;
  public Color textureColor;

  public Obstacle(obsPosition position){
    super(Win.WORLD_WIDTH, 0, 50, 50);
    currentPos = position;
    textureColor = Color.GREEN;
    vlx = -240;
  }

  public void update(float deltaTime){
    super.update(deltaTime);
    switch(currentPos){
      case up:
      currentPos = obsPosition.up;
      y = Win.WORLD_HEIGHT/3;
      break;
      case middle:
      currentPos = obsPosition.middle;
      y = Win.WORLD_HEIGHT/2;
      break;
      case down:
      currentPos = obsPosition.down;
      y = Win.WORLD_HEIGHT - Win.WORLD_HEIGHT/3;
      break;
    }
  }

  public void setPosition(obsPosition position){
    currentPos = position;
  }


}
