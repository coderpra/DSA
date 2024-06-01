class Stack extends RuntimeException{
    private int stack[];
    private int top;
    private int buttom;
    private int maxSize;

    private int[] createStack(int size) throws RuntimeException{
        int arr[];
        try {
            arr = new int[size];
            return arr;
        } catch (Exception e) {
            throw new RuntimeException("Failed to allocate array of size " + size, e);
        }
    }

    //creation of stack
    public Stack(int size) throws RuntimeException{
        stack = createStack(size);
        top=-1;
        buttom = -1;
        maxSize=size;
    }

    //increase or decrease stack size
    public void stackResize(int size)throws RuntimeException{
        if(maxSize == -1){
            throw new RuntimeException("Stack Resize Failed!!\nFirst create the Stack.\n");
        }
        if(size ==0){
            throw new RuntimeException("Stack Resize Failed!!\nStack cann't be deleted this way!!\n");
        }

        if(size==maxSize){
            throw new RuntimeException("Stack Resize Failed!!\nPrevious size and new size are same.\n");
        }
        int arr[];
        try{
            arr = createStack(size);
        }
        catch(Exception e){
            throw new RuntimeException("Stack Resize Failed!!\n"+e);
        }

        if(size>maxSize){
            for(int i=0;i<maxSize;i++){
                arr[i]=stack[i];
            }
        }else if(maxSize>size){
            for(int i=0;i<size;i++){
                arr[i]=stack[i];
            }
        }

        stack=arr;
    }

    //element add
    public void add(int data) throws RuntimeException{
        if(top == maxSize-1){
            throw new RuntimeException("Stack Overflow!!\n");
        }

        if(top==-1) buttom++;

        top++;
        stack[top]=data;
    }

    public int pop()throws RuntimeException{
        if(top ==-1){
            throw new RuntimeException("Stack Underflow!!\n");
        }
        if(top ==0) buttom--;
        top--;
        return stack[top];
    }

    public int peek()throws RuntimeException{
        if(top ==-1){
            throw new RuntimeException("Stack is empty!!\n");
        }
        return stack[top];
    }
    public boolean isPeek(int data){
        if(top == -1 && stack[top]!=data){
            return false;
        }
        return true;
    }

    public void printStack(){
        if(top==-1) System.out.println("Stack is empty!!");
        for( int i=top;i>=buttom;i--){
            System.out.println(stack[i]);
        }
    }
}
class StackUsingArray {
    public static void main(String[] args) {
        try {
            // Creating a stack of size 10
            Stack myStack = new Stack(10);
            
            // Adding elements to the stack
            myStack.add(5);
            myStack.add(10);
            myStack.add(15);
            
            // Printing the stack
            myStack.printStack();
            
            // Popping an element from the stack
            int poppedElement = myStack.pop();
            System.out.println("Popped element: " + poppedElement);
            
            // Peeking at the top element of the stack
            int topElement = myStack.peek();
            System.out.println("Top element: " + topElement);
            
            // Resizing the stack
            myStack.stackResize(5);
        } catch (RuntimeException e) {
            // Handle runtime exceptions thrown by the stack operations
            System.err.println(e.getMessage());
        }
    }
}
