import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class GameEntry {
    private String name;
    int score;

    GameEntry(String name, int score){
        this.name=name;
        this.score=score;
    }
    public String toString(){
        return "("+name+","+score+")";
    }
}

class Scoreboard {
    private int numEntries = 0;
    GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry gameEntry) {
        int newScore = gameEntry.score;

        if (numEntries < board.length || newScore > board[numEntries - 1].score) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].score < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = gameEntry;
        }
    }
}

class Hangman3{
    public static int guess(String word, int ctr){
        char[] fi = new char[word.length()];
        for (int i = 0; i <word.length() ; i++) {
            fi[i] = '-';
        }
        int score = 0;
        String str = new String(fi);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <ctr ; i++) {
            System.out.println("Available Guess :"+(ctr-i));
            System.out.println(str);
            char ch = sc.next().charAt(0);
            int j=0;
            int k = word.indexOf(ch,j);
            if(k!=-1){
                while(k!=-1){
                    score += 100;
                    str = str.substring(0,k)+ch+str.substring(k+1,word.length());
                    k = word.indexOf(ch,k+1);
                }

            }
            else{
                score -=100;
                System.out.println("Wrong Guess");
            }
            if(str.equalsIgnoreCase(word)){
                i=ctr;
            }
        }
        if(str.equalsIgnoreCase(word)){
            System.out.println("Hurray!! You won");
        }
        else{
            System.out.println("Oops!! You lost");
            System.out.println("Word is "+word);
        }
        return score;
    }
    public static void main(String[] args) {
        String[] word = {"krishna", "radha", "govind", "gopal", "hare"};
        Scoreboard scoreboard = new Scoreboard(5);
        Random ra = new Random();
        int x;
        int ctr;
        Scanner sc = new Scanner(System.in);
        GameEntry gameEntry;
        String name;
        int score;
        char ch;
        System.out.println("!!!! Welcome to Hangman Game !!!!");
        do {
            System.out.print("Enter Your Name: ");
            name = sc.next();
            x = ra.nextInt(word.length);
            ctr = word[x].length() + 3;
            score = guess(word[x], ctr);
            gameEntry = new GameEntry(name,score);
            scoreboard.add(gameEntry);
            System.out.println("Your Score : "+score);
            System.out.println("Scoreboard");
            System.out.println(Arrays.toString(scoreboard.board));
            System.out.println("Play again (Y/N) ");
            ch = sc.next().charAt(0);
        }while(ch=='Y' || ch=='y');
    }
}
