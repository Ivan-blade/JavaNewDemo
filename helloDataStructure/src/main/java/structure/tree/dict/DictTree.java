package structure.tree.dict;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/3/20 下午2:20
 * @description 小写字母字典树
 */
public class DictTree {

    private DictNode root;

    public DictTree() {
        root = new DictNode();
    }

    public DictTree(DictNode root) {
        this.root = root;
    }

    public void add(String word) {
        DictNode cur = root;
        for (char c : word.toCharArray()) {
            DictNode temp = cur.child[c-'a'];
            if (temp == null) {
                temp = new DictNode();
                cur = temp;
            }
        }
    }

    public void getWords(DictNode root, List<String> res) {
        if (root == null) return;
        if (root.word != null) {
            res.add(root.word);
        }
        for (int i = 0; i < 26; i++) {
            getWords(root.child[i],res);
        }
    }

    public boolean search(DictNode root,String word) {
        char[] chars = word.toCharArray();
        DictNode dictNode = root;
        for (int i = 0; i < word.length(); i++) {
            int position = chars[i] - 'a';
            if (dictNode.child[position] == null) {
                return false;
            }
            dictNode = dictNode.child[position];
        }

        return dictNode.isWord;
    }

    public static void main(String[] args) {

        DictTree dictTree = new DictTree();
        dictTree.add("word");
        dictTree.add("world");
        dictTree.add("computer");

        List<String> res = new ArrayList<>();
        DictNode dictNode = new DictNode();
        dictNode.word = "w";

        dictTree.getWords(dictNode,res);

    }
}
