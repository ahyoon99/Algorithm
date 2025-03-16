import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int n;
    static int[] info;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static void solution() {
        Arrays.sort(info);

        long start = 1;
        long end = info[info.length - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = cutting(mid);
            
            if (cnt < n) {
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }
        System.out.println(end);
    }

    static long cutting(long key) {
        long cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += info[i] / key;
        }
        return cnt;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        info = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            info[i] = Integer.parseInt(st.nextToken());
        }
    }
}