package tugas.praktikum.component;

import java.util.Scanner;

public class SelectInput {
    // Atribut label merupakan teks label yang berisikan informasi yang relevan dengan input
    String label;
    // Atribut width untuk menentukan lebar tampilan dari pilihan inputan
    int width;
    // Atribut selection berisi Array of String teks pilihan inputan
    String[] selection;
    // Atribut value digunakan untuk menampung hasil inputan pengguna
    int value;
    // Atribute input merupakan komponen class Input yang digunakan untuk mendapatkan pilihn inputan pengguna
    Scanner input = new Scanner(System.in);

    // Konstruktor digunakan untuk inisialisasi atribut label , width , selection , dan komponen input
    public SelectInput(String label, String[] selection, int width) {
        this.label = label;
        this.width = width;
        this.selection = selection;
    }

    // Method draw() bertanggung jawab memberikan tampilan pilihan dan input sesuai format yang ditentukan
    public void draw() {
        new Label(this.label, 50).draw();
        int i = 1;
        for (String s : selection) {
            new Label("  [" + i + "] " + s, 50).draw();
            i++;
        }
        System.out.print("|  Pilihan : ");
        this.value = this.input.nextInt();
    }

    // Method getValue() dapat digunakan untuk mendapatkan nilai pilihan yang diinputkan pengguna.
    public int getValue() {
        return value;
    }
}
