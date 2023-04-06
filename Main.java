import java.util.*;
import java.io.*;

public class Main {
    final static int NWORDS = 5000;
    
    static Hashtable<String, int> words = new Hashtable<>();
    static int cntWords = 0;
    static int nNext[NWORDS + 5][NWORDS + 5];
    
    static void learnData(){
        Scanner data = new Scanner(new File("data-to-learn.txt"));
        String prevWord = data.next();
        words[preWord] = cntWords++;
        
        while(data.hasNext()){
            String curWord = data.next();
            if(!words.containsKey(curWord)){
                words[curWord] = cntWords++;   
            }
            prevWord = curWord;
        }
    }   
    
    public static void main(String args[]){
        learnData();   
    }
}
