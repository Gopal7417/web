package zk.web;
import java.util.*; 



public class Random  {
	
	 public  String generateOTP()  
	 {
	        int randomPin   =(int) (Math.random()*9000)+1000; 
	        String otp  = String.valueOf(randomPin); 
	        return otp; //returning value of otp 
	    } 
	            public static void main(String args[])//method to call and print otp 
	    { 
	        String otpSting  =new Random().generateOTP();//function calling 
	        System.out.println("OTP : "+otpSting); 
	    } 
}
