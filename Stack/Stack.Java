import java.lang.*;
import java.util.*;

class Stack{
    private int MAX = 1000;
    private int top;
    private int stack[] = new int[MAX];
    
    Stack(){
        this.top = -1;
    }

    public boolean isEmpty(){
        return (top<0);
    }

    public int size(){
        return this.stack.length;
    }

    public boolean push(int N){
        if(top == MAX-1){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
            this.stack[++top] = N;
            return true;
        }
    }

    public int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            return this.stack[top--];
        }
    }

    public int peek(){
        return this.stack[top];
    }

    // public int size(){
    //     return this.stack.length();
    // }

    public void print(){
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.isEmpty());
        st.push(5);
        System.out.println(st.isEmpty());
        st.push(8);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(9);
        st.push(1);
        System.out.println(st.peek());
        st.print();
    }

}