package Stack;

import java.util.Random;

public class Main {
    public static double testStack(Stack<Integer> stack,int opCount){
        Random random = new Random();
        long start = System.nanoTime();
        for(int i = 0;i < opCount;i++)
            stack.push(random.nextInt());
        for(int i = 0;i < opCount;i++)
            stack.pop();
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        double time = testStack(arrayStack,opCount);
        /*System.out.println(testStack(arrayStack,opCount));*/
        System.out.println(time);
        LinkedListStack<Integer> linkedliststack = new LinkedListStack<Integer>();
        double aa = testStack(linkedliststack,opCount);
        System.out.println(aa);
        /*System.out.println(testStack(linkedliststack,opCount));*/



    }
}
