#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ParkingSystem {
private:
    int big = 0;
    int medium = 0;
    int small = 0;
public:
    ParkingSystem(int big, int medium, int small) {
        this->big = big;
        this->medium = medium;
        this->small = small;
    }
    
    bool addCar(int carType) {
        switch (carType)
        {
        case 1:
            if (big >= 1) {
                big--;
                return true;
            }
            return false;
        
        case 2:
            if (medium >= 1) {
                medium--;
                return true;
            }
            return false;
        
        case 3:
            if (small >= 1) {
                small--;
                return true;
            }
            return false;
        default:
            return false;
        }
    }
};

int main(int argc, char const *argv[])
{
    ParkingSystem parkingSystem(1, 1, 0);
    cout << parkingSystem.addCar(1) << endl;// 返回 true ，因为有 1 个空的大车位
    cout << parkingSystem.addCar(2) << endl;// 返回 true ，因为有 1 个空的中车位
    cout << parkingSystem.addCar(3) << endl;// 返回 false ，因为没有空的小车位
    cout << parkingSystem.addCar(1) << endl;// 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了

    return 0;
}

