package tugas.praktikum.component;

public class Label {
    // Atribut width untuk menentukan lebar minimal area
    int width;
    // Atribut text untuk menentukan teks yang dicetak pada baris tersebut
    public String text;

    // Konstruktor dengan parameter text untuk mengset atribute text dan width untuk mengeset atribut width
    public Label(String text, int width) {
        this.text = text;
        this.width = width;
    }

    // Method draw untuk menampilkan text pada area dengan lebar minimal width-2 (karena terdapat 2 spasi sebelum teks)
    public void draw() {
        System.out.print("|  " + this.text);
        for (int i = 0; i < this.width - 2 - this.text.length(); i++) {
            System.out.print(" ");
        }
        System.out.println(" |");
    }
}
