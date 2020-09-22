package HW5;

public class Main {
    public static void main(String[] args) {
        //создаем рабочий контейнер
        ContainerInts ints = new ContainerInts();
        int temp = 8;
        System.out.println();

        //проверяем работу метода add
        ints.add(temp + 3);
        ints.add(temp - 15);
        ints.add(++temp);
        ints.printArrayInLane();
        System.out.println();

        //проверяем работу метода getByIndex
        temp = 2;
        System.out.println("getByIndex " + temp +": "+ ints.getByIndex(temp));
        System.out.println("getByIndex " + (temp - 100)+": "+ ints.getByIndex(temp-100));

        //проверяем работу метода contains
        temp = 1111;
        System.out.println("contains " + temp + ": "+ ints.contains(temp));
        temp = ints.getByIndex(1);
        System.out.println("contains " + temp + ": "+ ints.contains(temp));

        //проверяем работу метода addAll
        System.out.print("After addAll array is : ");
        ints.addAll(new int[]{temp * 5, temp - 18, temp * 65 / 12, 74 - temp});
        ints.printArrayInLane();

        //проверяем работу метода clear
        System.out.print("clear: ");
        ints.clear();
        ints.printArrayInLane();

        //проверяем работу методов после clear
        System.out.println("test after clear");
        System.out.println("getByIndex 1: " + ints.getByIndex(1));
        System.out.println("contains 11: " + ints.contains(11));
        System.out.println("add twice " + temp);
        ints.add(temp);
        ints.add(temp);
        ints.printArrayInLane();

        //проверяем работу метода addAll
        ContainerInts addInts = new ContainerInts();
        addInts.addAll(new int[]{1, 22, 4, 2, 6, 78, 22});
        System.out.print("add all this elements: ");
        addInts.printArrayInLane();
        ints.addAll(addInts.getArray());
        ints.printArrayInLane();
        System.out.println();

        //проверяем работу метода getFirstIndexOf
        System.out.println("FirstIndexOf " + (temp) + " is: " + ints.getFirstIndexOf(temp));
        ints.printArrayInLane();
        System.out.println();
        ints.add(++temp);
        System.out.println("FirstIndexOf " + (temp) + " is: " + ints.getFirstIndexOf(temp));
        ints.printArrayInLane();
        System.out.println();

        //проверяем работу метода getAllIndexesOf
        temp /= 7;
        ints.add(temp);
        ints.add(temp);
        ints.printArrayInLane();
        ContainerInts indexes = new ContainerInts();
        indexes.addAll(ints.getAllIndexesOf(temp));
        System.out.println("AllIndexesOf " + (temp) + " is: ");
        indexes.printArrayInLane();
        System.out.println();

        //проверяем работу метода getSize
        System.out.println("Now array size is: " + ints.getSize());
        System.out.println();

        //проверяем работу метода sort
        System.out.println("before and after sorting: ");
        ints.printArrayInLane();
        ints.sort();
        ints.printArrayInLane();
        System.out.println();

        //проверяем работу методов isEqualsByLink / isEqualsByContent
        System.out.println(ints.isEqualsByLink(ints.getArray()));
        System.out.println(ints.isEqualsByLink(addInts.getArray()));
        System.out.println(ints.isEqualsByContent(ints.getArray()));
        System.out.println(ints.isEqualsByContent(addInts.getArray()));
        ints.printArrayInLane();
        System.out.println();
    }
}
