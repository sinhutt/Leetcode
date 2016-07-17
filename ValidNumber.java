public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0 ) return false;
	    int start = 0;
	    int end  = s.length() - 1;
	
	    // 1st step : remove spaces
	    while (start < s.length()-1 &&  s.charAt(start) == ' ')
		    start ++;
	    while (end >= start +1 &&  s.charAt(end) == ' ')
		    end --;
	
	    // 2nd step : check when the string has only one char
	    if ((start - end == 0) &&  (s.charAt(start) < '0' || s.charAt(start) > '9'))
		    return false;   
	
	    // 3rd step : check for '+' and '-' when they are at the beginning of the string
	    if (s.charAt(start) == '+' || s.charAt(start) == '-') {
		    if (s.charAt(start + 1) == '.' && (end - start == 1))
			    return false;
		    start++;
	    }
	
	    int point = -1;   // position of '.' in the string
	    int e = -1;       // position of 'e' in the string
	
	    // 4th step : check for all the remaining cases
	    for (int i = start; i <= end; i++) {
		    if (s.charAt(i) == '.') {
			    if (point == -1)  // if we met the point for the FIRST time, we store its position
				    point = i;   // a string that has TWO point can't be a valid number
			    else return false;
		    }
		    if (s.charAt(i) == 'e')  {
			    if (e == -1)     // same raisoning for e
				    e = i;
			    else return false;
		    }
		    if (e == start || e == end) return false; // e has to be at the middle
		    if (point > e && e != -1 ) return false; // the part AFTER e must be only integer
		    if (point == start && e == start +1) return false; //the part BEFORE e must be a valid number
		
		    // if we met a non numerical digit
		    if ((s.charAt(i) < '0' || s.charAt(i) > '9')  && s.charAt(i) !='.' && s.charAt(i) != 'e' ) {

		        // we met + or - at the middle but in a correct configuration. So, we continue
			    if ((s.charAt(i) == '+' || s.charAt(i) == '-')  && e == i-1 && i != end ) continue;
			    else return false;
		    }
	    }
	    return true;
    }
}