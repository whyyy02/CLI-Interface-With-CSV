package tugas.praktikum.page;

import tugas.praktikum.component.*;
import tugas.praktikum.data.*;
import tugas.praktikum.encryptor.PasswordStore;

public class ListPasswordPage {
    String label;
    int width;

    // Konstruktor untuk membuat halaman daftar password dengan label dan lebar yang
    // ditentukan
    public ListPasswordPage(String label, int width) {
        this.label = label;
        this.width = width;
    }

    // Method untuk menggambar halaman daftar password
    public void draw() throws Exception {
        new HLine(this.width).draw();
        new Space(this.width).draw();
        new Label(this.label, this.width).draw();
        ;
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        // Gambar label untuk menampilkan jumlah password yang disimpan
        new Label("There are " + DataPassword.passData.size() + " saved", this.width).draw();
        new Label("----- ----- -----", this.width);
        // Loop untuk setiap password yang disimpan
        for (PasswordStore ps : DataPassword.passData) {
            new Label(String.format("| %-15s | %-15s | %-15s |", ps.name, ps.username, ps.getCategory()), this.width)
                    .draw();
        }
        new Space(this.width).draw();
        new HLine(this.width).draw();
        // Kembali ke halaman utama
        new MainPage("Encrypted Password Store", this.width).draw();
    }
}
