import java.util.*;
import java.io.*;

public class Main {
	static int T;	// 테스트 데이터의 수 
	static int n;	// 팀의 개수 
	static int k;	// 문제의 개수 
	static int t;	// 우리 팀의 ID
	static int m;	// 로그 엔트리의 개수 
	
	static Info[] teams;
	static HashMap<Integer, int[]> scoreboard;
	
	static class Info implements Comparable<Info>{
		int id;
		int score;
		int cnt;
		int lastTime;
		
		Info(int id, int score, int cnt, int lastTime){
			this.id = id;
			this.score = score;
			this.cnt = cnt;
			this.lastTime = lastTime;
		}
		
		@Override
		public int compareTo(Info next) {
			if(this.score == next.score) {
				if(this.cnt == next.cnt) {
					return this.lastTime - next.lastTime; 	// 내림차순
				}
				return this.cnt - next.cnt; //	내림차순
			}
			return next.score - this.score;	// 오름차순 
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for(int testcase=0;testcase<T;testcase++) {
			input(br, st);
			solution(br, st);
		}
	}
	
	static void solution(BufferedReader br, StringTokenizer st) throws IOException{
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int teamId = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			// 제출 횟수 update
			if(teams[teamId-1].cnt == Integer.MAX_VALUE) {
				teams[teamId-1].cnt=1;
			}
			else {
				teams[teamId-1].cnt++;
			}
			
			// 점수 update 
			if(scoreboard.get(teamId)[num-1]<score) {
				scoreboard.get(teamId)[num-1]=score;
			}
			
			// 마지막 제출 시간 update
			teams[teamId-1].lastTime = i;
		}
		
		
		for(int i=1;i<=n;i++) {
			int totalScore = 0;
			int[] score = scoreboard.get(i);
			for(int j=0;j<score.length;j++) {
				totalScore += score[j];
			}
			teams[i-1].score = totalScore;
		}
		
		Arrays.sort(teams);
		
		for(int i=0;i<teams.length;i++) {
			if(teams[i].id == t) {
				System.out.println(i+1);
				break;
			}
		}
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		teams = new Info[n];
		for(int i=0;i<n;i++) {
			teams[i] = new Info(i+1, -1, Integer.MAX_VALUE, Integer.MAX_VALUE);
		}
		
		scoreboard = new HashMap<Integer, int[]>();
		for(int i=0;i<=n;i++) {
			int[] init = new int[k];
			Arrays.fill(init, 0);
			scoreboard.put(i+1, init);
		}
	}

}
