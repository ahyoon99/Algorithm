import java.util.*;
import java.io.*;

public class Main {
	static String S;
	static String T;
	static int result;
	
	public static void main(String[] args) throws IOException{
		input();
		go(T);
		System.out.println(result);
	}
	
	static void go(String str) {
		if(str.length()==S.length()) {
			if(str.equals(S)) {
				result = 1;
			}
			return ;
		}
		
		if(str.endsWith("A")) {
			go(str.substring(0, str.length()-1));
		}
		if(str.startsWith("B")) {
			String newStr = "";
			for(int i=str.length()-1;i>=1; i--) {
				newStr += (str.charAt(i)+"");
			}
			go(newStr);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		S = st.nextToken();

		st = new StringTokenizer(br.readLine(), " ");
		T = st.nextToken();
		
		result = 0;
	}

}
