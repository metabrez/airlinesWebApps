package edu.mum.gf.workaround;

import java.util.Random;

import javax.json.Json;
import javax.json.JsonObject;

public class ExtraUtil {
	
	public static JsonObject sucessMessage(){

		 JsonObject value = Json.createObjectBuilder()
		     .add("status", "Sucess")
		     .add("message", "Sucessfully deleted")
		     .build();
		 
		 return value;
	}
	
	public static String getRandomString() {
       String STRCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       StringBuilder str = new StringBuilder();
       Random random = new Random();
       while (str.length() < 3) { // length of the random string.
           int index = (int) (random.nextFloat() * STRCHARS.length());
           str.append(STRCHARS.charAt(index));
       }
       String resultStr = str.toString();
       return resultStr;

}
}