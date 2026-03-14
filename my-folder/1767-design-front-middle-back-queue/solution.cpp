using namespace std;
class FrontMiddleBackQueue {
public:
    deque<int> front;
    deque<int> back;

    FrontMiddleBackQueue() {}

    void rebalance() {
        while (front.size() > back.size() + 1) {
            back.push_front(front.back());
            front.pop_back();
        }

        while (front.size() < back.size()) {
            front.push_back(back.front());
            back.pop_front();
        }
    }

    void pushFront(int val) {
        front.push_front(val);
        rebalance();
    }

    void pushMiddle(int val) {
        if (front.size() > back.size()) {
            back.push_front(front.back());
            front.pop_back();
        }
        front.push_back(val);
    }

    void pushBack(int val) {
        back.push_back(val);
        rebalance();
    }

    int popFront() {
        if (front.empty() && back.empty())
            return -1;

        if (front.empty()) {
            front.push_back(back.front());
            back.pop_front();
        }
        int v = front.front();
        front.pop_front();
        rebalance();
        return v;
    }

    int popMiddle() {
        if (front.empty() && back.empty())
            return -1;
        int v = front.back();
        front.pop_back();
        rebalance();
        return v;
    }

    int popBack() {
        if (back.empty() && front.empty())
            return -1;

        int v;
        if (back.empty()) {
            v = front.back();
            front.pop_back();
        } else {
            v = back.back();
            back.pop_back();
        }

        rebalance();
        return v;
    }
};

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue* obj = new FrontMiddleBackQueue();
 * obj->pushFront(val);
 * obj->pushMiddle(val);
 * obj->pushBack(val);
 * int param_4 = obj->popFront();
 * int param_5 = obj->popMiddle();
 * int param_6 = obj->popBack();
 */
