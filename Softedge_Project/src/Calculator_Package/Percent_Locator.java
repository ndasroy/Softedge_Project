package Calculator_Package;

//File to save xpaths/locators
public class Percent_Locator 
{
	
//	These could be ideally static(so that everytime we should not create object to call) 
//		& final(so that one couldn't change it from elsewhere).
	
	public static final String MathCal=".//*[@id='menu']/div[3]/a";
	public static final String PercentCal=".//*[@id='content']/ul/li[3]/a";
	public static final String Percentage=".//*[@id='cpar1']";
	public static final String Principal=".//*[@id='cpar2']";
	public static final String Interest=".//*[@id='cpar3']";
	public static final String Calculate=".//*[@id='content']/table/tbody/tr/td[2]/input";
	
	public static final String ResultValue=".//*[@id='content']/p[2]";

}
