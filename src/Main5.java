
public class Main5 {
	
	double Mul(Point p1, Point p2, Point p3)  
	{  
	    return (p2.x - p1.x) * ( p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);  
	}  
	double Dis(Point a, Point b)  
	{  
	    return Math.sqrt((a.x - b.x) * (a.x - b.x) - (a.x - b.y) * (a.y - b.y));  
	}  

}

class Point{
	public double x;
	public double y;
}