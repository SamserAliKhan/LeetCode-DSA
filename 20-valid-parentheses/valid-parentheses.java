class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        char ch;
        if(length%2!=0)return false;
        Stack <Character> Stk = new Stack<>();
        for(int i=0;i<length;i++){
            ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                Stk.push(ch);
            }
            else{
                if(Stk.isEmpty()){
                    return false;
                }
                if ((ch == ')' && Stk.peek() == '(') ||(ch == '}' && Stk.peek() == '{') ||(ch == ']' && Stk.peek() == '[')) {
                    // If they match, pop the opening bracket from the stack
                    Stk.pop();
                } else {
                    // If they don't match, it's an invalid string
                    return false;
                }
            }
            // else{
                
            // if(ch==')' && Stk.peek()=='(') Stk.pop();
            // if(ch=='}' && Stk.peek()=='{') Stk.pop();
            // if(ch==']' && Stk.peek()=='[') Stk.pop();
            // }
        }
        return((Stk.isEmpty()));
    }
}