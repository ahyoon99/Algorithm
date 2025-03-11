import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] matrix1;
	static int[] matrix2;
	static HashMap<Integer, Integer> cnt;

	public static void main(String[] args) throws IOException{
		input();
		int[] matrix2Copy = matrix2.clone();
		
		Arrays.sort(matrix2);
		
		for(int i=0;i<n;i++) {
			if(cnt.containsKey(matrix1[i])) {
				int getCnt = cnt.get(matrix1[i]);
				cnt.put(matrix1[i], getCnt+1);
			}
			else {
				bs(matrix1[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			if(cnt.containsKey(matrix2Copy[i])) {
				sb.append(cnt.get(matrix2Copy[i])+" ");
			}
			else {
				sb.append(0+" ");
			}
		}
		System.out.println(sb);
	}
	
	static void bs(int num) {
		int start = 0;
		int end = m-1;
		int mid = -1;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(matrix2[mid]==num) {
				if(cnt.containsKey(matrix2[mid])) {
					int getCnt = cnt.get(matrix2[mid]);
					cnt.put(matrix2[mid], getCnt+1);
				}
				else {
					cnt.put(matrix2[mid],  1);
				}
				return;
			}
			else if(matrix2[mid]<num) {
				start=mid+1;
			}
			else if(matrix2[mid]>num) {
				end=mid-1;
			}
		}
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
		cnt = new HashMap<Integer, Integer>();
	}

}
