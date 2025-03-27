import java.util.*;
import java.io.*;

public class Solution {
    static int tc;
    static int n;
    static Node[] nodeList;
    static double e;

    static ArrayList<Edge> edgeList;
    static ArrayList<Edge> edgeList2;
    static int[] parents;
    
    static double result;
    static int cnt;
    
	static class Node{
		int num;
	    int x;
	    int y;
	    Node(int num, int x, int y){
	        this.num=num;
	    	this.x=x;
	        this.y=y;
	    }
	}
	
	static class Edge implements Comparable<Edge>{
	    Node start;
	    Node end;
	    double weight;
	    
	    public Edge(Node start, Node end, double weight) {
	        this.start = start;
	        this.end = end;
	        this.weight=weight;
	    }
	    
	    @Override
	    public int compareTo(Edge o) {
	        return Double.compare(this.weight, o.weight);
	    }
	}
	
	public static void main(String[] args) throws IOException {
	   //  System.setIn(new FileInputStream("res/Day0327/swea1251_input.txt"));
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    tc = Integer.parseInt(st.nextToken());
	    
	    for(int testcase=1;testcase<=tc;testcase++) {
	        System.out.print("#"+testcase+" ");
	        input(br, st);
	        solution();
	    }
	}
	
	static void make() {
	    for(int i=0;i<n;i++) {
	        parents[i] = i;
	    }
	}
	
	static int find(int x) {
	    if(x==parents[x]) return x;
	    return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
	    int xRoot = find(x);
	    int yRoot = find(y);
	    
	    if(xRoot == yRoot) return false;
	    if(xRoot>yRoot) parents[yRoot] = xRoot;
	    else parents[xRoot] = yRoot;
	    
	    return true;
	}
	
	static void solution() {
	    Collections.sort(edgeList);
	    make();
	    
	    for(int i=0;i<edgeList.size();i++) {
	    	Edge edge = edgeList.get(i);
	    	if(!union(edge.start.num, edge.end.num)) continue;
	    	result+=edge.weight;
	    	if(++cnt == n-1) {
	    		break;
	    	}
	    }
	    System.out.println(Math.round(result));
	    
	}
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
	    st = new StringTokenizer(br.readLine(), " ");
	    n = Integer.parseInt(st.nextToken());
	    nodeList = new Node[n];
	
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<n;i++) {
	        int x = Integer.parseInt(st.nextToken());
	        nodeList[i] = new Node(i, x, -1);
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<n;i++) {
	        int y = Integer.parseInt(st.nextToken());
	        nodeList[i].y = y;
	    }
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    e = Double.parseDouble(st.nextToken());
	    
	    edgeList = new ArrayList<>();
	    for(int i=0;i<n-1;i++) {
	        for(int j=i+1;j<n;j++) {
	            if(i==j) continue;
	            edgeList.add(new Edge(nodeList[i], nodeList[j], e*calculateDistancePow(nodeList[i], nodeList[j])));
	        }
	    }
	    
//	    for(Edge e : edgeList) {
//	        System.out.println("("+e.start.x+","+e.start.y+") , ("+e.end.x+","+e.end.y+")" + e.weight);
//	    }
	    
	    parents = new int[n];
	    
	    result = 0;
	    cnt = 0;
	}
	
	static double calculateDistancePow(Node node1, Node node2) {
	    return Math.pow(Math.abs(node1.x-node2.x), 2)+Math.pow(Math.abs(node1.y-node2.y), 2);
	}
}