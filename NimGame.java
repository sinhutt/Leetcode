public class Solution {
    public boolean canWinNim(int n) {
    	/* If there are 4 stones, then you will never win the game:
    	 * no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
    	 * If there are 5, 6, or 7 stones, then you will always win the game:
    	 * you remove 1, 2, or 3 stones respectively, thereby converting to the case of 4 stones for your opponent.
    	 * now the opponent will never win. etc.
    	 */
        if (n % 4 == 0) return false;
        else return true;
    }
}