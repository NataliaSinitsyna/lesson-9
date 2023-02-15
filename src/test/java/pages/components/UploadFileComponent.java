package pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {
    public void addFile(String value) {
        File file = new File("src/test/resources/" + value);
        $("#uploadPicture").uploadFile(file);
    }
}
