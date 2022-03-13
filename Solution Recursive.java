
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 1) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return depthFirstSearch_visitRooms(rooms, visited, 0);
    }

    public boolean depthFirstSearch_visitRooms(List<List<Integer>> rooms, Set<Integer> visited, int currentRoom) {
       final List<Integer> keys = rooms.get(currentRoom);
        for (final int key : keys) {
            if (visited.add(key)) {
                depthFirstSearch_visitRooms(rooms, visited, key);
            }
        }
        return visited.size() == rooms.size();
    }
}
