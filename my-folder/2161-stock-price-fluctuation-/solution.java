class StockPrice {
    Map<Integer, Integer> prices;
    int last;
    TreeMap<Integer, Integer> count;

    public StockPrice() {
        prices = new HashMap<>();
        count = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (prices.containsKey(timestamp)) {
            int prevPrice = prices.get(timestamp);
            count.put(prevPrice, count.get(prevPrice) - 1);
            if (count.get(prevPrice) == 0)
                count.remove(prevPrice);
        }

        prices.put(timestamp, price);

        last = Math.max(last, timestamp);
        count.put(price, count.getOrDefault(price, 0) + 1);

    }

    public int current() {
        return prices.get(last);
    }

    public int maximum() {
        return count.lastKey();
    }

    public int minimum() {
        return count.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
