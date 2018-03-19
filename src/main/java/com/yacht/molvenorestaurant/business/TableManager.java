package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Table;
import java.util.ArrayList;
import java.util.List;

public class TableManager {

    private List<Table> tableList;

    public List<Table> getTableList(){
        return tableList;
    }

    public void addTable(Table table){
        tableList.add(table);
    }

    public void removeTable(Table table){
        tableList.remove(table);
    }

    public void updateTable(Table table, int id){
        for (Table oldTable : tableList) {
            if (oldTable.getTableID() == id) {
                tableList.add(tableList.indexOf(oldTable), table);
            }
        }
    }

    public List<Table> getAvailableTables(){
        List<Table> freeTables = new ArrayList<Table>();
        for(Table table: tableList){
            if(table.isOccupied() == false){
                freeTables.add(table);
            }
        }
        return freeTables;
    }


}
