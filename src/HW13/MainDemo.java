package HW13;

public class MainDemo {
    public static void main(String[] args) {
        IntComparator intComparator = new IntComparator();
        MyBinaryTree tree= new MyBinaryTree(intComparator);
        System.out.println(tree.toString());
        tree.add(1);
        tree.add(8);
        tree.add(11);
        tree.add(99);
        tree.add(15);
        System.out.println(tree.size());
        System.out.println(tree.toString());
    }
}
