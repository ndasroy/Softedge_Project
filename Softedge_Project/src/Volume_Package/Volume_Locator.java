package Volume_Package;

//File to save xpaths/locators
public class Volume_Locator 
{
	
//	These could be ideally static(so that everytime we should not create object to call) 
//		& final(so that one couldn't change it from elsewhere).
	
	public static final String MathCal=".//*[@id='menu']/div[3]/a";
	public static final String VolumeCal=".//*[@id='content']/ul/li[6]/a";
	public static final String BallRadius=".//*[@id='ballradius']";
	public static final String CalculateBall="ballcal";
	public static final String BallResult=".//*[@id='content']/form/p";
	

}
