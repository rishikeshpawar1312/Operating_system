 import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {
    public static void main(String[] args) {
        int[] referenceString = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int[] frames = new int[4]; // Number of frames: 4
        Queue<Integer> pageQueue = new LinkedList<>(); // Queue to manage the pages in memory

        int pageFaults = 0;

        for (int page : referenceString) {
            if (!pageQueue.contains(page)) {
                pageFaults++;

                if (pageQueue.size() == frames.length) {
                    int removedPage = pageQueue.poll();
                    int frameIndex = findIndex(frames, removedPage);
                    frames[frameIndex] = page;
                } else {
                    frames[pageQueue.size()] = page;
                }

                pageQueue.offer(page);
            }
        }

        System.out.println("Page Faults with 4 Frames: " + pageFaults);
    }

    private static int findIndex(int[] frames, int page) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == page) {
                return i;
            }
        }
        return -1;
    }
}

