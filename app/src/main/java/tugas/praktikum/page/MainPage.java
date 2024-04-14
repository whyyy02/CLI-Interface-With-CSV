package tugas.praktikum.page;

import tugas.praktikum.component.*;

public class MainPage {
    public String title;
    public int width;
    private final HLine hline;
    private final Space space;
    private final Label label;

    // Konstruktor untuk membuat halaman utama dengan judul dan lebar yang
    // ditentukan
    public MainPage(String title, int width) {
        this.width = width;
        this.title = title;
        // Inisialisasi komponen header
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    // Method untuk menggambar halaman utama
    public void draw() throws Exception {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    // Method untuk menggambar header halaman
    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    // Method untuk menggambar konten halaman
    private void drawContent() throws Exception {
        // Daftar opsi halaman
        String[] pages = { "Input Password", "Print Password", "Exit" };
        // Buat objek SelectInput untuk memilih opsi halaman
        SelectInput pageSelect = new SelectInput("Input Options:",
                pages, this.width);
        int select;
        this.label.text = "Wellcome to The Password Bank";
        this.label.draw();
        this.label.draw();
        this.space.draw();
        pageSelect.draw();
        // Ambil nilai pilihan
        select = pageSelect.getValue() - 1;
        // Switch untuk memproses pilihan
        switch (select) {
            // Jika pilihan adalah Input Password, gambar halaman input password
            case 0 -> {
                drawFooter();
                new InputPage("Input Password", this.width).draw();
            }
            // Jika pilihan adalah Print Password, gambar halaman daftar password
            case 1 -> {
                drawFooter();
                new ListPasswordPage("List Password Saved", this.width).draw();
            }
            // Jika pilihan adalah Exit, gambar pesan penutup
            case 2 -> {
                new Label("Thank You", this.width).draw();
                drawFooter();
            }
            // Jika pilihan tidak valid, gambar ulang halaman utama
            default -> {
                new MainPage(this.title, this.width).draw();
            }
        }
    }

    // Method untuk menggambar footer halaman
    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
