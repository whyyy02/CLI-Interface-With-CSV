package tugas.praktikum.page;

import tugas.praktikum.component.*;
import tugas.praktikum.data.*;
import tugas.praktikum.encryptor.PasswordStore;

public class InputPage {
    String label;
    int width;
    String nama;
    String username;
    String password;
    int category;

    // Konstruktor untuk membuat halaman input dengan label dan lebar yang
    // ditentukan
    public InputPage(String label, int width) {
        this.label = label;
        this.width = width;
    }

    // Method untuk menggambar halaman input
    public void draw() throws Exception {
        // Garis horizontal
        new HLine(this.width).draw();
        // Spasi
        new Space(this.width).draw();
        // Label untuk input password
        new Label("Input Password", this.width).draw();
        new Space(this.width).draw();
        new HLine(this.width).draw();

        new Space(this.width).draw();
        // Buat objek Input untuk nama, username, dan password
        Input nama = new Input("Title Password");
        Input username = new Input("Username");
        Input password = new Input("Password");
        nama.draw();
        // Simpan nilai dari input nama
        this.nama = nama.getValue();
        // Simpan nilai dari input username
        username.draw();
        this.username = username.getValue();
        // Simpan nilai dari input password
        password.draw();
        this.password = password.getValue();

        // Daftar pilihan kategori password
        String[] pilihan = { "Not Yet Categorized", "Web Application", "Mobile Application", "Other Accounts" };

        // Buat objek SelectInput untuk memilih kategori password, dan gambar
        SelectInput pilSelect = new SelectInput(this.label, pilihan, this.width);
        // Simpan nilai dari pilihan kategori password
        pilSelect.draw();
        this.category = pilSelect.getValue();
        new Space(this.width).draw();
        new HLine(this.width).draw();

        // Buat objek PasswordStore dengan informasi yang telah diinputkan, tambahkan ke dalam passData, dan simpan ke file CSV
        PasswordStore passwordStore = new PasswordStore(this.nama, this.username, this.password, this.category);
        DataPassword.passData.add(passwordStore);
        DataPassword.saveCSVData();

        new Label("----- -----", this.width);
        new Label("Password Saved Successufully", this.width).draw();
        new Space(this.width).draw();
        new HLine(this.width).draw();
        // Kembali ke halaman utama
        new MainPage("Encrypted Password Store", this.width).draw();
    }
}
