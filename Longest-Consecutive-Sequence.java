/**
 * Problem Statement: Longest Consecutive Sequence 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 */

public class Solution {
    
    public int longestConsecutive(int[] num) {
        
        //use hashset to contain all elements
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;
        
        //put elements into hashset
        for(int i=0; i<num.length; i++)
            hs.add(num[i]);
            
        for(int i=0; i<num.length; i++){
            
            //check the longest consecutive sequence [...num[i]...]
            if(hs.contains(num[i])){
                int count = 1;
                int next = num[i]-1;
                //consecutive sequence less than num[i]
                while(hs.contains(next)){
                    //remove elements that has been visited
                    //note this is an important trick, since element which has been visted can never be in a longer sequence
                    //when traverse other num[i]
                    hs.remove(next);
                    count++;
                    next--;
                }
                
                //consecutive sequence large than num[i] 
                next = num[i]+1;
                while(hs.contains(next)){
                    hs.remove(next);
                    count++;
                    next++;
                }
                
                //calculate global max
                max = Math.max(count,max);
                
            }
        }
        
        return max;
    }
}