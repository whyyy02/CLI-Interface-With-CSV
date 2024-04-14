package tugas.praktikum.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import tugas.praktikum.encryptor.PasswordStore;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataPassword {
    // ArrayList untuk menyimpan data password
    public static final ArrayList<PasswordStore> passData = new ArrayList<>();
    // Path file CSV untuk menyimpan data password
    private static final String csvPath = "./datapassword.csv";
    // Header kolom-kolom dalam file CSV
    private static final String[] headers = { "name", "username", "password",
            "hashkey", "category", "score" };

    // Method untuk menyimpan data password ke dalam file CSV
    public static void saveCSVData() {
        if (passData.isEmpty()) {
            // Cetak pesan jika data password masih kosong
            System.out.println("Data Is Still Empty");
        } else {
            try {
                // Buat FileWriter untuk menulis ke file CSV
                FileWriter writer = new FileWriter("./datapassword.csv");
                // Buat CSVFormat dengan header sesuai dengan headers yang telah ditentukan
                CSVFormat formater = CSVFormat.DEFAULT.builder().setHeader(headers).build();
                // Buat CSVPrinter untuk menulis record ke file CSV
                CSVPrinter printer = new CSVPrinter(writer, formater);
                // Tulis setiap record PasswordStore ke file CSV
                for (PasswordStore pass : passData) {
                    printer.printRecord(pass.name, pass.username, pass.getEncPassword(),
                            pass.hashCode(), pass.getCategoryCode(), pass.getScore());
                }
                // Flush printer untuk menulis semua data ke file CSV
                printer.flush();
            } catch (IOException ex) {
                // Tangkap IOException dan log pesan error
                Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Method untuk memuat data password dari file CSV
    public static ArrayList<PasswordStore> loadCSVData() throws Exception {
        // Bersihkan ArrayList passData
        passData.clear();
        try {
            // Buat FileReader untuk membaca file CSV
            FileReader reader = new FileReader(csvPath);
            // Buat CSVFormat dengan header sesuai dengan headers yang telah ditentukan
            CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(headers)
                    .setSkipHeaderRecord(true).build();
            // Parse data dari file CSV menggunakan CSVParser
            Iterable<CSVRecord> data = format.parse(reader);
            // Iterasi setiap record dari data yang diparse
            for (CSVRecord record : data) {
                PasswordStore newPass;
                // Cek apakah hashkey null atau tidak
                if (record.get("hashkey") == null) {
                    // Jika hashkey null, buat PasswordStore tanpa hashkey
                    newPass = new PasswordStore(
                            record.get("name"),
                            record.get("username"),
                            record.get("password"),
                            Integer.parseInt(record.get("category")));
                } else {
                    // Jika hashkey tidak null, buat PasswordStore dengan hashkey
                    newPass = new PasswordStore(
                            record.get("name"),
                            record.get("username"),
                            record.get("password"),
                            Integer.parseInt(record.get("category")));
                }
                // Tambahkan PasswordStore baru ke dalam ArrayList passData
                passData.add(newPass);
            }
        } catch (FileNotFoundException ex) {
            // Tangkap FileNotFoundException dan cetak pesan bahwa data password kosong
            System.out.println("Password Data is Empty");
        } catch (IOException ex) {
            // Tangkap IOException dan log pesan error
            Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Kembalikan ArrayList passData yang sudah terisi dengan data password
        return passData;
    }

}