package de.schmidtdennis.challenges.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class Pair{
        String value;
        int timestamp;
        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    // hashmap can only store unique values

    public void set(String key, String value, int timestamp) {
        List<Pair> list = this.map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        this.map.put(key, list);
    }

    public String get(String key, int timestamp) {

        List<Pair> list = this.map.get(key);

        if(list == null){
            return "";
        }

        int i = 0;
        int j = list.size() -1;

        while(i < j){
            int mid = (i-j)/2+i;

            int tmpTimestamp = list.get(mid).timestamp;
            String tmpValue = list.get(mid).value;

            if(tmpTimestamp == timestamp) return tmpValue;
            if(mid < list.size()-1 && list.get(mid+1).timestamp > timestamp) return tmpValue;

            if(tmpTimestamp > timestamp){
                // go left
                j = mid-1;
            } else {
                i = mid+1;
            }
        }

        return list.get(i).value;
    }

}
