
#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
    
public:
    bool canVisitAllRooms(vector<vector<int>>&rooms) {
        if (rooms.size() <= 1) {
            return true;
        }
        unordered_set<int> visited;
        visited.insert(0);
        return depthFirstSearch_visitRooms(rooms, visited, 0);
    }
    
private:
    bool depthFirstSearch_visitRooms(const vector<vector<int>>&rooms, unordered_set<int>& visited, int currentRoom) {
        const vector<int>& keys = rooms[currentRoom];
        for (const auto& key : keys) {
            if (visited.find(key) == visited.end()) {
                visited.insert(key);
                depthFirstSearch_visitRooms(rooms, visited, key);
            }
        }
        return visited.size() == rooms.size();
    }
};
