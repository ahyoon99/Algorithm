import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] matrix1;
	static int[] matrix2;

	public static void main(String[] args) throws IOException{
		input();
		Arrays.sort(matrix1);
		for(int i=0;i<matrix2.length;i++) {
			bs(matrix2[i]);
		}
	}
	
	static void bs(int num) {
		int start=0;
		int end=n-1;
		int mid = -1;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(matrix1[mid]==num) {
				System.out.println(1);
				return;
			}
			else if(matrix1[mid]<num) {
				start = mid+1;
			}
			else if(matrix1[mid]>num) {
				end = mid-1;
			}
		}
		System.out.println(0);
		
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		matrix1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			matrix1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		matrix2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			matrix2[i] = Integer.parseInt(st.nextToken());
		}
	}

}
