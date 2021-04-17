from flask import Flask, jsonify
import numpy as np
from json import loads, dumps
app = Flask(__name__)

Coordinates = {
                '1':  [0, 0],'2': [0, 1], '3': [0, 2], '4': [0, 3], '5':  [0, 4], '6': [0, 5], '7':  [0, 6], '8': [0, 7], '9':  [0, 8],
                '10': [1, 0],             '11':[1, 2],              '12': [1, 4],              '13': [1, 6],              '14': [1, 8],
                '15': [2, 0],'16':[2, 1], '17':[2, 2],'18': [2, 3], '19': [2, 4],'20': [2, 5], '21': [2, 6],'22': [2, 7], '23': [2, 8],
                '24': [3, 0],             '25':[3, 2],              '26': [3, 4],              '27': [3, 6],              '28': [3, 8],
                '29': [4, 0],'30':[4, 1], '31':[4, 2],'32': [4, 3], '33': [4, 4],'34': [4, 5], '35': [4, 6],'36': [4, 7], '37': [4, 8],
                '38': [5, 0],             '39':[5, 2],              '40': [5, 4],              '41': [5, 6],              '42': [5, 8],
                '43': [6, 0],'44':[6, 1], '45':[6, 2],'46': [6, 3], '47': [6, 4],'48': [6, 5], '49': [6, 6],'50': [6, 7], '51': [6, 8],
                '52': [7, 0],             '53':[7, 2],              '54': [7, 4],              '55': [7, 6],              '56': [7, 8],
                '57': [8, 0],'58':[8, 1], '59':[8, 2],'60': [8, 3], '61': [8, 4],'62': [8, 5], '63': [8, 6],'64': [8, 7], '65': [8, 8],
                '66': [9, 0],             '67':[9, 2],              '68': [9, 4],              '69': [9, 6],              '70': [9, 8],
                '71': [10, 0],'72':[10, 1],'73':[10, 2],'74':[10, 3],'75':[10, 4],'76':[10, 5],'77': [10, 6],'78':[10, 7],'79': [10, 8]
              }
path = []

@app.route('/route/<s>/<e>', methods=['GET', 'POST'])
def route(s,e):
    restuarant = [[0, 0, 0, 0, 0, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1, 0, 1, 0],
                  [0, 0, 0, 0, 0, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1, 0, 1, 0],
                  [0, 0, 0, 0, 0, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1, 0, 1, 0],
                  [0, 0, 0, 0, 0, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1, 0, 1, 0],
                  [0, 0, 0, 0, 0, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1, 0, 1, 0],
                  [0, 0, 0, 0, 0, 0, 0, 0, 0]]
    cost = 1
    start = read(s)
    end = read(e)
    route = _AStarSearch(restuarant, cost, start, end)
    print('\n'.join([''.join(["{:" ">3d}".format(item) for item in row]) for row in route]), '\n')
    return jsonify({"path": path})

@app.route('/route', methods=['GET','POST'])
def route_():
    return jsonify({"path": path})

@app.route('/reset', methods=['GET','POST'])
def reset():
    path.clear()
    return jsonify({"path": path})

class Node:
    def __init__(self, parent, position):
        self.parent = parent
        self.position = position
        self.gCost = 0
        self.hCost = 0
        self.fCost = 0

    def __eq__(self, other):
        return self.position == other.position

def read(s):
    for i in Coordinates.keys():
        if s == i:
            return Coordinates[i]

def _AStarSearch(restuarant, cost, start, end):
    start_node = Node(None, tuple(start))
    end_node = Node(None, tuple(end))
    start_node.gCost = start_node.hCost = start_node.fCost = 0
    end_node.gCost = end_node.hCost = end_node.fCost = 0
    unvisited_list = []
    visited_list = []
    unvisited_list.append(start_node)
    iterations = 0
    max_iterations = (len(restuarant) // 2) ** 10
    move = [[-1, 0],
            [0, -1],
            [1, 0],
            [0, 1]]
    rows, cols = np.shape(restuarant)
    while len(unvisited_list) > 0:
        iterations += 1
        current_node = unvisited_list[0]
        current_index = 0
        for index, item in enumerate(unvisited_list):
            if item.fCost < current_node.fCost:
                current_node = item
                current_index = index
        if iterations > max_iterations:
            return route_calculated(current_node, restuarant)
        unvisited_list.pop(current_index)
        visited_list.append(current_node)
        pathFinding(current_node.position)
        if current_node == end_node:
            return route_calculated(current_node, restuarant)
        adjacent_nodes = []
        for position in move:
            node_position = (current_node.position[0] + position[0], current_node.position[1] + position[1])
            if (node_position[0] > (rows - 1) or node_position[0] < 0 or node_position[1] > (cols - 1) or node_position[
                1] < 0):
                continue
            if restuarant[node_position[0]][node_position[1]] != 0:
                continue
            new_node = Node(current_node, node_position)
            adjacent_nodes.append(new_node)
        for adj in adjacent_nodes:
            if len([visited_adj for visited_adj in visited_list if visited_adj == adj]) > 0:
                continue
            adj.gCost = current_node.gCost + cost
            adj.hCost = (((adj.position[0] - end_node.position[0]) ** 2) + (
                    (adj.position[1] - end_node.position[1]) ** 2))
            adj.fCost = adj.gCost + adj.hCost
            if len([i for i in unvisited_list if adj == i and adj.gCost > i.gCost]) > 0:
                continue
            unvisited_list.append(adj)

def route_calculated(current_node, restuarant):
    route = []
    rows, cols = np.shape(restuarant)
    result = [[-1 for i in range(cols)] for j in range(rows)]
    current = current_node
    while current is not None:
        route.append(current.position)
        current = current.parent
    route = route[::-1]
    count = 0
    for i in range(len(route)):
        result[route[i][0]][route[i][1]] = count
        count += 1
    return result

def pathFinding(node):
    n = nodeID(node)
    return path.append(n)

def nodeID(n):
    node = list(n)
    for key, item in Coordinates.items():
        if node == item:
            return key

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)