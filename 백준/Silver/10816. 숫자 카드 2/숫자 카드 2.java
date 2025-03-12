import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] matrix1;	// 상근이가 가지고 있는 숫자 카드 
	static int[] matrix2;	// 개수를 구해야하는 숫자 카드 목록 
	static HashMap<Integer, Integer> cnt;	// 결과(카드 개수)를 저장할 hashmap 

	public static void main(String[] args) throws IOException{
		// 입력 받기 
		input();
		
		// 출력 순서를 유지하기 위해 배열 따로 복사해놓기 
		int[] matrix2Copy = matrix2.clone();
		
		// 이분탐색을 위해 정렬하기 
		Arrays.sort(matrix2);
		
		for(int i=0;i<n;i++) {
			if(cnt.containsKey(matrix1[i])) {	// 이미 존재하는 카드라면, 개수만 증가시켜주기 
				int getCnt = cnt.get(matrix1[i]);
				cnt.put(matrix1[i], getCnt+1);
			}
			else {	// 존재하지 않는 카드라면, 탐색하기 
				bs(matrix1[i]);
			}
		}
		
		// 결과 출력하기 
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
	
	// 이분탐색 
	static void bs(int num) {
		int start = 0;
		int end = m-1;
		int mid = -1;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(matrix2[mid]==num) {	// 찾고자 하는 숫자를 찾은 경우 
				cnt.put(matrix2[mid],  1);
				return;
			}
			else if(matrix2[mid]<num) {	// 현재 탐색하는 값이 찾고자하는 숫자보다 작은 경우 
				start=mid+1;
			}
			else if(matrix2[mid]>num) {	// 현재 탐색하는 값이 찾고자하는 숫자보다 큰 경우 
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