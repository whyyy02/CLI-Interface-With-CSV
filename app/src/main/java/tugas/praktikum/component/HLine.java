package tugas.praktikum.component;

public class HLine {
    // Atribut width untuk menentukan lebar garis / jumlah separator yang digunakan untuk baris
    int width;

    // Konstruktor untuk untuk mengeset atribut width
    public HLine(int width) {
        this.width = width;
    }

    // Method untuk menampilkan String garis di layar terminal
    public void draw() {
        System.out.print("+");
        for (int i = 0; i < this.width - 2; i++) {
            System.out.print("=");
        }
        System.out.println("+");
    }
}
