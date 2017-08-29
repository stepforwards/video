package com.forward.video.util;

import java.util.Random;

public class MyCaptcha {
	
	public static String createCaptcha(){
		return ""+(new Random().nextInt(100000-10000)+10000);
	}
}
