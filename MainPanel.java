import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MainPanel extends JPanel
{
	public static final int DEFAULT_CIRCLE = 5;
	public static final int SMALL_RAD = 10;
	public static final int BIG_RAD = 300;
	private JPanel dataPanel, buttonPanel;
	private JButton create, sort, centre, reset;
	private JTextField field1, field2, field3;
	private DrawPanel drawPanel;
	private int circles, rad1, rad2;
	
	public MainPanel()
	{
		drawPanel = new DrawPanel();
		
		createDataPanel();
		createButtons();
		createPanel();
	}
	
	public void createDataPanel()
	{
		final int FIELD_WIDTH = 5;
		
		JLabel numOfCircles = new JLabel("Number of circles: ");
		field1 = new JTextField(FIELD_WIDTH);
		field1.setText("" + DEFAULT_CIRCLE);
		
		JLabel radSmall = new JLabel("Radius of samllest circle: ");
		field2 = new JTextField(FIELD_WIDTH);
		field2.setText("" + SMALL_RAD);
		
		JLabel radBig = new JLabel("Radius of big circle: ");
		field3 = new JTextField(FIELD_WIDTH);
		field3.setText("" + BIG_RAD);
		
		dataPanel = new JPanel();
		dataPanel.add(numOfCircles);
		dataPanel.add(field1);
		dataPanel.add(radSmall);
		dataPanel.add(field2);
		dataPanel.add(radBig);
		dataPanel.add(field3);
	}
	
	public void createButtons()
	{
		create = new JButton("Create");
		class NumOfCircles implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				circles = Integer.parseInt(field1.getText());
				rad1 = Integer.parseInt(field2.getText());
				rad2 = Integer.parseInt(field3.getText());
				drawPanel.create(circles, rad1, rad2);
			}            
		}
		ActionListener listener = new NumOfCircles();
		create.addActionListener(listener);
		
		sort = new JButton("Sort");
		class SortCircles implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				drawPanel.sort();
	        }            
		}
		ActionListener listener1 = new SortCircles();
		sort.addActionListener(listener1);
	    
	    centre = new JButton("Co-centre");
		class CentreCircles implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				drawPanel.move();
	        }            
		}
		ActionListener listener2 = new CentreCircles();
		centre.addActionListener(listener2);
		
		reset = new JButton("Reset");
		class ResetCircles implements ActionListener
	    {
			public void actionPerformed(ActionEvent event)
	        {
				drawPanel.reset();
	        }            
		}
		ActionListener listener3 = new ResetCircles();
		reset.addActionListener(listener3);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(create);
		buttonPanel.add(sort);
		buttonPanel.add(centre);
		buttonPanel.add(reset);
	}
	
	public void createPanel()
	{
		setLayout(new BorderLayout());
		add(dataPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.WEST);
		add(drawPanel, BorderLayout.CENTER);
	}
}
