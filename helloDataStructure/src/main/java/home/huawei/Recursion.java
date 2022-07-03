package home.huawei;


/**
 * @author hylu.ivan
 * @date 2022/6/13 下午11:26
 * @description
 */
public class Recursion {

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;

    }

    /**
     * 汉诺塔
     * @param n
     * @param a
     * @param b
     * @param c
     */
    public void hanoid(int n, char a, char b, char c) {

        if (n <= 0) return;
        hanoid(n-1,a,c,b);
        move(a,c);
        hanoid(n-1,b,a,c);
    }

    public void move(char a,char b) {
        System.out.println(a +" -> " + b);
    }

    /**
     * 细胞分裂
     * @param n
     * @return
     */
    public int allCells(int n) {
        return aCell(n) + bCell(n) + cCell(n);
    }

    /**
     * 第 n 小时 a 状态的细胞数
     */
    public int aCell(int n) {
        if(n==1){
            return 1;
        }else{
            return aCell(n-1)+bCell(n-1)+cCell(n-1);
        }
    }

    /**
     * 第 n 小时 b 状态的细胞数
     */
    public int bCell(int n) {
        if(n==1){
            return 0;
        }else{
            return aCell(n-1);
        }
    }

    /**
     * 第 n 小时 c 状态的细胞数
     */
    public int cCell(int n) {
        if(n==1 || n==2){
            return 0;
        }else{
            return bCell(n-1);
        }
    }

    public static void main(String[] args) {

        Recursion recursion = new Recursion();
        recursion.hanoid(5,'a','b','c');

    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
