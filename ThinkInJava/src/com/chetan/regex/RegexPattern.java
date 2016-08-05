/**
 * 
 */
package com.chetan.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Chetan Raj Bharti
 *
 */
public class RegexPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String Input1 = "chetan raj 1234567 bharti";
//		String pattern1 = "(.*)(\\d+)(.*)";

//		String Input2 = "chet,an r.,aj, bharti";
//		String pattern2 = "(\\w)(\\s)([\\.,])";	
//		
//		String Input2 = "<title>Chetan Raj Bharti</title>";
//		String pattern2 = "(?i)(<title.*?>)(.+?)(</title>)";	

		String Input2 = "<img border=\"0\" src=\"http://r.edge.inmobicdn.net/FileData/0a4273355ab449dfa796f8fa945576b2.jpeg\" alt=\" \" height=\"50\" width=\"320\"/>  <style>body{margin:0}</style> <img src=\"http://et.w.inmobi.com/c.asm/C/b/dy199fmctm/15xl/g/2m/ba/u/0/0/0/x/c8778b1c-014a-1000-d47f-44eb3e4500d3/0/0/-1/0/0/x/8730386/RTBS/2t/0/api/5.0.0/dir/eA~~/6/5087012a?m=18\" width=\"1\" height=\"1\" style=\"display:none;\" /><img style=\"position:absolute; left: -10000px;\" width=\"1\" height=\"1\" src=\"http://my.mobfox.com/exchange.pixel.php?h=8a8fd6509f366b8c5d068926a5cd86f6\"/>";
		String pattern2 = "<img [^>]*?>";	

		
		Pattern p = Pattern.compile(pattern2);
		Matcher m = p.matcher(Input2);
		
		while (m.find()) {
			System.out.println(m.group());
		}

		

	}

}
