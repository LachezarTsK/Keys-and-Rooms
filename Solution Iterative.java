
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 1) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int roomID = queue.poll();
            final List<Integer> keys = rooms.get(roomID);
            for (final int key : keys) {
                if (visited.add(key)) {
                    queue.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
