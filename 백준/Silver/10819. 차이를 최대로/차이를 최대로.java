import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] matrix;
	static int result;

	public static void main(String[] args) throws IOException{
		input();
		Arrays.sort(matrix);
		
		do {
			//calculate(matrix);
			int sum = 0;
			for(int i=0;i<matrix.length-1;i++) {
				sum+=Math.abs(matrix[i]-matrix[i+1]);
			}
			result = Math.max(result, sum);
		}while(nextPermutation());
		
		System.out.println(result);
	}
	
	static boolean nextPermutation() {
		int i = n-1;
		while(i>0 && matrix[i-1]>=matrix[i]) {
			i--;
		}
		
		if(i==0) {
			return false;
		}
		
		int j = n-1;
		while(matrix[i-1]>=matrix[j]) {
			j--;
		}
		
		swap(i-1, j);
		
		int k = n-1;
		while(i<k) {
			swap(i,k);
			i++;
			k--;
		}
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = matrix[i];
		matrix[i]=matrix[j];
		matrix[j]=temp;
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		result=Integer.MIN_VALUE;
	}
}
