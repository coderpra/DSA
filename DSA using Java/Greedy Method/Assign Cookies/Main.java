/*
The Assign Cookies problem is a classic greedy algorithm problem often found on LeetCode (problem 455). Here's a breakdown of the problem and its solution:
Problem Statement:
You are given two arrays:
g: Representing the greed factor of each child. g[i] is the minimum size of a cookie that the i-th child will be content with.
s: Representing the size of each cookie. s[j] is the size of the j-th cookie.
You can assign at most one cookie to one child. Your goal is to maximize the number of content children and return that number.
Example:
Code

g = [1, 2, 3] //greed factor of each child
s = [1, 1]    //size of each cookie
Explain
Output: 1
Explanation: You can only make the child with greed factor 1 content. You can assign either cookie of size 1 to that child.
Approach:
1. Sort both arrays:
Sort both the greed factor array g and the cookie size array s in ascending order.
2. Greedy Assignment:
Use two pointers, one for g and one for s.
If the current cookie s[j] is greater than or equal to the current child's greed factor g[i], assign the cookie and move both pointers forward.
If not, move the cookie pointer forward to find a larger cookie.
 */

 import java.util.*;

 class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> g = new ArrayList<Integer>();
        System.out.print("Enter the greed factor array in one line separated by space: ");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        
        for (String n : inputArray) {
            g.add(Integer.parseInt(n));
        }

        ArrayList<Integer> s = new ArrayList<Integer>();
        System.out.print("Enter the Array containing size of each cookie in one line separated by space: ");
        input = sc.nextLine();
        inputArray = input.split(" ");
        
        for (String n : inputArray) {
            s.add(Integer.parseInt(n));
        }

        //step 1 : sorting the arrays g and s
        Collections.sort(g);
        Collections.sort(s);

        // Step 2: Greedy Assignment
        int childrenSatisfied = 0;
        int i = 0; // pointer for g (greed factors)
        int j = 0; // pointer for s (cookie sizes)

        while(i < g.size() && j < s.size()){ //loop will continue until check is complete either for all children or for all cooky or both

            if(s.get(j)>=g.get(i)){ //checks if cooky j from array s satisfies the greed of child i from the greedy array g
                childrenSatisfied++; //number of satisfied children inreased
                i++; //next children from the array g
            }

            j++; //point to next cookie to check if it satisfies the greed of child i from the greedy array g
        }
        // Print the result
        System.out.println("Number of content children: " + childrenSatisfied);
        

        
        sc.close();

    }
 }

