package HW9;

public class MainDemo {
    public static void main(String[] args) {
        System.out.println();
        int sizeToDemo = 23;
        MyArrayList myNumbers = new MyArrayList();
        for (int i = 0; i < sizeToDemo; i++) {
            int r = (int) (Math.random() * 100);
            myNumbers.add(r);
        }
        myNumbers.add(1);
        myNumbers.add(999);
        System.out.println(myNumbers);
        System.out.println(myNumbers.search(1));
        System.out.println(myNumbers.search(222));
        System.out.println(myNumbers.search(999));
        System.out.println(myNumbers.search(9999));
        System.out.println(myNumbers);
        System.out.println("Thank You!");

//        System.out.println(FibonacciNumber.getBySequenceNumber(1));
//        System.out.println(FibonacciNumber.getBySequenceNumber(2));
//        System.out.println(FibonacciNumber.getBySequenceNumber(3));
//        System.out.println(FibonacciNumber.getBySequenceNumber(4));
//        System.out.println(FibonacciNumber.getBySequenceNumber(5));
//        System.out.println(FibonacciNumber.getBySequenceNumber(55));
//        System.out.println(FibonacciNumber.getBySequenceNumber(555));
    }
}
