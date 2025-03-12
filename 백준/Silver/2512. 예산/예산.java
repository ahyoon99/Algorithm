import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] matrix;
	static int totalPrice;
	static int price;

	public static void main(String[] args) throws IOException{
		input();
		Arrays.sort(matrix);
		
		int start = 0;
		int end = matrix[n-1];
		
		int mid = -1;
		while(start<=end) {
			mid = (start+end)/2;
			int budget = calculate(mid);
			if(budget==totalPrice) {
				price = Math.max(price, mid);
				break;
			}
			else if(budget<totalPrice) {
				price = Math.max(price, mid);
				start = mid+1;
			}
			else if(budget>totalPrice) {
				end = mid-1;
			}
		}
		System.out.println(price);
	}
	
	static int calculate(int maxValue) {
		int total = 0;
		for(int i=0;i<n;i++) {
			if(maxValue<matrix[i]) {
				total+=maxValue;
			}
			else {
				total+=matrix[i];
			}
		}
		return total;
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
		
		st = new StringTokenizer(br.readLine(), " ");
		totalPrice = Integer.parseInt(st.nextToken()); 
		
		price = Integer.MIN_VALUE;
	}

}
