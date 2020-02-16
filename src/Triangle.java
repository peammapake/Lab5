import javafx.geometry.BoundingBox;

import java.awt.*;
import java.util.ArrayList;

/**
 * Simple class representing a triangle object. Designed 
 * to show the idea of visibility, methods, class data, etc.
 *
 *   Created by Sally Goldin, 9 December 2011
 *   Modified 16 Dec 2011 to fix triangle area calculations
 *   Modified 19 Aug 2017 to draw itself, keep collection of
 *   all triangles  
 *   Modified 24 August 2017 for Exercise 3, to make into a subclass
 *   of AbstractShape
 *
 *  Modified by Bhimapaka Thapanangkun
 *  ID: 60070503447
 *
 */
public class Triangle extends AbstractShape
{
    

   /**
    * Constructor creates a new Triangle by setting the
    * values of the sets of vertext coordinates.
    * Also increments counter, sets drawing color adn stores in allFigures.
    * @param     x1        X coord of first vertex
    * @param     y1        Y coord of first vertex
    * @param     x2        X coord of second vertex
    * @param     y2        Y coord of second vertex
    * @param     x3        X coord of third vertex
    * @param     y3        Y coord of third vertex
    */
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        super();
        anchor = new Point(x1,y1);
        vertices.add(anchor);
        vertices.add(new Point(x2,y2));
        vertices.add(new Point(x3,y3));
        /*Add boundary*/
        calBoundBox();
    }

    /**
     * calculate the perimeter of this triangle
     * @return perimeter value
     */
    public double calcPerimeter()
    {
	double perimeter = 0;
        for (int i = 1; i < 4; i++)
	    {
	    perimeter = perimeter + calcLength(i);
	    } 
        return perimeter;
    }

    /**
     * calculate the area of this triangle
     * @return area value
     */
    public double calcArea()
    {
        /* area formula is
        |Ax(By - Cy) + Bx(Cy - Ay) + Cx(Ay - By)|/2
        */
        Point A = vertices.get(0);
        Point B = vertices.get(1);
        Point C = vertices.get(2);
        int numerator = A.x * (B.y - C.y);
        numerator += B.x * (C.y - A.y);
        numerator += C.x * (A.y - B.y);
        return (double) Math.abs(numerator) / 2;
    }


    /**
     * Calculate the length of one side of the triangle.
     * This is private method used by calcPerimeter and calcArea.
     * @param  which    1,2 or 3, for which side
     * @return length of side, or -1 if 'which' is out of range.
     */
    private double calcLength(int which)
    {
	double len = -1;
        int index1 = -1;
        int index2 = -1;
        switch (which)
           {
           case 1:  
                index1 = 0;
                index2 = 1;
                break;
           case 2:  
                index1 = 1;
                index2 = 2;
                break;
           case 3:  
                index1 = 0;
                index2 = 2;
                break;
	   default:
                System.out.println("Invalid argument to calcLength!");
	   }
        if (index1 >= 0)
	   {
	   Point p1 = vertices.get(index1);
	   Point p2 = vertices.get(index2);
           len = Math.sqrt(Math.pow(p1.x - p2.x,2) +
                               Math.pow(p1.y - p2.y,2)); 
	   }
	return len;
    }

    /**
     * Override toString to give more informative information
     */
    public String toString()
    {
	StringBuffer buffer = new StringBuffer();
	buffer.append("Triangle: defined by points ");
	for (int i = 0; i < 3; i++)
	{
	    Point p = vertices.get(i);
	    buffer.append(" (" + p.x + "," + p.y + ") ");
	}
	return buffer.toString();
    }



}
