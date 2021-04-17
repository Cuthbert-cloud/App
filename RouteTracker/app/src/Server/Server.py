from flask import Flask, jsonify
from json import dumps

app =  Flask(__name__)

Arcs = {
    1: [(2, 1), (10, 1)],
    2: [(1, 1), (3, 1)],
    3: [(2, 1), (4, 1), (11, 1)],
    4: [(3, 1), (5, 1)],
    5: [(4, 1), (6, 1), (12, 1)],
    6: [(5, 1), (7, 1)],
    7: [(6, 1), (8, 1), (13, 1)],
    8: [(7, 1), (9, 1)],
    9: [(8, 1), (14, 1)],

    10: [(1, 1), (15, 1)],
    11: [(3, 1), (17, 1)],
    12: [(5, 1), (19, 1)],
    13: [(7, 1), (21, 1)],
    14: [(9, 1), (23, 1)],

    15: [(10, 1), (16, 1), (24, 1)],
    16: [(15, 1), (17, 1)],
    17: [(11, 1), (16, 1), (18, 1), (25, 1)],
    18: [(17, 1), (19, 1)],
    19: [(12, 1), (18, 1), (20, 1), (26, 1)],
    20: [(19, 1), (21, 1)],
    21: [(13, 1), (20, 1), (22, 1), (27, 1)],
    22: [(21, 1), (23, 1)],
    23: [(14, 1), (22, 1), (28, 1)],

    24: [(15, 1), (29, 1)],
    25: [(17, 1), (31, 1)],
    26: [(19, 1), (33, 1)],
    27: [(21, 1), (35, 1)],
    28: [(23, 1), (37, 1)],

    29: [(24, 1), (30, 1), (38, 1)],
    30: [(29, 1), (31, 1)],
    31: [(25, 1), (30, 1), (32, 1), (39, 1)],
    32: [(31, 1), (33, 1)],
    33: [(26, 1), (32, 1), (34, 1), (40, 1)],
    34: [(33, 1), (35, 1)],
    35: [(27, 1), (34, 1), (36, 1), (41, 1)],
    36: [(35, 1), (37, 1)],
    37: [(28, 1), (36, 1), (42, 1)],

    38: [(29, 1), (43, 1)],
    39: [(31, 1), (45, 1)],
    40: [(33, 1), (47, 1)],
    41: [(35, 1), (49, 1)],
    42: [(37, 1), (51, 1)],

    43: [(38, 1), (44, 1), (52, 1)],
    44: [(43, 1), (45, 1)],
    45: [(39, 1), (44, 1), (45, 1), (53, 1)],
    46: [(45, 1), (47, 1)],
    47: [(40, 1), (46, 1), (48, 1), (54, 1)],
    48: [(47, 1), (49, 1)],
    49: [(41, 1), (48, 1), (50, 1), (55, 1)],
    50: [(49, 1), (51, 1)],
    51: [(42, 1), (50, 1), (56, 1)],

    52: [(43, 1), (57, 1)],
    53: [(45, 1), (59, 1)],
    54: [(47, 1), (61, 1)],
    55: [(49, 1), (63, 1)],
    56: [(51, 1), (65, 1)],

    57: [(52, 1), (58, 1), (66, 1)],
    58: [(57, 1), (59, 1)],
    59: [(53, 1), (58, 1), (60, 1), (67, 1)],
    60: [(59, 1), (61, 1)],
    61: [(54, 1), (60, 1), (62, 1), (68, 1)],
    62: [(61, 1), (63, 1)],
    63: [(55, 1), (62, 1), (64, 1), (69, 1)],
    64: [(63, 1), (65, 1)],
    65: [(56, 1), (64, 1), (70, 1)],

    66: [(57, 1), (71, 1)],
    67: [(59, 1), (73, 1)],
    68: [(61, 1), (75, 1)],
    69: [(63, 1), (77, 1)],
    70: [(65, 1), (79, 1)],

    71: [(66, 1), (72, 1)],
    72: [(71, 1), (73, 1)],
    73: [(67, 1), (72, 1), (74, 1)],
    74: [(73, 1), (75, 1)],
    75: [(68, 1), (74, 1), (76, 1)],
    76: [(75, 1), (77, 1)],
    77: [(69, 1), (76, 1), (78, 1)],
    78: [(77, 1), (79, 1)],
    79: [(70, 1), (78, 1)]
}
path = []
def heuristic(num):
    h = {
        1: 1, 2: 1, 3: 1, 4: 1, 5: 1, 6: 1, 7: 1, 8: 1,
        9: 1, 10: 1, 11: 1, 12: 1, 13: 1, 14: 1, 15: 1, 16: 1,
        17: 1, 18: 1, 19: 1, 20: 1, 21: 1, 22: 1, 23: 1, 24: 1,
        25: 1, 26: 1, 27: 1, 28: 1, 29: 1, 30: 1, 31: 1, 32: 1,
        33: 1, 34: 1, 35: 1, 36: 1, 37: 1, 38: 1, 39: 1, 40: 1,
        41: 1, 42: 1, 43: 1, 44: 1, 45: 1, 46: 1, 47: 1, 48: 1,
        49: 1, 50: 1, 51: 1, 52: 1, 53: 1, 54: 1, 55: 1, 56: 1,
        57: 1, 58: 1, 59: 1, 60: 1, 61: 1, 62: 1, 63: 1, 64: 1,
        65: 1, 66: 1, 67: 1, 68: 1, 69: 1, 70: 1, 71: 1, 72: 1,
        73: 1, 74: 1, 75: 1, 76: 1, 77: 1, 78: 1, 79: 1
    }
    return h[num]

def reset(path):
    for stepN in range(len(path) - 1):
        stepFrom = path[stepN]
        stepTo = path[stepN + 1]
        arcs = Arcs[stepFrom]
        for i in range(len(arcs)):
            if arcs[i][0] == stepTo:
                arcs[i] = (arcs[i][0], arcs[i][1] - 1)
                print(arcs[i])
    return path

def reverse(shortest):
    Reverse = shortest[::-1]
    for stepN in range(len(Reverse) - 1):
        stepFrom = Reverse[stepN]
        stepTo = Reverse[stepN + 1]
        arcs = Arcs[stepFrom]
        for i in range(len(arcs)):
            if arcs[i][0] == stepTo:
                arcs[i] = (arcs[i][0], arcs[i][1] + 1)
    Reverse = shortest[::1]
    return Reverse

def increaseCost(shortest):
    for stepN in range(len(shortest) - 1):
        stepFrom = shortest[stepN]
        stepTo = shortest[stepN + 1]
        arcs = Arcs[stepFrom]
        for i in range(len(arcs)):
            if arcs[i][0] == stepTo:
                arcs[i] = (arcs[i][0], arcs[i][1] + 1)
    return shortest

def get_neighbors(neighbor):
    return Arcs[neighbor]

def pathFinding(start_node, destination):
    unvisited_list = {start_node}
    visited_list = set([])
    g_cost = {start_node: 0}
    parents = {start_node: start_node}
    while len(unvisited_list) > 0:
        num = None
        for i in unvisited_list:
            if num is None or g_cost[i] + heuristic(i) < g_cost[num] + heuristic(num):
                num = i
        if num is None:
            return None
        if num is destination:
            reconstruct_path = []
            while parents[num] is not num:
                reconstruct_path.append(num)
                num = parents[num]
            reconstruct_path.append(start_node)
            reconstruct_path.reverse()
            return reconstruct_path
        for (Node, cost) in get_neighbors(num):
            if Node not in unvisited_list and Node not in visited_list:
                unvisited_list.add(Node)
                parents[Node] = num
                g_cost[Node] = g_cost[num] + cost
            else:
                if g_cost[Node] > g_cost[num] + cost:
                    g_cost[Node] = g_cost[num] + cost
                    parents[Node] = num
                    if Node in visited_list:
                        visited_list.remove(Node)
                        unvisited_list.add(Node)
        unvisited_list.remove(num)
        visited_list.add(num)
    return None

def addPath(a_list):
    for i in a_list:
        path.append(i)
    return path

@app.route('/route/<start>/<end>', methods=['GET','POST'])
def algorithm(start, end):
    s = int(start)
    e = int(end)
    route = pathFinding(s, e)
    print("route generated: ",route)
    route = increaseCost(route)
    route = reverse(route)
    for key, item in Arcs.items():
        print(key, item)
    path = addPath(route)
    return jsonify({"path": route})

@app.route('/route', methods=['GET','POST'])
def route_():
    print("Path provided: ", path)
    return jsonify({"path": path})

@app.route('/reset', methods=['GET','POST'])
def reset():
    path.clear()
    return jsonify({"path": path})

@app.route('/done', methods=['GET','POST'])
def done():
    route = reset(path)
    path.clear()
    return jsonify({"path": path})

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=5000, debug=True)