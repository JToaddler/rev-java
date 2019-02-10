package com.madlabs.rev.java8;

import java.io.File;

public class Function {

	public void filterFile() {
		System.out.println((new File(".").listFiles(File::isFile)));
	}

	public static boolean test(File file) {
		System.out.println("" + file.toString());
		return true;
	}
}
