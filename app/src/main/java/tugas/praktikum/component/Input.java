package tugas.praktikum.component;

import java.util.Scanner;

public class Input {
    // Atribut label untuk menyimpan teks label dari inputan
    String label;
    // Atribut input untuk meyimpan object stream input yang digunakan ( Scanner(System.in) )
    Scanner input = new Scanner(System.in);
    // Atribut value untuk menyimpan nilai hasil inputan pengguna
    String value;

    // Konstruktor dengan parameter label untuk mengeset atribut label
    public Input(String label) {
        this.label = label;
    }

    // Method draw() untuk menampilkan label di tampilan serta membuat kursor CLI siap menerima inputan
    public void draw() {
        System.out.print("|  " + label + " : ");
        this.value = this.input.nextLine();
    }

    // Method getValue() untuk mendapatkan nilai ( String ) yang diinputkan pengguna
    public String getValue() {
        return this.value;
    }

    // Method getValueInt() untuk mendapatkan nilai integer yang diinputkan pengguna
    public int getValueInt() {
        return Integer.parseInt(this.value);
    }

    // Method getValueDouble() untuk mendapatkan nilai double yang diinputkan pengguna
    public double getValueDouble() {
        return Double.parseDouble(this.value);
    }
}
