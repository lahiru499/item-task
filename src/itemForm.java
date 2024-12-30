import com.sun.org.apache.xpath.internal.objects.XObject;
import db.dbCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modle.Items;

import javax.print.attribute.standard.MediaSizeName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

public class itemForm{


    public TextField txt_itemName;
    public TextField item_price;
    public TextField item_qty;
    public TableView tabale_veiw;
    public TableColumn colum_name;
    public TableColumn colum_itemPrice;
    public TableColumn colum_qty;
    public TableColumn colum_discription;
    public TableColumn cloum_id;
    public TextField txt_description;
    public TextField txt_id;

    ArrayList<Items> itemsArrayList=new ArrayList<Items>();


    public void btn_iAddItem_Action(ActionEvent actionEvent) {
       String name= txt_itemName.getText();
        double price = Double.parseDouble(item_price.getText());
       String qty = item_qty.getText();
      String Description= txt_description.getText();
      String id=txt_id.getText();


        System.out.println(new Items(name,qty,price,Description,id));

            itemsArrayList.add(new Items(name,qty,price,Description,id));
        System.out.println(itemsArrayList);

        dbCollection.getInstance().getCinnection().add(new Items(name,qty,price,Description,id));


    }
    ObservableList<Items> itemsObservableList= FXCollections.observableArrayList();

    public void btn_Reloditem_Action(ActionEvent actionEvent) {


        colum_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        colum_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colum_itemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colum_discription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        cloum_id.setCellValueFactory(new PropertyValueFactory<>("id"));





itemsArrayList.forEach(obj->{
    itemsObservableList.add(obj);
        }
        );

        tabale_veiw.setItems(itemsObservableList);

    }

    public void btn_VeiwCustomerAction(ActionEvent actionEvent)throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/item.fxml"))));
        stage.show();
    }
}
