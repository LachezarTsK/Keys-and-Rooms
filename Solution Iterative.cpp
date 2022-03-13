
#include <queue>
#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
  
public:
    bool canVisitAllRooms(vector<vector<int>>&rooms) {
        if (rooms.size() <= 1) {
            return true;
        }

        queue<int> queue;
        unordered_set<int> visited;
        visited.insert(0);
        queue.push(0);

        while (!queue.empty()) {
            const int roomID = queue.front();
            queue.pop();
            const vector<int>& keys = rooms[roomID];

            for (const auto& key : keys) {
                if (visited.find(key) == visited.end()) {
                    visited.insert(key);
                    queue.push(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
};
