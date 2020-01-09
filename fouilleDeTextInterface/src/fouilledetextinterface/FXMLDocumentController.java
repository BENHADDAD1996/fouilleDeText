/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fouilledetextinterface;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Shuriken
 */
public class FXMLDocumentController implements Initializable {
    private String path;
    private Label label;
    @FXML
    private Button importBtn;
    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;
    @FXML
    private Button displayBtn;
    @FXML
    private Button sortBtn1;
    @FXML
    private Button sortBtn2;
    @FXML
    private Button sortBtn3;
    
    @FXML
    private TableColumn<?, ?> retweetUser;

    @FXML
    private TableColumn<?, ?> tweetUser;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> cont;

    @FXML
    private TableColumn<?, ?> tweetDate;

    
    static BaseOfTweets x = new BaseOfTweets();
    private static List<TweetClass> liste;	
    private static BaseOfTweets base;
	
    public static List<TweetClass> initialiser() {
		base = new BaseOfTweets();
		return liste = new ArrayList<TweetClass>();
	}
    @FXML
    private TableView<?> myTable;
    @FXML
    private TableColumn<?, ?> retweet;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn id = new TableColumn();
        TableColumn tweetUser = new TableColumn();
        TableColumn tweetDate = new TableColumn();
        TableColumn cont = new TableColumn();
        TableColumn retweet = new TableColumn();
        TableColumn retweetUser = new TableColumn();
        myTable.getColumns().addAll(id, tweetUser, tweetDate, cont, retweet, retweetUser);
        
        final ObservableList<TweetClass> data = FXCollections.observableArrayList(liste);

    id.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("id"));
    tweetUser.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("tweetUser"));
    tweetDate.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("tweetDate"));
    cont.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("cont"));
    retweet.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("retweet"));
    retweetUser.setCellValueFactory(new PropertyValueFactory<TweetClass,String>("retweetUser"));
    
    
    }    

    @FXML
    private void ActionImport(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("CSV Files","*.csv"));
        List<File> f = fc.showOpenMultipleDialog(null);
        for(File file : f)
        {
            if(f != null) 
            {
                path = file.getAbsolutePath();
                textfield1.setText(path);
            }
           
    
        }
    }


    @FXML
    private void ActionDisplay(ActionEvent event) {
        
    }

    @FXML
    private void ActionSortDate(ActionEvent event) {
    }

    @FXML
    private void ActionSortUser(ActionEvent event) {
    }

    @FXML
    private void ActionNumberRe(ActionEvent event) {
    }
    
    
}
