class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int len = nums1.length;
        
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i < len; i++){
            lst.add(nums1[i]-nums2[i]);
        }
        Collections.sort(lst);
        
        long ans = 0;
        for(int i = 0; i < len-1; i++){
            int gap = nums1[i]-nums2[i];
            int sz = lst.size();
            int indOri = binaryExact(lst, gap, 0, sz-1);
            
            int indInc = binaryInc(lst, gap-diff, 0, sz-1);
            lst.remove(indOri);
            ans += (sz-indInc);
            if(gap-diff <= gap) ans--;
        }
        
        return ans;
    }
    
    public int binaryExact(ArrayList<Integer> lst, int tar, int st, int ed){
        while(st<=ed){
            int mid = st+(ed-st)/2;
            if(lst.get(mid) == tar) return mid;
            else if(lst.get(mid) < tar) st = mid+1;
            else ed = mid-1;
        }
        
        return -1;
    }
    
    public int binaryInc(ArrayList<Integer> lst, int tar, int st, int ed){
        while(st<=ed){
            int mid = st+(ed-st)/2;
            if(lst.get(mid) < tar) st = mid+1;
            else ed = mid-1;
        }
        
        return st;
    }
}