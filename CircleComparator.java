import java.util.Comparator;

public class CircleComparator implements Comparator<ColorCircle>
{
	public int compare(ColorCircle o1, ColorCircle o2)
	{
			return (int) (o2.getRadius() - o1.getRadius());
	}
}