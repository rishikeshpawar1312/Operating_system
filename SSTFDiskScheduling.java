 import java.util.LinkedList;
import java.util.Queue;

public class SSTFDiskScheduling {
    public static void main(String[] args) {
        int[] requests = {98, 183, 37, 122, 14, 124, 65, 67};
        int initialHead = 53;

        int totalHeadMovement = calculateTotalHeadMovement(requests, initialHead);

        System.out.println("Total Head Movement: " + totalHeadMovement);
    }

    public static int calculateTotalHeadMovement(int[] requests, int initialHead) {
        int totalHeadMovement = 0;
        int currentHead = initialHead;

        Queue<Integer> requestQueue = new LinkedList<>();
        for (int request : requests) {
            requestQueue.add(request);
        }

        while (!requestQueue.isEmpty()) {
            int shortestSeekTime = Integer.MAX_VALUE;
            int nextRequest = -1;

            for (int request : requestQueue) {
                int seekTime = Math.abs(request - currentHead);
                if (seekTime < shortestSeekTime) {
                    shortestSeekTime = seekTime;
                    nextRequest = request;
                }
            }

            totalHeadMovement += shortestSeekTime;
            currentHead = nextRequest;
            requestQueue.remove(nextRequest);
        }

        return totalHeadMovement;
    }
}
