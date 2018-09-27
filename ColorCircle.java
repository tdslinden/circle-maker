import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ColorCircle extends Circle
{
	 private Color color;
	 
	 // Constructor
	 public ColorCircle(double x, double y, double r) 
	 {  
		 // creates a circle object and assigns a random color to color
		 super(x, y, r);
		 int R = (int)(Math.random()*256);
		 int G = (int)(Math.random()*256);
		 int B = (int)(Math.random()*256);
		 color = new Color(R, G, B);
	 }
	 
	 public void fill(Graphics2D g2) 
	 {
		 // draw and fill the circle with myColor
		 Ellipse2D.Double c = new Ellipse2D.Double(centre().getX()-getRadius(),centre().getY()-getRadius(),2*getRadius(),2*getRadius());
		 g2.setColor(color);
		 g2.fill(c);
		 g2.draw(c);
	 }      
	   
	
}
