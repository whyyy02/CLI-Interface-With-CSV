package tugas.praktikum;

import tugas.praktikum.data.DataPassword;
import tugas.praktikum.page.MainPage;

public class App {
    public static void main(String[] args) throws Exception {
        DataPassword.loadCSVData();
        new MainPage("Encrypted Password Store", 70).draw();
    }
}
