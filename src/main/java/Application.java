import util.MyArrayList;
import util.MyLinkedList;
import util.MyList;

public class Application {
    public static void main(String[] args) {
        MyList<Integer> linkedList = new MyArrayList<>();

        linkedList.add(10);
        linkedList.add(1);
        linkedList.add(15);
        linkedList.add(12);
        linkedList.add(18);
        linkedList.add(129);
        linkedList.add(32);
        linkedList.add(152);

        System.out.println("MyLinkedList");
        System.out.print("До сортировки: ");

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();

        linkedList.sort(Integer::compareTo);

        System.out.print("После сортировки: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        System.out.println("Размер до удаления: " + linkedList.size());

        linkedList.remove(4);

        System.out.println("Размер после удаления: " + linkedList.size());

        System.out.println();
        System.out.println("MyArrayList");

        MyList<Integer> arrayList = new MyArrayList<>();

        arrayList.add(10);
        arrayList.add(1);
        arrayList.add(15);
        arrayList.add(12);
        arrayList.add(18);
        arrayList.add(129);
        arrayList.add(32);
        arrayList.add(152);

        System.out.print("До сортировки: ");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        arrayList.sort(Integer::compareTo);

        System.out.print("После сортировки: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        System.out.println("Размер до удаления: " + arrayList.size());

        arrayList.remove(4);

        System.out.println("Размер после удаления: " + arrayList.size());
    }
}
