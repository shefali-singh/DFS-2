// Time Complexity : O(n2)
// Space Complexity : O(n)

import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
                if(Character.isAlphabetic(ch) || ch=='[' || Character.isDigit(ch)){
                    st.push(ch);
                }
                else if(ch==']'){
                    StringBuilder str = new StringBuilder();
                    while(!st.isEmpty() && st.peek()!='['){
                        char t = st.pop();  
                        str.insert(0,t);
                    }
                    st.pop();
                    StringBuilder s1 = new StringBuilder();
                    while(!st.isEmpty() && Character.isDigit(st.peek()))
                    {
                        char k = st.pop();
                        s1.insert(0,k);
                    }
                    String decoded = str.toString();
                    decoded = decoded.repeat(Integer.parseInt(s1.toString()));
                    for(int j=0;j<decoded.length();j++){
                        st.push(decoded.charAt(j));
                    }

                }
        }
        
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}

