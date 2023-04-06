import java.util.*;
import java.io.*;

public class Main {
    final static int NWORDS = 5000;
    
    static Hashtable<String, int> getWordID = new Hashtable<>();
    static String words[NWORDS + 5];
    static int cntWords = 0;
    static int nNext[NWORDS + 5][NWORDS + 5];
    
    static void learnData(){
        Scanner data = new Scanner(new File("data-to-learn.txt"));
        String prevWord = data.next();
        getWordID[preWord] = cntWords++;
        
        while(data.hasNext()){
            String curWord = data.next();
            for(int i=0;i<curWord.length();i++){
                if(curWord[i]>='A' && curWord[i]<='Z'){
                    curWord[i]=curWord[i]-'A'+'a';
                }
                if(curWord[i]=='.')
                    curWord[i]='\0';
            }
            if(curWord[0]>='a' && curWord[0]<='z' && curWord[curWord.length()-1]>='a' && curWord[curWord.length()-1]<='z'){
                if(!getWordID.containsKey(curWord)){
                    getWordID[curWord] = cntWords;   
                    words[cntWords] = curWord;
                    cntWords++;
                }
                nNext[getWordID[prevWord]][getWordID[curWord]]++;
                prevWord = curWord;
            }
        }
    }   

    static void generateStuff(String firstWord){
        System.out.println(firstWord);
        int preID = getWordID[firstWord];

        for(int i=0;i<1000;i++){
            int nextID = 0;
            for(j=1;j<NWORDS;j++){
                if(nNext[preID][j] > nNext[preID][nextID])
                    nextID = j;
            }
            System.out.println(" " + words[nextID]);
            preID = nextID;
        }
    }
    
    public static void main(String args[]){
        learnData();   
        Scanner input = new Scanner(System.in);
        generateStuff(input.next());
    }
}
