import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class STAT {
	
	 static int B , H;
 
     static boolean flag;


    static{
     int B = 10;
     int H = 10;
     boolean flag = true;

     if(B <=0 && H<=0){
         System.out.println("java.lang.Exception: Breadth and height must be positive");
     }
     
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(flag){
			int area=B * H;
			System.out.print(area);
		}
		
	}

}
