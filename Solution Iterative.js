
/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function (rooms) {
    if (rooms === undefined || rooms === null || rooms.slength <= 1) {
        return true;
    }
    
    const queue = new Queue();
    const visited = new Set();
    queue.enqueue(0);
    visited.add(0);
    
    while (!queue.isEmpty()) {
        const roomID = queue.dequeue();
        const keys = rooms[roomID];
        
        for (const key of keys) {
            if (!visited.has(key)) {
                visited.add(key);
                queue.enqueue(key);
            }
        }
    }
    return visited.size === rooms.length;
};
