package redbus.multiObjectRepo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! checking fetch again" );
    }
    
    public void swipeBasedOnText(String strText) throws Throwable {
		try {
			if (DriverManagerFactory.getDriverData("Platform Name").trim().equalsIgnoreCase("ANDROID")) {
				appiumDriver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
								+ strText + "\").instance(0))"));
				logger.info("scrolled to the element with text :: " + strText);
			} else if (DriverManagerFactory.getDriverData("Platform Name").trim().equalsIgnoreCase("IOS")) {
				appiumDriver.findElement(MobileBy.IosUIAutomation(
						"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
								+ strText + "\").instance(0))"));
				logger.info("scrolled to the element with text :: " + strText);
			}
		} catch (Throwable t) {
			logger.error(
					"Error while scrolling to the element with text :: " + strText + " " + t.getLocalizedMessage());
			Config.gracefulEnd(t, logger);
		}
	}
    
    
    protected boolean Swipe(int startHeightFrom, int startWidthFrom, int endHeightAt, int entWidthAt) {
		try {
			// mobileDriver.swipe(X_AXIS / startWidthFrom, Y_AXIS / startHeightFrom, X_AXIS
			// / entWidthAt,Y_AXIS / endHeightAt, 750);

			dim = getScreenResolution();
			new TouchAction(mobileDriver)
					.press(PointOption.point(dim.getWidth() / startWidthFrom, dim.getHeight() / startHeightFrom))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(750)))
					.moveTo(PointOption.point(dim.getWidth() / entWidthAt, dim.getHeight() / endHeightAt)).release()
					.perform();
		} catch (Throwable t) {
			Config.gracefulEnd(t, logger);
			logger.error("Returning 'false', Error while swiping :: " + t.getLocalizedMessage());
			return false;
		}
		return true;
	}
}
