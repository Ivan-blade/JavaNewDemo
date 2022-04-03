package structure.tree.dict;

/**
 * @author hylu.ivan
 * @date 2022/3/20 下午2:27
 * @description
 */
public class DictNode {

    private static int SIZE = 26;  // 每个节点的子节点最大容量，小写字母26个所以这边26个
    DictNode[] child;   // 子节点数据
    String word;
    boolean isWord;     // 是否单词词尾

    public DictNode() {
        isWord = false;
        word = null;
        child = new DictNode[SIZE];
    }

}
