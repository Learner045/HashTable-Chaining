package Chaining;

public class ChainTest {

    public static void main(String args[]){

        HashTable table=new HashTable();

        table.put(1,10);
        table.put(2,15);
        table.put(5,60);

        System.out.println(table.getValue(1));
        System.out.println(table.getValue(5));
        System.out.println(table.getValue(2));

        table.put(1,80);
        System.out.println(table.getValue(1));

        table.put(2,30);
        System.out.println(table.getValue(2));

        table.put(12,90);
        System.out.println(table.getValue(12));

        System.out.println(table.getValue(130));

    }
}
