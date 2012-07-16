package com.webserver;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class MyTestRunner {
	public static void main(String[] args){
		System.out.println("Running Tests...");
		Result result = JUnitCore.runClasses(WebserverTest.class, DispatcherTest.class, FileServerTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
