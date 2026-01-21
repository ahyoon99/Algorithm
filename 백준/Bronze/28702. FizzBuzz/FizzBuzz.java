import java.io.*;
import java.util.*;

public class Main {
	static String[] com = new String[3];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = -1;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			com[i] = st.nextToken();
			if(isNumber(com[i])) {
				num = Integer.parseInt(com[i])+3-i;
			}
		}
		System.out.println(getFizzBuzzNumber(num));
	}
	
	static boolean isNumber(String com) {
		if(!com.equals("FizzBuzz") && !com.equals("Fizz") && !com.equals("Buzz")) {
			return true;
		}
		return false;
	}
	
	static String getFizzBuzzNumber(int num) {
		if(num%3==0 && num%5==0) {
			return "FizzBuzz";
		}else if(num%3==0) {
			return "Fizz";
		}else if(num%5==0) {
			return "Buzz";
		}else {
			return String.valueOf(num);
		}
	}
}
