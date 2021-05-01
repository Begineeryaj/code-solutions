// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
        if(n <= 0)
            return 0;
        
        int ans = 0;
        for(int i = 1; i<n; i++){
			ans += Math.max(prices[i]-prices[i-1], 0);
		}
        return ans;
	}
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0)
            return 0;
        
        int ans = 0;
        int stock = 0;
        
        int temp = 0;
        for(int i = 0; i<n-1; i++){
            if(stock == 0 && prices[i]<prices[i+1]){
                stock++;
                temp = prices[i];
            } else if(stock > 0 && prices[i]>prices[i+1]){
                stock--;
                ans += (prices[i]-temp);
            }
        }
		
		// if we have a stock, and last element is greater
        if(stock == 1 && prices[n-1]>temp)
            ans += (prices[n-1]-temp);
        return ans;        
    }
}