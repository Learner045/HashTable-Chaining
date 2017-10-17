package Chaining;

public class HashTable {

    private HashItem[] hashTable;  //defining an array which will store hashitems

    public HashTable(){
        hashTable=new HashItem[Constants.TABLE_SIZE];
    }
    private int hash(int key){
        return key%Constants.TABLE_SIZE;

    }

    public void put(int key,int value){

        int index=hash(key);

        if(hashTable[index]==null){
            //the index is not holding any data
            System.out.println("No collistion situation- simple insertion");
            hashTable[index]=new HashItem(key,value);
        }else{
            //we need to attach new item to end of last item on that index
            HashItem hashItem=hashTable[index];

            System.out.println("Collsiion situation...looking in list");
            if(hashItem.getKey()==key)
            {
                //key already present so just update the value
                System.out.println("updating value of key "+key+" already present");
                hashItem.setValue(value);return;
            }
            while(hashItem.getNextHashItem()!=null){
                if(hashItem.getKey()==key){
                    //key already present so just update the value
                    System.out.println("updating value of key "+key+" already present");
                    hashItem.setValue(value);return;
                }
                hashItem=hashItem.getNextHashItem();
            }
            hashItem.setNextHashItem(new HashItem(key,value));
        }
    }


    public int getValue(int key){

        int index=hash(key);

        HashItem hashItem=hashTable[index];
        if(hashItem==null){
            return -1; //no data present at that index
        }else{
            //search through the list
            while(hashItem!=null && hashItem.getKey()!=key){
                hashItem=hashItem.getNextHashItem();
            }

            if(hashItem==null){
                return -1; //end of the list and key not found
            }else{
                return hashItem.getValue();
            }
        }
    }

}
