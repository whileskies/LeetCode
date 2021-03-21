#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int>(n, 0));
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0}; 
        int d = 0;
        int x = 0, y = 0;

        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || res[nx][ny] != 0) {
                d = (d + 1) % 4;
            }

            x = x + dx[d];
            y = y + dy[d];
        }

        return res;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    vector<vector<int>> res = s->generateMatrix(3);
    for (auto& r : res) {
        for (auto& c : r) {
            cout << c << " ";
        }
        cout << endl;
    }
    return 0;
}
