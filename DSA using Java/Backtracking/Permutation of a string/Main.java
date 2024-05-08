import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;

class Main{
    static void BackTracking(ArrayList<Character> mainArray,Stack<Character> helperStack,ArrayList<Stack<Character>> ansArray){
        if (mainArray.isEmpty()) {
            ansArray.add(helperStack);
            return;
        }
            for(int i=0;i<mainArray.size();i++){
                helperStack.push(mainArray.get(i));
                mainArray.remove(i);

                //creating a dummymainAraay to copy mainArray so, datas will be manupulated in this dummy veriable in further recursive calls but the mainarray datas will be intact
                ArrayList<Character> dummymainArray = new ArrayList<>();
                dummymainArray.addAll(mainArray);
                //creating a dummyhelperStack to copy helperStack so, datas will be manupulated in this dummy veriable in further recursive calls but the helperStack datas will be intact
                Stack<Character> dummyhelperStack = new Stack<>();
                dummyhelperStack.addAll(helperStack);

                BackTracking(dummymainArray,dummyhelperStack,ansArray);
                mainArray.add(i,helperStack.pop());
            }
        }

    static ArrayList<Stack<Character>> permutation(char[] str){
        ArrayList<Character> mainArray = new ArrayList<Character>();
        for(char c : str){
            mainArray.add(c);
        }
        ArrayList<Stack<Character>> ansArray =new ArrayList<>();
        BackTracking(mainArray,new Stack<Character>(),ansArray);
        return ansArray;
    }

    public static void main(String [] arg){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        char [] str = sc.nextLine().toCharArray();
        System.out.println("The permutations set of the string is"+ permutation(str));
        sc.close();
    }
}