#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int m = matrix.size();
        int n = matrix[0].size();
        bool vis[m][n];
        vector<int> res;
        memset(vis, 0, sizeof(vis));

        int dir = 0;
        int x = 0, y = 0;
        for (int i = 1; i <= m * n; i++) {
            res.push_back(matrix[x][y]);
            vis[x][y] = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) {
                dir = (dir + 1) % 4;
            }

            x = x + dx[dir];
            y = y + dy[dir];
        }

        return res;
    }
};


int main(int argc, char const *argv[])
{
    Solution *s = new Solution();
    vector<vector<int>> matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    vector<int> res = s->spiralOrder(matrix);
    
    for (auto &e : res) {
        cout << e << " ";
    }



    return 0;
}
