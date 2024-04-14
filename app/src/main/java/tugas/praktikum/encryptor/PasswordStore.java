package tugas.praktikum.encryptor;

public class PasswordStore {
    // Variabel instance untuk menyimpan informasi password
    public String name, username;
    private String password, hashkey;
    private double score;
    private int category;
    // Konstanta untuk kategori password
    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;

    // Konstruktor untuk membuat instance PasswordStore dengan kategori default
    // UNCATEGORIZED
    public PasswordStore(String name, String username, String plainPass) throws Exception {
        this.hashkey = Encryptor.generateKey();
        this.name = name;
        this.username = username;
        setPassword(plainPass);
    }

    // Konstruktor untuk membuat instance PasswordStore dengan kategori yang
    // ditentukan
    public PasswordStore(String name, String username, String plainPass, int category) throws Exception {
        this.hashkey = Encryptor.generateKey();
        this.name = name;
        this.username = username;
        this.category = category;
        this.setPassword(plainPass);
    }

    // Method untuk mengatur password dan menghitung skor
    public void setPassword(String plainPass) throws Exception {
        this.password = Encryptor.encrypt(plainPass, hashkey);
        this.calculateScore(plainPass);
    }

    // Method untuk mendapatkan password yang telah dienkripsi
    public String getPassword() throws Exception {
        return Encryptor.decrypt(this.password, this.hashkey);
    }

    // Method untuk mengatur kategori password
    public void setCategory(int category) {
        this.category = category;
    }

    // Method untuk mendapatkan nama kategori password
    public String getCategory() {
        String categoryName;

        switch (this.category) {
            case UNCATEGORIZED:
                categoryName = "Not Yet Categorized";
                break;
            case CAT_WEBAPP:
                categoryName = "Web Application";
                break;
            case CAT_MOBILEAPP:
                categoryName = "Mobile Application";
                break;
            case CAT_OTHER:
                categoryName = "Other Accounts";
                break;
            default:
                categoryName = "No Categories";
                break;
        }
        return categoryName;
    }

    // Method untuk mendapatkan hashkey
    public String getHashKey() {
        return this.hashkey;
    }

    // Method untuk mendapatkan kode kategori password
    public int getCategoryCode() {
        return this.category;
    }

    // Method untuk mendapatkan password yang telah dienkripsi
    public String getEncPassword() {
        return this.password;
    }

    // Method untuk mendapatkan skor password
    public double getScore() {
        return this.score;
    }

    // Method untuk menghitung skor berdasarkan panjang password
    private void calculateScore(String plainPass) {
        if (plainPass.length() > 15) {
            this.score = 10;
        } else {
            this.score = (plainPass.length() / 15.0) * 10;
        }
    }

    // Method untuk menggabungkan informasi password ke dalam string
    @Override
    public String toString() {
        return "Usename: " + this.username + "\n" +
                "Password: " + this.password + "\n" +
                "Hashkey: " + this.hashkey + "\n" +
                "Kategori: " + this.getCategory() + "\n" +
                "Score: " + this.score + "\n";
    }

}
