package HW13;

import HW7.MyCollection;

public class MainDemo {
    public static void main(String[] args) {
        MyBinaryTreeComparator intComparator = new MyBinaryTreeComparator();
        MyBinaryTree tree= new MyBinaryTree(intComparator);
        tree.add(1);
        tree.add(8);
        tree.add(11);
        tree.add(99);
        tree.add(15);
        System.out.println(tree.toString());
    }
}
