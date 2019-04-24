package com.stackroute.DemoApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

public class TestThread implements Runnable {

	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			Instant startTime = Instant.now();
			System.out.println("start time is " + startTime);
			try {
				Process proc = Runtime.getRuntime().exec("/home/ashutosh/workspaces/mashup-performance-check/run.sh /");
				BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				try {
					proc.waitFor();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				while (read.ready()) {
					System.out.println(read.readLine());
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			// long endTime = System.currentTimeMillis();
			Instant endTime = Instant.now();
			System.out.println("end time is " + endTime);
			System.out.println("total time taken is " + Duration.between(startTime, endTime).toMillis());
			System.out.println("total time taken is " + Duration.between(startTime, endTime).getSeconds());

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}
