import java.util.LinkedList;
import java.util.Queue;

public class FCFSDiskScheduling {
    public static void main(String[] args) {
        Queue<Integer> requestQueue = new LinkedList<>();
        requestQueue.add(98);
        requestQueue.add(183);
        requestQueue.add(37);
        requestQueue.add(122);
        requestQueue.add(14);
        requestQueue.add(124);
        requestQueue.add(65);
        requestQueue.add(67);

        int initialHead = 53;

        int totalHeadMovement = calculateTotalHeadMovement(requestQueue, initialHead);

        System.out.println("Total Head Movement: " + totalHeadMovement);
    }

    public static int calculateTotalHeadMovement(Queue<Integer> requestQueue, int initialHead) {
        int totalHeadMovement = 0;
        int currentHead = initialHead;

        while (!requestQueue.isEmpty()) {
            int request = requestQueue.poll();
            int movement = Math.abs(request - currentHead);
            totalHeadMovement += movement;
            currentHead = request;
        }

        return totalHeadMovement;
    }
}

