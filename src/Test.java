import java.util.Random;
import java.util.Scanner;
class Book{
    String name;
    int price;
}
class F{
    public static void main(String args[]){
        Book[] b = new Book[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            b[i] = new Book();
            b[i].name= sc.next();
            b[i].price= sc.nextInt();
        }
        for(int i=0; i<5; i++) {
            System.out.print(b[i].name);
            System.out.println("    "+b[i].price);
        }
    }
}

class G{
    public static void main(String args[]){
        int[] arr = {10,20,30,40,50};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index for adding:");
        int a = sc.nextInt();
        System.out.println("Enter value for adding:");
        int b = sc.nextInt();
        int c = arr[a];
        int d;
        arr[a]=b;
        for(int i=a+1; i<5; i++){
            d=arr[i];
            arr[i]=c;
            c=d;
        }
        for(int i=0; i<5 ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("Enter index for deletion:");
        a = sc.nextInt();
        for(int i=a; i<4; i++){
            arr[i]=arr[i+1];
        }
        arr[4]=0;
        for(int i=0; i<5; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

class Hangman3{
    public static void guess(String word, int ctr){
        char[] fi = new char[word.length()];
        for (int i = 0; i <word.length() ; i++) {
            fi[i] = '-';
        }
        //System.out.println(fi);
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
                    str = str.substring(0,k)+ch+str.substring(k+1,word.length());
                    k = word.indexOf(ch,k+1);
                }
            }
            else{
                System.out.println("Wrong Guess");
            }
            if(str.equalsIgnoreCase(word)){
                i=ctr;
            }
        }
        if(str.equalsIgnoreCase(word)){
            System.out.println("You won");
        }
        else{
            System.out.println("You lost");
            System.out.println("Word is "+word);
        }
    }
    public static void main(String[] args) {
        String[] word = {"krishna","radha","govind","gopal","hare"};
        Random ra = new Random();
        int x = ra.nextInt(word.length);
        int ctr = word[x].length()+1;
        guess(word[x],ctr);
    }
}

