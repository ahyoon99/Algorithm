import java.util.*;
import java.io.*;

public class Solution {
	static int tc;
	static int n;
	
	static Node home;
	static Node company;
	static Node[] people;	// 고객 위치를 저장할 배열 
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("res/Day0305/input_swea1247.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			dfs2(company.x, company.y, 0, 0);
			System.out.println(result);
		}
	}
	static void dfs2(int x, int y, int idx, int distance) {
		if(idx==n) {	// 고객의 집을 전체 다 방문했다면 
			distance += Math.abs(x-home.x) + Math.abs(y-home.y);	// 마지막 고객의 집 -> 집까지의 거리를 더해주기 
			result = Math.min(result, distance);	// 경로 최소거리 갱신해주기 
			return;
		}
		for(int i=0;i<n;i++) {	
			if(visited[i]) {	// 이미 방문한 고객의 집이라
				continue;		// continue;
			}
			Node next = people[i];	// 다음 방문할 고객의 집 좌표 
			int dist = Math.abs(x-next.x) + Math.abs(y-next.y);	// 이동 경로 계산 
			visited[i]=true;	// 방문 처리 해주기 
			dfs2(next.x, next.y, idx+1, distance+dist);	// 다음 고객의 집 방문하기 
			visited[i]=false;	// 방문 처리 초기화 해주기 
		}
	}
		
	static boolean isValid(int x, int y) {
		if(0<=x && x<=100 && 0<=y && y<=100) {
			return true;
		}
		return false;
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		people = new Node[n];
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			people[i] = new Node(x,y);
		}
		
		visited = new boolean[n];
		result = Integer.MAX_VALUE;
	}
}

