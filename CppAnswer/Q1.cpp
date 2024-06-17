#include <iostream>
#include <vector>
#include <list>
#include <utility>

class HashMap {
private:
    std::vector<std::list<std::pair<int, int>>> map;
    int size;
    int hash(int key) {
        return key % size;
    }
    
public:
    HashMap(int s = 100) : size(s) {
        map.resize(size);
    }
    
    void put(int key, int value) {
        int hashValue = hash(key);
        for (auto& pair : map[hashValue]) {
            if (pair.first == key) {
                pair.second = value;
                return;
            }
        }
        map[hashValue].emplace_back(key, value);
    }
    
    int get(int key) {
        int hashValue = hash(key);
        for (const auto& pair : map[hashValue]) {
            if (pair.first == key) {
                return pair.second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int hashValue = hash(key);
        map[hashValue].remove_if([key](const std::pair<int, int>& pair) {
            return pair.first == key;
        });
    }
};

int main() {
    HashMap hashMap;
    hashMap.put(1, 10);
    hashMap.put(2, 20);
    std::cout << hashMap.get(1) << std::endl;  // Output: 10
    std::cout << hashMap.get(3) << std::endl;  // Output: -1
    hashMap.put(2, 30);
    std::cout << hashMap.get(2) << std::endl;  // Output: 30
    hashMap.remove(2);
    std::cout << hashMap.get(2) << std::endl;  // Output: -1
    return 0;
}
