package com.defy;

import java.io.*;
import java.util.*;

public class TestClass {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
          int duration = parkingStartEndTimes.length;
          
          if(duration == 0 ) {
        	  return 0;
          }
          Arrays.sort(parkingStartEndTimes, (p, q)-> p[0]-q[0]);
          int minimum = 0;
          
          for(int i=parkingStartEndTimes[0][0]; i<parkingStartEndTimes[duration-1][1]; i++) {
        	  int count = 0;
        	  
        	  for(int j=0; j<duration; j++) {
        		  int p = parkingStartEndTimes[j][0];
        		  int q = parkingStartEndTimes[j][1];
        		  if(p <= i && i<=q-1) {
        			  count ++;
        		  }
        	  }
        	  if(minimum < count) {
        		  minimum = count;
        	  }
          }
          return minimum;
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}