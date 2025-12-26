import java.io.*;
import java.util.*;

public class Main {
	static int A;
	static int B;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		if(A>B) {
			System.out.println(">");
		}
		else if(A<B) {
			System.out.println("<");
		}
		else if(A==B) {
			System.out.println("==");
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}

}
