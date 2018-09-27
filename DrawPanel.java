import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Collections;

public class DrawPanel extends JPanel
{
	private ArrayList<ColorCircle> circles;
	private Random random = new Random();
	// add Constructors, mutators, accessors
	
	public DrawPanel()
	{
		circles = new ArrayList<ColorCircle>();
	}
	
	public void create(int numOfCircles, int smallRad, int bigRad)
	{
		// Creates and populates the instance of the ColorCircles
		
		int i;
		for(i = 0; i < numOfCircles; i++)
		{
			int x = random.nextInt(800);
			int y = random.nextInt(800);
			int r = random.nextInt((bigRad - smallRad) + 1) + smallRad;
			circles.add(new ColorCircle(x, y, r));
		}
	}
	   
    public void paintComponent(Graphics g)
    { 
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
    	// your drawing
    	for(ColorCircle c : circles)
    	{
    		c.fill(g2);
    	}
    	repaint();
    }
    
    public void sort()
    {
    	// sorts the objects
    	Collections.sort(circles, new CircleComparator());
    }  
   
    public void move()
    {
    	// moves the object
    	for(ColorCircle c : circles)
    	{
    		c.centre().move(getWidth()/2, getHeight()/2);
    	}
    }  
   
    public void reset()
    {
    	int i;
    	for(i = 0; i < circles.size(); i++)
    	{
    		circles.set(i, new ColorCircle(0, 0, 0));
    	}
    }   
}

