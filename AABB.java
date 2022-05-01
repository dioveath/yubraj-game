import java.awt.*;

public class AABB  {

  public float x, y;
  public float width, height;
  public float vlx, vly;
  public float halfWidth, halfHeight;

  public AABB(float x, float y, float width, float height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.halfWidth = width/2;
    this.halfHeight = height /2;
  }

  public boolean isColliding(AABB o){ //checked and working
    float vx = o.x - this.x;
    float vy = o.y - this.y;
    float combWidth = this.halfWidth + o.halfWidth;
    float combHeight = this.halfHeight + o.halfHeight;

    if((Math.abs(vx)) < combWidth){
      if((Math.abs(vy)) < combHeight){
        return true;
      }
    }
    return false;
  }

  public void update(float deltaTime){
    x += vlx * deltaTime;
    y += vly * deltaTime;
  }

  public boolean isColliding(Point p){
    if(p.x > x && p.x < (x + width) && p.y > y && p.y < (y + height)){
      return true;
    }
    return false;
  }

}
