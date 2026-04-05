import java.util.*;

class Solution {
    static char[][] charStorage;
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
        charStorage = new char[storage.length][storage[0].length()];
        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[i].length();j++){
                charStorage[i][j] = storage[i].charAt(j);
            }
        }
        
        
        for(int i=0;i<requests.length;i++){
            String com = requests[i];
            if(com.length()==1){
                removeCrane(com.charAt(0));    
            } else {
                removeAll(com.charAt(0));
            }
        }
        
        int answer = 0;
        for(int i=0;i<charStorage.length;i++){
            for(int j=0;j<charStorage[i].length;j++){
                if(charStorage[i][j]!='0'){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    
    static void removeCrane(char ch){
        boolean[][] outside = findOutside();
        char[][] newStorage = new char[charStorage.length][charStorage[0].length];
        
        for(int i=0;i<charStorage.length;i++){
            for(int j=0;j<charStorage[i].length;j++){
                if(charStorage[i][j]!=ch){
                    newStorage[i][j] = charStorage[i][j];
                    continue;
                }
                
                boolean removable = false;
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isValid(nx, ny) || outside[nx][ny]){
                        removable = true;
                        break;
                    }
                }
                
                if(removable){
                    newStorage[i][j]='0';
                }else{
                    newStorage[i][j] = ch;
                }
            }
        }
        
        for(int i=0;i<charStorage.length;i++){
            for(int j=0;j<charStorage[i].length;j++){
                charStorage[i][j] = newStorage[i][j];
            }
        }
        
    }
    
    static boolean[][] findOutside(){
        boolean[][] outside = new boolean[charStorage.length][charStorage[0].length];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<charStorage.length;i++){
            for(int j=0;j<charStorage[0].length;j++){
                if(i==0 || j==0 || i==charStorage.length-1 || j==charStorage[0].length-1){
                    if(charStorage[i][j]=='0' && !outside[i][j]){
                        outside[i][j] = true;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(isValid(nx, ny) && !outside[nx][ny] && charStorage[nx][ny]=='0'){
                    outside[nx][ny]=true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return outside;
    }
    
    static void removeAll(char ch){
        for(int i=0;i<charStorage.length;i++){
            for(int j=0;j<charStorage[i].length;j++){
                if(charStorage[i][j]==ch){
                    charStorage[i][j]='0';
                }
            }
        }
    }
    
    static boolean isValid(int x, int y){
        if(0<=x && x<charStorage.length && 0<=y && y<charStorage[0].length){
            return true;
        }
        return false;
    }
}