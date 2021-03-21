#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> s;
        for (string& t : tokens) {
            if (t == "+" || t == "-" || t == "*" || t == "/") {
                int a = s.top();
                s.pop();
                int b = s.top();
                s.pop();
                if (t == "+") s.push(b + a);
                if (t == "-") s.push(b - a);
                if (t == "*") s.push(b * a);
                if (t == "/") s.push(b / a);
            } else {
                // s.push(toInt(t));
                s.push(stoi(t));
            }
        }

        int res = s.top();
        s.pop();

        return res;
    }

    int toInt(string s) {
        bool f = false;
        if (s[0] == '-') {
            f = true;
            s.erase(0, 1);
        }
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 10 + (s[i] - '0');
        }

        return f ? -n : n;
    }
};


int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    vector<string> tokens = {"3", "-4", "+"};
    // cout << s->toInt("123") << endl;
    cout << s->evalRPN(tokens) << endl;

    return 0;
}
