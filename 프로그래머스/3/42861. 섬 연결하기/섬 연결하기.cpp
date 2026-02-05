#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class UnionFind {
public:
    UnionFind(int size) {
        parent.resize(size);
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
        }
    }

    int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); 
        }
        return parent[u];
    }

    void unite(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootV] = rootU;  
        }
    }

    bool connected(int u, int v) {
        return find(u) == find(v);
    }

    vector<int> parent;
};

bool cmp(vector<int> &v1, vector<int> &v2) {
    return v1[2] < v2[2];  
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    UnionFind uf(n);
    int cnt = 0;  

    sort(costs.begin(), costs.end(), cmp);

    for (const auto& cost : costs) {
        if (!uf.connected(cost[0], cost[1])) {
            uf.unite(cost[0], cost[1]);
            answer += cost[2];  
            cnt++;  

            if (cnt == n - 1) {  
                break;
            }
        }
    }

    return answer;
}
