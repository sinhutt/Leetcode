public class TwoSum {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number))
	        map.put(number, 1);
	    else {
	        if (map.get(number) == 1)
	            map.put(number, 2);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if (map.size() <= 1 && !map.contains(2))
	        return false;
	    Iterator iter = map.keySet().iterator();
	    while (iter.hasNext()) {
	        int curr = iter.next();
	        if (!map.containsKey(value - curr))
	            continue;
	        else {
	            if (value - curr == curr) {
	                if (map.get(curr) != 2) continue;
	            }
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);