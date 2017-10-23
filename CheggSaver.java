import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

/**
 * Saves Chegg Textbook Solutions.
 * @author Jayden Weaver
 *
 */
public class CheggSaver {
	public static void main(String args[]){
		Rectangle screenArea = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		int numSolutions = Integer.parseInt(args[0]);
		BufferedImage bufferedImage;
		File outputFile, directory;
		try {
			Robot robot = new Robot();  //beep boop boop bop
			System.out.println("Load the Chegg Solution within 8 seconds...");
			TimeUnit.SECONDS.sleep(8);
			System.out.println("Saving Solutions...");
			directory = new File("Solutions\\");
			directory.mkdir();

			for (int i = 0; i < numSolutions; i++){
				bufferedImage = robot.createScreenCapture(screenArea);
				outputFile = new File("Solutions\\" + "Solution " + i + ".jpg");
				ImageIO.write(bufferedImage, "jpg", outputFile);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				TimeUnit.SECONDS.sleep(4); //wait for the page to load.
			}

		} catch (Exception e){
		}
	}
}