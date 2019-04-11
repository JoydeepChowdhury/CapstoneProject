package com.wipro.joydeep.utilities;

import org.springframework.stereotype.Component;

@Component
public class UniqueUserId {
	  static long current= System.currentTimeMillis();
	  static public synchronized long get(){
	    return current++;
	    }
	}