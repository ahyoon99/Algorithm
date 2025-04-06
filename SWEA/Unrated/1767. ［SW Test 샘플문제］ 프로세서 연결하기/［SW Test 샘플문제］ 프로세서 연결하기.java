import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int tc;
	static int n;
	static int[][] matrix;

	static ArrayList<Node> core;
	static int maxCoreCnt;
	static int minWireLength;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("res/Day0331/swea1767_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= tc; testcase++) {
			input(br, st);
			dfs2(0,0,0);
			sb.append("#" + testcase + " " + minWireLength + "\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs2(int depth, int coreCnt, int wireLength) {
		if (depth >= core.size()) {
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minWireLength = wireLength;
			} else if (maxCoreCnt == coreCnt) {
				minWireLength = Math.min(minWireLength, wireLength);
			}
			return;
		}

		int x = core.get(depth).x;
		int y = core.get(depth).y;

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nx = x;
			int ny = y;

			while (true) {
				nx += dx[i];
				ny += dy[i];

				// 범위를 벗어난 경우
				if (!isValid(nx, ny))
					break;

				// 코어 혹은 전선이 존재하는 경우
				if (matrix[nx][ny] == 1) {
					count = 0;
					break;
				}

				// 어떠한 방해도 없는 경우
				count++;
			}

			if (count == 0) {
				dfs2(depth+1, coreCnt, wireLength);
			} else {
				// 원본 배열에 전선이 지나간 길을 표시 
				int tempX = x;
				int tempY = y;
				for (int j = 0; j < count; j++) {
					tempX += dx[i];
					tempY += dy[i];
					matrix[tempX][tempY] = 1;
				}
				dfs2(depth+1, coreCnt+1, wireLength+count);
				
				// 원본 배열에 표시한 전선이 지나간 길을 초기화  	
				tempX = x;
				tempY = y;
				for(int j=0;j<count;j++) {
					tempX+=dx[i];
					tempY+=dy[i];
					matrix[tempX][tempY]=0;
				}
			}
		}
	}

	
	static void solution(int idx, int coreCnt, int wireLength) {
		if (idx == core.size()) {
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minWireLength = wireLength;
			} else if (maxCoreCnt == coreCnt) {
				minWireLength = Math.min(minWireLength, wireLength);
			}
			return;
		}

		int x = core.get(idx).x;
		int y = core.get(idx).y;

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nx = x;
			int ny = y;

			while (true) {
				nx = x + dx[i];
				ny = y + dy[i];

				// 범위를 벗어난 경우
				if (!isValid(nx, ny))
					break;

				// 다른 core나 전선이 존재하는 경우, 다른 방향으로 변경
				if (matrix[nx][ny] == 1) {
					count = 0;
					break;
				}

				// 어떠한 방해도 없었다면 count값을 1 증가
				count++;
			}

			if (count == 0) {
				solution(idx + 1, coreCnt, wireLength);
			} else {
				int tempX = x;
				int tempY = y;
				for (int j = 0; j < count; j++) {
					tempX += dx[j];
					tempY += dy[j];
					matrix[tempX][tempY] = 1;
				}

				solution(idx + 1, coreCnt + 1, wireLength + count);

				tempX = x;
				tempY = y;
				for (int j = 0; j < count; j++) {
					tempX += dx[j];
					tempY += dy[j];
					matrix[tempX][tempY] = 0;
				}
			}
		}
	}

	static boolean isValid(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) {
			return true;
		}
		return false;
	}

	static void input(BufferedReader br, StringTokenizer st) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		matrix = new int[n][n];
		core = new ArrayList<Node>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j] == 1) {
					if (i != 0 && j != 0 && i != n - 1 && j != n - 1) {
						core.add(new Node(i, j));
					}
				}
			}
		}

		maxCoreCnt = Integer.MIN_VALUE;
		minWireLength = Integer.MAX_VALUE;
	}
}
