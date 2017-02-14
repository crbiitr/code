package com.java.io;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class DirList {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total time is :  " + (endTime-startTime) + " miliseconds");
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}