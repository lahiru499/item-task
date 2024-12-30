package db;

import modle.Items;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class dbCollection {
    private static dbCollection instance;

    private List<Items> itemsList;
    private  dbCollection(){
        itemsList=new ArrayList<>();
    }
    public List<Items>getCinnection(){
        return  itemsList;
    }
    public static  dbCollection getInstance(){
        return  instance== null ? instance=new dbCollection() :instance;
    }
}
