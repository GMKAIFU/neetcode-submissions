
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // STEP 1: Count each number
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        // STEP 2: Create boxes
        List<Integer>[] bucket = new List[nums.length + 1];

        // Put each number into its frequency box
        for (int n : hm.keySet()) {

            int frequency = hm.get(n);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(n);
        }

        // STEP 3: Take k numbers
        int[] result = new int[k];
        int index = 0;

        // Start from highest frequency
        for (int frequency = bucket.length - 1;
             frequency >= 0;
             frequency--) {

            if (bucket[frequency] != null) {

                for (int n : bucket[frequency]) {

                    result[index] = n;
                    index++;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}