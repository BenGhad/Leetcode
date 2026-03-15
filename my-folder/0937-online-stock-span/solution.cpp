/*
100 80 60 70 60 75 85

100

100 80 

100 80 60

100 80 70
        2

100 80 70 60
        2

100 80 75
        4
100 85
    6
*/
class StockSpanner {
public:
    stack<pair<int, int>> stacky;
    StockSpanner() {
        
    }
    
    int next(int price) {
        if(stacky.empty()){
            stacky.push(make_pair(price, 1));
            return 1;
        }

        int ans = 1;
        while(!stacky.empty()){
            auto [pr, am] = stacky.top(); 
            
            // too much
            if(pr > price){
                break;
            } else {
                stacky.pop();
                ans += am;
            }
        }
        stacky.push(make_pair(price, ans));
        return ans;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
