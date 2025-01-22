import java.util.*;
import java.io.*;

public class Main {
	static int r;
	static int c;
	static int t;
	
	static int[][] dust;
	static ArrayList<Node> machine;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	
	static class Node{
		int x;
		int y;
		
		Node(){}
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input(br);
		
		for(int i=0;i<t;i++) {
			spread();
			clean();
		}

		calculate();
	}
	
	static void spread() {
		int[][] dustTemp = new int[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(dust[i][j]>0) {
					int givingValue = dust[i][j]/5;
					for(int k=0;k<4;k++) {
						if(isValid(i+dx[k], j+dy[k]) && dust[i+dx[k]][j+dy[k]]!=-1) {
							dustTemp[i+dx[k]][j+dy[k]]+=givingValue;
							dustTemp[i][j]-=givingValue;
						}
					}
					
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				dust[i][j]+=dustTemp[i][j];
			}
		}
	}
		
	static void clean() {
		// machine 1
		// moveDown
		for(int i=machine.get(0).x-2;i>=0;i--) {
			dust[i+1][0]=dust[i][0];
		}
		
		// moveLeft
		for(int i=1;i<c;i++) {
			dust[0][i-1]=dust[0][i];
		}
		
		// moveUp
		for(int i=1;i<=machine.get(0).x;i++) {
			dust[i-1][c-1]=dust[i][c-1];
		}
		
		// moveRight
		for(int i=c-2;i>0;i--) {
			dust[machine.get(0).x][i+1]=dust[machine.get(0).x][i];
		}
		dust[machine.get(0).x][1]=0;
		
		// machine 2
		// moveUp
		for(int i=machine.get(1).x+2;i<r;i++) {
			dust[i-1][0]=dust[i][0];
		}
		
		// moveLeft
		for(int i=1;i<c;i++) {
			dust[r-1][i-1]=dust[r-1][i];
		}
		
		// moveDown
		for(int i=r-2;i>=machine.get(1).x;i--) {
			dust[i+1][c-1]=dust[i][c-1];
		}
		
		// moveRight
		for(int i=c-2;i>0;i--) {
			dust[machine.get(1).x][i+1]=dust[machine.get(1).x][i];
		}
		dust[machine.get(1).x][1]=0;
		
	}
	
	static void calculate() {
		int result=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(dust[i][j]>0) {
					result+=dust[i][j];
				}
			}
		}
		System.out.println(result);
	}
	
	static boolean isValid(int x, int  y) {
		if(0<=x && x<r && 0<=y  && y<c) {
			return true;
		}
		return false;
	}

	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		dust = new int[r][c];
		machine = new ArrayList<Node>();
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<c;j++) {
				dust[i][j] = Integer.parseInt(st.nextToken());
				if(dust[i][j]==-1) {
					machine.add(new Node(i,j));
				}
			}
		}
	}
	
	static void print() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(dust[i][j]+" ");
			}
			System.out.println();
		}
	}
}
