import java.awt.Color;
import java.awt.Graphics;

public class Dot {

    int x;
    int y;
    int radius;
    
    public Dot(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawOval(x, y, radius, radius);
    }
    
    public void offsetCoordinates(int xOffset, int yOffset) {
        this.x += xOffset;
        this.y += yOffset;
    }
    
   public void setCoordinates(int x, int y) {
      this.x = x;
      this.y = y;
   }
}
