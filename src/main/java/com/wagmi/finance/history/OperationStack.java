package main.java.com.wagmi.finance.history;

/*
 TODO[Student]: Array-based stack
 - Enforce underflow/overflow behaviors per tests.
 - Note dynamic growth is allowed only when initial capacity >= 10.
 - Validate null pushes (should throw).
 - Run `OperationStackTest` after changes.
*/

public class OperationStack {
    private  String[] data;
    private int top = -1;
    public int initialcapacity;

    public OperationStack(int capacity) {
        this.data = new String[capacity];
        this.initialcapacity = capacity;

    }

    public void push(String operation) {
        // stub
        if (operation == null) throw new NullPointerException("Cannot push null value");

        if (top==data.length-1) {
            if (initialcapacity>=10) {resize();}
            else {throw new UnsupportedOperationException("overflow");}
        }
        data[++top] = operation;
//        throw new UnsupportedOperationException("Not implemented");
    }

    public String pop() {
        // stub
        if (isEmpty()==true) throw new UnsupportedOperationException("underflow");
        return data[top--];
//        throw new UnsupportedOperationException("Not implemented");
    }

    public String peek() {
        // stub
        if (isEmpty()==true) throw new UnsupportedOperationException("Stack is Empty");
        return data[top];
//        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1;
    }

    public  void resize(){
        int newSize = data.length * 2;
        String[] newData =  new String[newSize];
        for (int i=0; i < data.length; i++ ){
            newData[i]= data[i];
        }
        data = newData;
    }



}
