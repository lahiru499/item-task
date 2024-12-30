package view;

import db.dbCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modle.Items;

import java.util.ArrayList;

public class VeiwCustomerForm {


    public TableView tabel_Veiw;
    public TableColumn colum_itemname;
    public TableColumn colum_itemName;
    public TableColumn item_price;
    public Button btn_Relod;
    public TableColumn colum_qty;
    public TableColumn item_id;
    public TableColumn item_Description;
    ArrayList<Items> ItemList = new ArrayList<>();

    public void btn_Relode_Action(ActionEvent actionEvent) {
       ObservableList<Items> itemsObservableList= FXCollections.observableArrayList();


        colum_itemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colum_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        item_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        item_id.setCellValueFactory(new PropertyValueFactory<>("id"));




        dbCollection.getInstance().getCinnection().forEach(obj-> {
            itemsObservableList.add(obj);
        } );

        tabel_Veiw.setItems(itemsObservableList);



        item_Description.setCellFactory(param -> new TableCell<Items, Void>() {
            private final Button btn = new Button("Remove");

            {
                btn.setStyle("-fx-background-color: rgb(250, 3, 67);");

                btn.setOnAction(event -> {
                    Items item = getTableView().getItems().get(getIndex());
                    getTableView().getItems().remove(item);
                    dbCollection.getInstance().getCinnection().remove(item);
                });
            }

            @Override
            protected void updateItem(Void unused, boolean empty) {
                super.updateItem(unused, empty);
                setGraphic(empty ? null : btn);
            }
        });










    }


}

