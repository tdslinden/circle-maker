import javax.swing.JFrame;

public class CircleViewer 
{
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.add(new MainPanel());
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
