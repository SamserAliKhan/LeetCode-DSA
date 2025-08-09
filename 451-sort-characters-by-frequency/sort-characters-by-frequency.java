class Solution {
    public String frequencySort(String s) {
       HashMap <Character,Integer> map  = new HashMap <>();

       List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            buckets[i] = new ArrayList<>();
        }

       for(int i=0; i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch))map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
       }
       for(Map.Entry<Character,Integer> entry : map.entrySet()){
        int freq = entry.getValue();
        char ch = entry.getKey();
        buckets[freq].add(ch);
       }
        StringBuilder ns = new StringBuilder();
        for (int i = buckets.length - 1; i >= 1; i--) {  // skip bucket[0]
            for (char ch : buckets[i]) {
                for (int count = 0; count < i; count++) {
                    ns.append(ch);
                }
            }
        }
        return ns.toString();
    }
}