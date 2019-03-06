package Queue;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> queue, int opCount){
        Random random = new Random();
        long startTime = System.nanoTime();
        for(int i = 0;i < opCount;i++){
            queue.enqueue(random.nextInt());
        }
        for(int i = 0;i < opCount;i++)
            queue.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 10000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        System.out.println(testQueue(arrayQueue,opCount));
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        System.out.println(testQueue(loopQueue,opCount));
    }
}
