
/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function (rooms) {
    if (rooms === undefined || rooms === null || rooms.slength <= 1) {
        return true;
    }
    const visited = new Set();
    visited.add(0);
    return depthFirstSearch_visitRooms(rooms, visited, 0);
};

/**
 * @param {number[][]} rooms
 * @param {Set (number)} visited
 * @param {number} currentRoom 
 * @return {boolean}
 */
function depthFirstSearch_visitRooms(rooms, visited, currentRoom) {
    const keys = rooms[currentRoom];
    for (const key of keys) {
        if (!visited.has(key)) {
            visited.add(key);
            depthFirstSearch_visitRooms(rooms, visited, key);
        }
    }
    return visited.size === rooms.length;
}
