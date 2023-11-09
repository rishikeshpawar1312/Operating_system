 import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lru {
    public static void main(String[] args) {
        int[] referenceString = {1, 2, 3, 2, 1, 5, 2, 1, 6, 2, 5, 6, 3, 1, 3, 6, 1, 2, 4, 3};
        int capacity = 3; // Number of frames: 3

        Queue<Integer> pageQueue = new LinkedList<>(); // Queue to manage the pages in memory
        Stack<Integer> pageStack = new Stack<>(); // Stack to track order of page usage

        int pageFaults = 0;

        for (int page : referenceString) {
            if (!pageQueue.contains(page)) {
                pageFaults++;

                if (pageQueue.size() == capacity) {
                    int replacedPage = pageQueue.poll();
                    pageStack.removeElement(replacedPage);
                }

                pageQueue.offer(page);
                pageStack.push(page);
            } else {
                // Page is already in memory, so update its position in the stack
                pageStack.removeElement(page);
                pageStack.push(page);
            }
        }

        System.out.println("Total Page Faults: " + pageFaults);
    }
}

