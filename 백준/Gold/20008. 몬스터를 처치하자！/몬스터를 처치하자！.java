import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int HP;
	
	static Skill[] skills;
	static int[] times;
	
	static int min;
	
	static class Skill{
		int time;
		int damage;
		
		Skill(int time, int damage){
			this.time=time;
			this.damage=damage;
		}
	}
	
	static public void main(String args[]) throws IOException{
		input();
		go(HP, 0);
		System.out.println(min);
	}
	
	static void go(int HP, int curTime) {
		if(HP<=0) {
			min = Math.min(min, curTime);
			return;
		}
		
		boolean possibleAttack = false;
		for(int i=0;i<n;i++) {
			if(times[i]>curTime) {
				continue;
			}
			
			possibleAttack = true;
			
			int prevTime = times[i];
			
			times[i]=curTime+skills[i].time;
			go(HP-skills[i].damage, curTime+1);
			times[i]=prevTime;
		}
		if(!possibleAttack) {
			go(HP, curTime+1);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		HP = Integer.parseInt(st.nextToken());
		
		skills = new Skill[n];
		times = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			skills[i] = new Skill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		min = Integer.MAX_VALUE;
	}
}
