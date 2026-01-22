class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        for(String word: words){
            if(word.length()==0){
                answer+= " ";
                continue;
            }
            word = word.toLowerCase();
            char ch = word.charAt(0);
            if('a' <= ch && ch <= 'z'){
                ch -=32;
                word = String.valueOf(ch)+word.substring(1, word.length());
            }
            answer+=word;
            answer+=" ";
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        
        answer = answer.substring(0,answer.length()-1);
        return answer;
    }
}