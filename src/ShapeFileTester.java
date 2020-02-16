import java.awt.event.MouseEvent;

/**
 * Class to test reading of shape command files and displaying of information
 * about instances of AbstractShape that are created.
 *
 *   Created by Sally Goldin, 2 September 2017, for Exercise 4 CPE372
 *
 *   Modified by Bhimapaka Thapanangkun
 *   ID: 60070503447
 */
public class ShapeFileTester
{
    /**
     * instance of reader that knows how to parse the files 
     */
    private static ShapeReader reader;

    /**
     * main method which controls the reading and displays the results
     */
    static public void main(String args[])
    {
    	FigureViewer viewer = new FigureViewer();
		viewer.pack();
		viewer.setVisible(true);
		if (args.length != 1)
		{
			System.out.println("Usage:   java ShapeFileTester [filetoread]\n");
			System.exit(0);
		}
		reader = new ShapeReader();
		System.out.print("Trying to open'" + args[0] + "' ... ");
		if (!reader.open(args[0]))
		{
			System.out.println("FAILED!\n\n");
			System.exit(1);
		}
		System.out.println("Success!\n");
		AbstractShape nextShape = reader.readShape();
		/*Give reader a second to process before continue*/
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException ie)
		{
		}
		/*Draw all shapes*/
		while (nextShape != null)
		{
			nextShape.draw(viewer.getViewerGraphics());
			nextShape = reader.readShape();
		}

		reader.close();
		System.out.println("\nFile Closed\n\n");
    }


}