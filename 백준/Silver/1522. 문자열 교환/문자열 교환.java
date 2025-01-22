import java.util.*;
import java.io.*;

public class Main {
	static String command;
	static int n;
	static int result;
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		
		int cntA = command.length()-command.replace("a", "").length();
		
		for(int i=0;i<command.length();i++) {
			int cntB = 0;
			for(int j=0;j<cntA;j++) {
				if(command.charAt((i+j)%command.length())=='b') {
					cntB++;
				}
			}
			result = Math.min(result, cntB);
		}

		
		System.out.println(result);
	}
	
	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		command = st.nextToken();
		result = Integer.MAX_VALUE;
	}

}
