import java.awt.event.*;
import java.awt.*;

public class Player extends AABB{

  enum PlayerPos {
    up, middle, down
  };

  boolean isEaten;

  PlayerPos currentPos = PlayerPos.middle;

  Color textureColor;

  public Player(){
    super(50, 0, 50, 50);
    textureColor = Color.BLUE;
  }

  public void update(float deltaTime){
    switch(currentPos){
      case up:
      currentPos = PlayerPos.up;
      y = Win.WORLD_HEIGHT/3;
      break;
      case middle:
      currentPos = PlayerPos.middle;
      y = Win.WORLD_HEIGHT/2;
      break;
      case down:
      currentPos = PlayerPos.down;
      y = Win.WORLD_HEIGHT - Win.WORLD_HEIGHT/3;
      break;
    }
  }

  public void moveUp(){
    switch(currentPos){
      case up:
      break;
      case middle:
      currentPos = PlayerPos.up;
      break;
      case down:
      currentPos = PlayerPos.middle;
      break;
    }
  }

  public void moveDown(){
    switch(currentPos){
      case up:
      currentPos = PlayerPos.middle;
      break;
      case middle:
      currentPos = PlayerPos.down;
      break;
      case down:
      break;
    }
  }



}
