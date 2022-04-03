package ClassTest;

import java.util.*;

/**
 * @author hylu.ivan
 * @date 2022/3/20 下午11:23
 * @description
 */
public class QueueTest {

    /**
     * 最小堆
     * @param arr
     */
    public static void minQueue(int[] arr) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i : arr) {
            queue.offer(i);
        }

        // 直接输出是堆数组
        System.out.println(queue);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }

    }

    /**
     * 最大优先队列
     * @param arr
     */
    public static void maxQueue(int[] arr) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr) {
            queue.offer(i);
        }

        System.out.println(queue);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }

    }

    /**
     * 最大优先队列
     * @param
     */
    public List<String> maxQueueSpecial(String[] words, int k) {
        //初始化⼀一个map，⽤用于存放每个单词的出现频率
        Map<String, Integer> countFreq = new HashMap();
        //遍历整个字符串串数组，如果某个单词出现，频率加1
        for (String word: words) {
            countFreq.put(word, countFreq.getOrDefault(word, 0) + 1);
        }
        //初始化⼀一个优先级队列列，排序⽅方式为优先按频率从⾼高到低排序，如果频率相同，则按字⺟母顺序
        PriorityQueue<String> heapSort = new PriorityQueue<String>(
                (word1, word2) -> countFreq.get(word1).equals(countFreq.get(word2)) ?
                word2.compareTo(word1) : countFreq.get(word1) - countFreq.get(word2));
        //对于每⼀一个单词，⼊入队，如果队列列⼤大⼩小超过k，则弹出队⾸首，维持队列列⼤大⼩小为k
        for (String word : countFreq.keySet()) {
            heapSort.offer(word);
            if (heapSort.size() > k) heapSort.poll();
        }
        //最后队列列中存储的k个单词为出现频率最⾼高的单词，逆序输出
        List<String> ans = new ArrayList();
        while (!heapSort.isEmpty()) ans.add(heapSort.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,3};
        QueueTest.maxQueue(arr);
        QueueTest.minQueue(arr);
    }
}
