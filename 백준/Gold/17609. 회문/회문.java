import java.util.*;
import java.io.*;

public class Main {
	static int t;
	static String command;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		t = Integer.parseInt(st.nextToken());

		
		for(int testcase=1;testcase<=t;testcase++) {
			input(br, st);
			System.out.println(solution());
		}
	}
	
	static int solution() {
		int i=0;
		int j=command.length()-i-1;
		boolean isRemove=false;
		while(true) {
			if(i>=j) {
				break;
			}
			if(command.charAt(i)==command.charAt(j)) {
				i++;
				j--;
				continue;
			}
			if(isRemove) {
				return 2;
			}
			if(palindrome(command.substring(i,j)) || palindrome(command.substring(i+1, j+1))) {
				isRemove=true;
				return 1;
			}
			else {
				return 2;
			}
		}
		return 0;	
	}
	
	static boolean palindrome(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		command = st.nextToken();
	}

}
