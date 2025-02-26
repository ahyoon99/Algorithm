import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int k;

	static int[][] matrix;
	static int[] orders;
	static int[][] scores;

	static int scoreTemp;

	static int[] dx = { 0, 1, 0, -1 }; // 동, 남, 서, 북
	static int[] dy = { 1, 0, -1, 0 };

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		findScores();
		solution();
		System.out.println(scoreTemp);
	}

	public static void solution() {
		int x = 0;
		int y = 0;
		int dir = 0;
		
		for (int iter = 0; iter < k; iter++) {
			// 1. 주사위가 이동 방향으로 한 칸 굴러간다.
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (!isValid(nx, ny)) { // 이동 방향에 칸이 없다면
				dir = (dir + 2) % 4; // 이동 방향을 반대로 한 다음
				nx = x + dx[dir]; // 한 칸 굴러간다.
				ny = y + dy[dir];
			}
			changeDice(dir);
			
			// 2. 점수를 획득한다.
			scoreTemp += scores[nx][ny]*matrix[nx][ny];
			
			// 3. 이동 방향을 결정한다.
			if (orders[0] > matrix[nx][ny]) {
				dir = (dir + 1) % 4;
			} else if (orders[0] < matrix[nx][ny]) {
				dir = (dir + 3) % 4;
			}
			x=nx;
			y=ny;
		}
	}

	public static void findScores() {
		int tempCnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (scores[i][j] == -1) {
					bfs(i, j, tempCnt);
					tempCnt++;
				}
			}
		}

		int[] tempCntArr = new int[tempCnt];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempCntArr[scores[i][j]]++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				scores[i][j] = tempCntArr[scores[i][j]];
			}
		}
	}

	static void bfs(int x, int y, int cnt) {
		Queue<Node> q = new ArrayDeque<>();

		q.add(new Node(x, y));
		scores[x][y] = cnt;

		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (!isValid(nx, ny)) {
					continue;
				}
				if (matrix[nx][ny] == matrix[x][y] && scores[nx][ny] == -1) {
					q.add(new Node(nx, ny));
					scores[nx][ny] = cnt;
				}
			}
		}
	}

	static void changeDice(int dir) {
		// 순서 : 동, 남, 서, 북
		if (dir == 0) {
			rotateRight();
		} else if (dir == 1) {
			rotateDown();
		} else if (dir == 2) {
			rotateLeft();
		} else if (dir == 3) {
			rotateUp();
		}
	}

	static void rotateRight() {
		int[] temp = orders.clone();
		orders[0] = temp[4];
		orders[2] = temp[5];
		orders[4] = temp[2];
		orders[5] = temp[0];
	}

	static void rotateLeft() {
		int[] temp = orders.clone();
		orders[0] = temp[5];
		orders[2] = temp[4];
		orders[4] = temp[0];
		orders[5] = temp[2];
	}

	static void rotateUp() {
		int[] temp = orders.clone();
		orders[0] = temp[3];
		orders[1] = temp[0];
		orders[2] = temp[1];
		orders[3] = temp[2];
	}

	static void rotateDown() {
		int[] temp = orders.clone();
		orders[0] = temp[1];
		orders[1] = temp[2];
		orders[2] = temp[3];
		orders[3] = temp[0];
	}

	static boolean isValid(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < m) {
			return true;
		}
		return false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		orders = new int[] { 6, 5, 1, 2, 3, 4 };
		scores = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(scores[i], -1);
		}
	}
}
