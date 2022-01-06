package algorithm;

import java.util.*;

/**
 * @author yanjing
 * @date 2022/1/3
 */
public class TestArray {

    public static void main(String[] args) {

        System.out.println("removeDuplicates(new int[]{1, 2, 3, 2})： " + removeDuplicates(new int[]{1, 2, 3, 2}));
        System.out.println("removeDuplicatesAdvance(new int[]{1, 2, 3, 2})： " + removeDuplicatesAdvance(new int[]{1, 2, 3, 2}));
        String[] words = new String[]{"apple", "iOS", "iOSappledog", "dog", "nana", "man", "good", "goodman"};
        System.out.println(longestWord(words));
    }

    /**
     * 找出重复元素
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {

            if (set.contains(num)) {

                return num;
            }
            set.add(num);
        }
        return -1;
    }


    /**
     * 索引和值，一个萝卜一个坑
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesAdvance(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] == i) {

                i++;
                continue;
            }
            // 有重复的
            if (nums[nums[i]] == nums[i]) {

                return nums[i];
            }
            // 交换
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    // ["apple","iOS","dog","nana","man","good","goodman"]
    // "goodman"
    public static String longestWord(String[] words) {

        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

            String curr = words[i];
            TreeMap<Integer, Integer> parts = new TreeMap<>();
            for (int j = 0; j < words.length; j++) {

                String candidate = words[j];
                if (!curr.equals(candidate)) {

                    int idx = curr.indexOf(candidate);
                    if (idx > -1) {

                        parts.put(idx, candidate.length());
                    }
                }
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = parts.entrySet().iterator();
            if (parts.isEmpty()) {

                continue;
            }
            // 前一个的index + length，等于后一个的index，这样能连起来组成一个单词
            int prevPartSum = parts.firstKey();
            Boolean isMatch = true;
            while (iterator.hasNext()) {

                Map.Entry<Integer, Integer> part = iterator.next();
                if (!part.getKey().equals(prevPartSum)) {

                    isMatch = false;
                }
                prevPartSum = part.getKey() + part.getValue();
            }
            if (isMatch) {

                results.add(curr);
            }
        }

        if (results.isEmpty()) {

            return "";
        }

        // 先按长度排序，如果长度相同，按自然排序
        results.sort(new Comparator<String>() {
            @Override
            public int compare(String curr, String next) {

                if (curr.length() - next.length() == 0) {

                    List<String> parts = Arrays.asList(new String[]{curr, next});
                    Collections.sort(parts);
                    if (parts.get(0).equals(curr)) {

                        return -1;
                    }
                    return 1;
                }
                return curr.length() - next.length();
            }
        });
        System.out.println(results);
        return results.get(results.size() - 1);
    }
}
