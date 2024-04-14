package tugas.praktikum.component;

public class Space {
    // Atribute width untuk menentukan lebar spasi
    int width;

    // Konstruktor dengan parameter width untuk mengeset atribut width
    public Space(int width) {
        this.width = width;
    }

    // Method draw untuk menampilkan baris kosong dengan garis depan & belakang
    public void draw() {
        System.out.print("|");
        for (int i = 0; i < this.width; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
