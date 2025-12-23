import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int n;
	static int R;
	static int C;
	static int num;
	
	public static void main(String[] args) throws IOException{
		input();
		search(R, C, n);
		System.out.println(num);
	}
	
	static void search(int x, int y, int size) {
		if(size==1) {
			return;
		}
		else if(x<size/2 && y<size/2) {		// 좌상 
			search(x, y, size/2);
		}
		else if(x<size/2 && y>=size/2) {	// 우상  
			num += (Math.pow(size/2, 2));
			search(x, y-size/2, size/2);
		}
		else if(x>=size/2 && y<size/2) {	// 좌하 
			num += 2 * Math.pow(size/2, 2);
			search(x-size/2, y, size/2);
		}
		else if(x>=size/2 && y>=size/2) {	// 우하 
			num+= 3 * Math.pow(size/2, 2);
			search(x-size/2, y-size/2, size/2);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		n = (int) Math.pow(2, N);
		num = 0;
	}

}
