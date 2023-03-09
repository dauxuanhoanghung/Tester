package com.dxhh.englishapp;

import com.dxhh.pojo.Category;
import com.dxhh.pojo.Choice;
import com.dxhh.pojo.Question;
import com.dxhh.services.CategoryService;
import com.dxhh.services.QuestionService;
import com.dxhh.utils.MessageBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    @FXML
    private ComboBox<Category> cbCategories;
    @FXML
    private TextField tfQuestion;
    @FXML
    private RadioButton rdA;
    @FXML
    private RadioButton rdB;
    @FXML
    private RadioButton rdC;
    @FXML
    private RadioButton rdD;
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtB;
    @FXML
    private TextField txtC;
    @FXML
    private TextField txtD;
    @FXML
    private TableView tbvQuestion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.loadTableView();
        CategoryService cs = new CategoryService();
        List<Category> categories;
        try {
            categories = cs.getCategories();
            this.cbCategories.setItems(FXCollections.observableArrayList(categories));
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addQuestionHandler(ActionEvent event) {
        Question q = new Question(this.tfQuestion.getText(),
                this.cbCategories.getSelectionModel().getSelectedItem().getId());
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice(this.txtA.getText(), this.rdA.isSelected(), q.getId()));
        choices.add(new Choice(this.txtB.getText(), this.rdB.isSelected(), q.getId()));
        choices.add(new Choice(this.txtC.getText(), this.rdC.isSelected(), q.getId()));
        choices.add(new Choice(this.txtD.getText(), this.rdD.isSelected(), q.getId()));

        QuestionService s = new QuestionService();
        try {
            s.insertQuestion(q, choices);
            MessageBox.AlertBox("Add question", "Add successful", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            MessageBox.AlertBox("Add question", "Add failed", Alert.AlertType.ERROR).show();
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadTableView() {
        TableColumn<Question, String> questionColumn = new TableColumn<>("Question");
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        questionColumn.setPrefWidth(120);
        
        TableColumn<Choice, String> aColumn = new TableColumn<>("A");
        aColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        aColumn.setPrefWidth(60);
        
        TableColumn<Choice, String> bColumn = new TableColumn<>("B");
        bColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        bColumn.setPrefWidth(60);
        
        TableColumn<Choice, String> cColumn = new TableColumn<>("C");
        cColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        cColumn.setPrefWidth(60);
        
        TableColumn<Choice, String> dColumn = new TableColumn<>("D");
        dColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        dColumn.setPrefWidth(60);
        
        TableColumn<Question, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        categoryColumn.setPrefWidth(62);
        
        this.tbvQuestion.getColumns().addAll(questionColumn, aColumn, bColumn, cColumn, dColumn, categoryColumn);
    }
}
