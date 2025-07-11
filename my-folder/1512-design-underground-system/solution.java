class UndergroundSystem {
    Map<Edge, Data> log;
    Map<Integer, Trip> trips;
    
    public UndergroundSystem() {
        log = new HashMap<>(); // Map Trips to Timeing
        trips = new HashMap<>(); // Map customer to current trip
    }
    
    public void checkIn(int id, String stationName, int t) {
        trips.put(id, new Trip(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Trip trip = trips.remove(id);
        
        Edge edge = new Edge(trip.start, stationName);
        Data data = log.getOrDefault(edge, new Data());
        
        data.sum += (t - trip.time);
        data.count++;

        log.put(edge, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Edge edge = new Edge(startStation, endStation);
        Data data = log.get(edge);
        
        return (double) data.sum / data.count;
    }

    private class Edge{
        String u;
        String v;
        public Edge(String u, String v){
            this.u = u;
            this.v = v;
        }

        @Override
        public int hashCode(){
            return Objects.hash(u, v);
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if (!(o instanceof Edge)) return false;
            
            Edge that = (Edge) o;
            
            return u.equals(that.u) && v.equals(that.v);
        }
    }

    private class Data{
        int sum = 0;
        int count = 0;
        
        public Data(){

        }
    }
    
    private class Trip{
        String start;
        int time;
        public Trip(String s, int t){
            start = s;
            time = t;
        }
    }
    
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
