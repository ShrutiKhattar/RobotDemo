public class ScreenCaptureApp {
  public class ScreenCapture {
private int delay=10000;
  public static void main(String[] argv) throws InterruptedException {
		ScreenCapture screenCapture = new ScreenCapture();
		screenCapture.captureScreenShots();
	}

	boolean captureScreenShots() throws InterruptedException {
		boolean isSuccesfol = false;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		try {
			Robot robot = new Robot();
			BufferedImage[] screenshots = new BufferedImage[20];
			Rectangle bounds = new Rectangle(0, 0, (int) size.getWidth(),
					(int) size.getHeight());
			for (int i = 1; i < screenshots.length; i++) {
				System.out.println("Running");
				screenshots[i] = robot.createScreenCapture(bounds);
				Thread.sleep(delay); 
				try {
					ImageIO.write(screenshots[i], "jpeg", new File(
							"C:/ServerLogs/log" + i + ".jpeg"));  /*Writing the array of  screenshots to the Files
													on the specified path*/
				} catch (IOException e) {
					e.printStackTrace();
					isSuccesful = false;
				}
			}
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		return isSuccesful;
	}
}

}
