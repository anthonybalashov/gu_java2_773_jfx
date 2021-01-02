package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Controller {
    @FXML
    private   Label nickName;
    @FXML
    private  ImageView avatar;
    @FXML
    private ChoiceBox status;
    @FXML
    private ListView chatBox;
    @FXML
    private ListView userList;
    @FXML
    private TextField chatField;
    @FXML
    private Button sendButton;


    public void initialize() throws FileNotFoundException {
        // set NickName
        nickName.setText("Anton Balashov");

        // set Avatar
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        System.out.println(path);
        InputStream stream = new FileInputStream(path + "/src/image/images.jpeg");
        Image image = new Image(stream);
        avatar.setImage(image);

        // set UserList
        userList.getItems().add("Maxim");
        userList.getItems().add("Alena");
        userList.getItems().add("Denis");
        userList.getItems().add("Sasha");
        // add NickName to userList
        userList.getItems().add(nickName.getText());

        // set Status
        status.getItems().add("Online");
        status.getItems().add("AFK");
        status.getItems().add("Offline");

        // set default status
        status.getSelectionModel().selectFirst();

    }


    public void sendText(MouseEvent mouseEvent) {
        chatBox.getItems().add(chatField.getText());
        chatField.clear();
    }


    public void addUserTochatField(MouseEvent mouseEvent) {
        chatField.setText(chatField.getText() + " " + userList.getSelectionModel().getSelectedItem().toString() + " ");
    }

    public void clickChatField(MouseEvent mouseEvent) {
        if (chatField.getText().equals("Enter text to chatting")) {
            chatField.clear();
        }
    }
}


