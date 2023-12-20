import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ProyekBookingGedung {
    static int stepLogin, menuGedung, pilihGedung, jumlahTamu, menuAdmin, menuKasir, menuUser, menuManager, indeksBarang, indexKasir, 
               jumlahBarang = 0, jumlahGedung = 0, jumlahUser = 0, jumlahAdmin = 0, jumlahKasir = 0, jumlahManager = 0, tambahStokGedung,
               tambahanStokBarang, jumlahData=0, jumlahHistori=0, totalBuilding=0, totalItem = 0, bahasa;
    static long totalBiaya, totalPendapatanBulanan = 0;
    static double cetakHargaMember, diskon, totalTarif;
    static String inputNamaPelanggan, inputNoTelpPelanggan, inputTanggal, totalGedung = "", totalBarang = "", jumlahTotalBarang = "",
                  totalMetodePembayaran = "", targetNamaGedung, targetNamaBarang;
    static boolean pilihanUser, pilihanManager;

    static String[] namaPelanggan = new String[100];
    static String[] noTelpPelanggan = new String[100];
    static String [] tampilTanggal = new String[100];
    static int [] tamuPemesan = new int[100];
    static String[] cetakGedung = new String[100];
    static String[] cetakBarang = new String[100];
    static long [] tampilBiaya = new long[100];
    static String[] cetakMetodePembayaran= new String[100];
    static int [] cetakStokGedung = new int[100];
    
    static String menuMetodeBayar[] = {"BRI", "BNI", "BCA", "DANA", "GoPay", "LinkAja"};
    static String kodeVerifikasi[] = { "01234", "12345", "23456", "34567", "45678", "56789", "67890" };
    static String kodeMember[] = {"a1b2c3", "12ab34cd", "01000001", "01000111", "01001010"};

    static String[] namaBarang = new String[100];
    static int[] stokBarang = new int[100];

    static String[] namaGedung = new String[100];
    static int[] stokGedung = new int[100];
    static int[] tamuGedung = new int[100];
    static double[] hargaGedung = new double[100];
    static int[] daftarHargaGedung = new int[100];
    static String[] regUsernameAdmin = new String[100];
    static String[] regPasswordAdmin = new String[100];

    static String[] regUsernameKasir = new String[100];
    static String[] regPasswordKasir = new String[100];

    static String[] regUsernameUser = new String[100];
    static String[] regPasswordUser = new String[100];

    static String[] regUsernameManager = new String[100];
    static String[] regPasswordManager = new String[100];

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static Date tanggal = null;
    static Calendar calendar = Calendar.getInstance();

    static boolean isValidFormat(String value, SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);
        Date parsedDate = dateFormat.parse(value, new ParsePosition(0));
        return parsedDate != null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        regUsernameAdmin[jumlahAdmin] = "gerly";
        regPasswordAdmin[jumlahAdmin]= "000";
        jumlahAdmin++;

        regUsernameKasir[jumlahKasir] = "april";
        regPasswordKasir[jumlahKasir]= "111";
        jumlahKasir++;

        regUsernameUser[jumlahUser] = "jaden";
        regPasswordUser[jumlahUser] = "222";
        jumlahUser++;

        regUsernameManager[jumlahManager] = "vivin";
        regPasswordManager[jumlahManager] = "333";
        jumlahManager++;

        namaGedung[jumlahGedung] = "PERNIKAHAN";
        stokGedung[jumlahGedung] = 1;
        hargaGedung[jumlahGedung] = 5000000.0;
        daftarHargaGedung[jumlahGedung] = 5000000;
        tamuGedung[jumlahGedung] = 5000;
        jumlahGedung++;

        namaGedung[jumlahGedung] = "AUDITORIUM";
        stokGedung[jumlahGedung] = 1;
        hargaGedung[jumlahGedung] = 2000000.0;
        daftarHargaGedung[jumlahGedung] = 2000000;
        tamuGedung[jumlahGedung] = 2000;
        jumlahGedung++;

        namaBarang[jumlahBarang] = "Meja";
        stokBarang[jumlahBarang] = 20000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Kursi";
        stokBarang[jumlahBarang] = 20000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Piring";
        stokBarang[jumlahBarang] = 20000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Sendok";
        stokBarang[jumlahBarang] = 20000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Garpu";
        stokBarang[jumlahBarang] = 20000;
        jumlahBarang++;

        System.out.println("\n T-.__________________________________________________________.-T");
        System.out.println(" ||                                                            ||");
        System.out.println(" ||       SELAMAT DATANG DI WEBSITE BOOKING GEDUNG SOEHAT      ||");
        System.out.println(" ||                                                            ||");
        System.out.println("<||.----------------------------------------------------------.||>");
        boolean pilihMenu = true;
        while (pilihMenu) {
            do {
                System.out.println("\n,----------------------------------------------------------<");
                System.out.println("|                        DAFTAR MENU                       |");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("|   1. Login Admin          5. Pencarian Gedung Tersedia   |");
                System.out.println("|   2. Login Kasir          6. Pencarian Barang Tersedia   |");
                System.out.println("|   3. Login User           7. Daftar Akun User Baru       |");
                System.out.println("|   4. Login Manager        8. Keluar                      |");
                System.out.println("|__________________________________________________________/.");
                System.out.print("||> Masukkan Pilihan Anda: ");
                stepLogin = input.nextInt();
                if (stepLogin < 1 || stepLogin > 7) {
                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 7 !");
                }
            } while (stepLogin < 1 || stepLogin > 7);
            if (stepLogin == 1) {
                boolean regUsernameAdminValid = true;
                do {
                    System.out.println("\n---------------------------------------------------");
                    System.out.print("||> Masukkan username: ");
                    String inputUsernameAdmin = input.next();
                    System.out.println("---------------------------------------------------");
                    System.out.print("||> Masukkan password: ");
                    String inputPasswordAdmin = input.next();
                    System.out.println("---------------------------------------------------");
                    regUsernameAdminValid = false;
                    int indeksAdmin = -1;
                    for (int i = 0; i < jumlahAdmin; i++) {
                        if (inputUsernameAdmin.equals(regUsernameAdmin[i]) && inputPasswordAdmin.equals(regPasswordAdmin[i])) {
                            regUsernameAdminValid = true;
                            indeksAdmin = i;
                            break;
                        }
                    }
                    if (regUsernameAdminValid) {
                        System.out.println("\n-....................................-");
                        System.out.println("          ! LOGIN BERHASIL !          ");
                        System.out.println("       SELAMAT DATANG, ADMIN :)       ");
                        System.out.println("-....................................-");
                    } else {
                        System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                    }
                } while (!regUsernameAdminValid);
                boolean pilihanAdmin = true;
                while (pilihanAdmin) {
                    do {
                        System.out.println("\n,----------------------------------------------------------<");
                        System.out.println("|                         MENU ADMIN                       |");
                        System.out.println("|----------------------------------------------------------|");
                        System.out.println("|   1. Pencarian Admin Terdaftar    5. Lihat Data Admin    |");
                        System.out.println("|   2. Pencarian Kasir Terdaftar    6. Lihat Data Kasir    |");
                        System.out.println("|   3. Pencarian User Terdaftar     7. Lihat Data User     |");
                        System.out.println("|   4. Lihat Histori Pemesanan      8. Keluar              |");
                        System.out.println("|_________________________________________________________/.");
                        System.out.print("||> Masukkan Pilihan Anda: ");
                        menuAdmin = input.nextInt();
                        if (menuAdmin < 1 || menuAdmin > 8) {
                            System.out.println("\n! Mohon masukkan nomor antara 1 dan 8 !");
                        }
                    } while (menuAdmin < 1 || menuAdmin > 8);
                    switch (menuAdmin) {
                        case 1:
                            PencarianAdminTerdaftar();
                            break;
                        case 2:
                            PencarianKasirTerdaftar();
                            break;
                        case 3:
                            PencarianUserTerdaftar();
                            break;
                        case 4:
                            if (jumlahHistori>0){
                                LihatHistoriPemesanan();
                            } else {
                                System.out.println("\n! Belum ada Histori pemesanan yang akan dicetak !");
                            }
                            break;
                        case 5:
                            lihatDataAdmin();
                            break;
                        case 6:
                            lihatDataKasir();
                            break;
                        case 7:
                            LihatDataUser();
                            break;
                        case 8:
                            pilihMenu = true;
                            pilihanAdmin = false;
                            break;
                    }
                }
            } else if (stepLogin == 2) {
                boolean regUsernameKasirValid = true;
                do {
                    System.out.println("\n---------------------------------------------------");
                    System.out.print("||> Masukkan username: ");
                    String inputUsernameKasir = input.next();
                    System.out.println("---------------------------------------------------");
                    System.out.print("||> Masukkan password: ");
                    String inputPasswordKasir = input.next();
                    System.out.println("---------------------------------------------------");
                    regUsernameKasirValid = false;
                    indexKasir = -1;
                    for (int i = 0; i < jumlahKasir; i++) {
                        if (inputUsernameKasir.equals(regUsernameKasir[i]) && inputPasswordKasir.equals(regPasswordKasir[i])) {
                            regUsernameKasirValid = true;
                            indexKasir = i;
                            break;
                        }
                    }
                    if (regUsernameKasirValid) {
                        System.out.println("\n-....................................-");
                        System.out.println("          ! LOGIN BERHASIL !          ");
                        System.out.println("       SELAMAT DATANG, KASIR :)       ");
                        System.out.println("-....................................-");
                    } else {
                        System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                    }
                } while (!regUsernameKasirValid);
                boolean pilihanKasir = true;
                while (pilihanKasir) {
                    do {
                        System.out.println("\n,-------------------------------------------------------------<");
                        System.out.println("|                          MENU KASIR                         |");
                        System.out.println("|-------------------------------------------------------------|");
                        System.out.println("|   1. Cetak Struk Pemesanan     4. Lihat Laporan Pendapatan  |");
                        System.out.println("|   2. Lihat Sisa Stok Gedung    5. Keluar                    |");
                        System.out.println("|   3. Lihat Sisa Stok Barang                                 |");
                        System.out.println("|____________________________________________________________/.");
                        System.out.print("||> Masukkan Pilihan Anda: ");
                        menuKasir = input.nextInt();
                        if (menuKasir < 1 || menuKasir > 5) {
                            System.out.println("\n! Mohon masukkan nomor antara 1 dan 5 !");
                        }
                    } while (menuKasir < 1 || menuKasir > 5);
                    switch (menuKasir) {
                        case 1:
                            if (jumlahHistori>0){
                            cetakStruk();
                            } else {
                                System.out.println("\n! Belum ada struk pemesanan yang akan dicetak !");
                            }
                            break;
                        case 2:
                            tampilkanStokGedung();
                            break;
                        case 3:
                            tampilkanStokBarang();
                            break;
                        case 4:
                            if (jumlahHistori>0){
                                LaporanPendapatan(new Date());
                            } else {
                                System.out.println("\n! Belum ada laporan pendapatan yang akan dicetak !");
                            }
                        case 5:
                            pilihMenu = true;
                            pilihanKasir = false;
                            break;
                    }
                }
            } else if (stepLogin == 3) {
                boolean regUsernameUserValid;
                do {
                    System.out.println("\n---------------------------------------------------");
                    System.out.print("||> Masukkan username: ");
                    String inputUsernameManager = input.next();
                    System.out.println("---------------------------------------------------");
                    System.out.print("||> Masukkan password: ");
                    String inputPasswordManager = input.next();
                    System.out.println("---------------------------------------------------");
                    regUsernameUserValid = false;
                    int indeksUser = -1;
                    for (int i = 0; i < jumlahUser; i++) {
                        if (inputUsernameManager.equals(regUsernameUser[i]) && inputPasswordManager.equals(regPasswordUser[i])) {
                            regUsernameUserValid = true;
                            indeksUser = i;
                            break;
                        }
                    }
                    if (regUsernameUserValid) {
                        System.out.println("\n-...................................-");
                        System.out.println("          ! LOGIN BERHASIL !         ");
                        System.out.println("       SELAMAT DATANG, USER :)       ");
                        System.out.println("-...................................-");
                    } else {
                        System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !!");
                    }
                } while (!regUsernameUserValid);
                pilihanUser = true;
                while (pilihanUser) {
                    do {
                        System.out.println("\n,--------------------------------------------<");
                        System.out.println("|                  MENU USER                 |");
                        System.out.println("|--------------------------------------------|");
                        System.out.println("|   1. Pesan Gedung Sekarang    3. Keluar    |");
                        System.out.println("|   2. Lihat Sisa Stok Gedung                |");
                        System.out.println("|___________________________________________/.");
                        System.out.print("||> Masukkan Pilihan Anda: ");
                        menuUser = input.nextInt();
                        if (menuUser < 1 || menuUser > 3) {
                            System.out.println("\n! Mohon masukkan nomor antara 1 dan 3 !");
                        }
                        switch (menuUser) {
                            case 1:
                                ProsesPemesananGedung();
                                break;
                            case 2:
                                tampilkanStokGedung();
                                break;
                            case 3:
                                pilihMenu = true;
                                pilihanUser = false;
                                break;
                        }
                    } while (menuUser < 1 || menuUser > 3);
                }
            } else if (stepLogin == 4) {
                boolean regUsernameManagerValid;
                do {
                    System.out.println("\n---------------------------------------------------");
                    System.out.print("||> Masukkan username: ");
                    String inputUsernameUser = input.next();
                    System.out.println("---------------------------------------------------");
                    System.out.print("||> Masukkan password: ");
                    String inputPasswordUser = input.next();
                    System.out.println("---------------------------------------------------");
                    regUsernameManagerValid = false;
                    int indeksManager = -1;
                    for (int i = 0; i < jumlahUser; i++) {
                        if (inputUsernameUser.equals(regUsernameManager[i]) && inputPasswordUser.equals(regPasswordManager[i])) {
                            regUsernameManagerValid = true;
                            indeksManager = i;
                            break;
                        }
                    }
                    if (regUsernameManagerValid) {
                        System.out.println("\n-...................................-");
                        System.out.println("          ! LOGIN BERHASIL !         ");
                        System.out.println("     SELAMAT DATANG, MANAGER :)      ");
                        System.out.println("-...................................-");
                    } else {
                        System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !!");
                    }
                } while (!regUsernameManagerValid);
                pilihanManager = true;
                while (pilihanManager) {
                    do {
                        System.out.println("\n,--------------------------------------------------------------<");
                        System.out.println("|                         MENU MANAGER                         |");
                        System.out.println("|--------------------------------------------------------------|");
                        System.out.println("|   1. Lihat Laporan Pendapatan     7. Tambah Stok Barang      |");
                        System.out.println("|   2. Lihat Histori Pemesanan      8. Tambah Barang Baru      |");
                        System.out.println("|   3. Lihat Sisa Stok Gedung       9. Tambah Akun Admin       |");
                        System.out.println("|   4. Tambah Stok Gedung           10. Tambah Akun Kasir      |");
                        System.out.println("|   5. Tambah Gedung Baru           11. Keluar                 |");
                        System.out.println("|   6. Lihat Sisa Stok Barang                                  |");
                        System.out.println("|_____________________________________________________________/.");
                        System.out.print("||> Masukkan Pilihan Anda: ");
                        menuManager = input.nextInt();
                        if (menuManager < 1 ||menuManager > 11) {
                            System.out.println("\n! Mohon masukkan nomor antara 1 dan 11 !");
                        }
                        switch (menuManager) {
                            case 1:
                                if (jumlahHistori>0){
                                    LaporanPendapatan(new Date());
                                } else {
                                    System.out.println("\n! Belum ada laporan pendapatan yang akan dicetak !");
                                }
                                break;
                            case 2:
                                if (jumlahHistori>0){
                                    LihatHistoriPemesanan();
                                } else {
                                    System.out.println("\n! Belum ada Histori pemesanan yang akan dicetak !");
                                }
                                break;
                            case 3:
                                tampilkanStokGedung();
                                break;
                            case 4:
                                tambahkanStokGedung(targetNamaGedung, tambahStokGedung);
                                break;
                            case 5:
                                tambahGedung();
                                break;
                            case 6:
                                tampilkanStokBarang();
                                break;
                            case 7:
                                tambahkanStokBarang(targetNamaBarang, tambahanStokBarang);
                                break;
                            case 8:
                                tambahBarang();
                                break;
                            case 9:
                                tambahAkunAdmin();
                                break;
                            case 10:
                                tambahAkunKasir();
                                break;
                            case 11:
                                pilihanManager = false;
                                pilihMenu = true;
                                break;
                        }
                    } while (menuManager < 1 || menuManager > 11);
                }
            } else if (stepLogin == 5) {
                cariNamaGedung(targetNamaGedung);
            } else if (stepLogin == 6) {
                cariNamaBarang(targetNamaBarang);
            } else if (stepLogin == 7){
                tambahAkunUser();
            } else if (stepLogin == 8) {
                pilihMenu = false;
                System.exit(0);
            }
        }            
    }
    
    //FUNGSI UNTUK MENAMBAH AKUN USER BARU PADA MENU STEP LOGIN == 4 MENU
    public static void tambahAkunUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan username baru: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan password baru: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahUser < regUsernameUser.length && jumlahUser < regPasswordUser.length) {
            regUsernameUser[jumlahUser] = inputUserBaru;
            regPasswordUser[jumlahUser] = inputPwBaru;
            jumlahUser++;
            System.out.println("\n-....................................-");
            System.out.println("   ! USER BARU BERHASIL TERDAFTAR !   ");
            System.out.println("-....................................-\n");
        } else {
            System.out.println("\nMohon maaf, jumlah member melebihi batas.");
        }
    }

    //FUNGSI UNTUK MENCARI NAMA GEDUNG TERSEDIA PADA MENU STEP LOGIN == 5 MENU
    public static void cariNamaGedung(String targetNamaGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
                    System.out.print("||> Masukkan nama gedung: ");
                    targetNamaGedung = input.next();
                    System.out.println("----------------------------------------------------");
        boolean jikaGedungDitemukan = false;
        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetNamaGedung)) {
                jikaGedungDitemukan = true;
                System.out.println("\n.---------------------------------.");
                System.out.println("!       ! Gedung Tersedia !       !");
                System.out.println("!.-------------------------------.!");
                break;
            }
        }
        if (!jikaGedungDitemukan) {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!     ! Gedung Tidak Tersedia !     !");
            System.out.println("!.---------------------------------.!");
        }
    }

    //FUNGSI UNTUK MENCARI NAMA BARANG TERSEDIA PADA MENU STEP LOGIN == 6 MENU
    public static void cariNamaBarang(String targetNamaBarang) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
                    System.out.print("||> Masukkan nama barang: ");
                    targetNamaBarang = input.next();
                    System.out.println("----------------------------------------------------");
        boolean isBarangDitemukan = false;
        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetNamaBarang)) {
                isBarangDitemukan = true;
                System.out.println("\n.------------------------------------.");
                System.out.println("!      ! Nama Barang Tersedia !      !");
                System.out.println("!.----------------------------------.!");
                break;
            }
        }
        if (!isBarangDitemukan) {
            System.out.println("\n.--------------------------------------.");
            System.out.println("!    ! Nama Barang Tidak Tersedia !    !");
            System.out.println("!.------------------------------------.!");
        }
    }

    //CASE 1 MENU ADMIN
    public static void PencarianAdminTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Masukkan username admin: ");
        String targetAdmin = input.next();
        System.out.println("----------------------------------------------------");
        boolean adminTerdaftar = false;
        for (int i = 0; i < jumlahAdmin; i++) {
            if (regUsernameAdmin[i].equals(targetAdmin)) {
                adminTerdaftar = true;
                break;
            }
        }
        System.out.println("\n.------------------------------------.");
        if (adminTerdaftar) {
            System.out.println("!     ! Admin Sudah Terdaftar !      !");
        } else if (!adminTerdaftar) {
            System.out.println("!     ! Admin Tidak Terdaftar !      !");
        }
        System.out.println("!.----------------------------------.!");
    }

    //CASE 2 MENU ADMIN
    public static void PencarianKasirTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Masukkan username kasir: ");
        String targetKasir = input.next();
        System.out.println("----------------------------------------------------");
        boolean kasirTerdaftar = false;
        for (int i = 0; i < jumlahKasir; i++) {
            if (regUsernameKasir[i].equals(targetKasir)) {
                kasirTerdaftar = true;
                break;
            }
        }
        System.out.println("\n.------------------------------------.");
        if (kasirTerdaftar) {
            System.out.println("!     ! Kasir Sudah Terdaftar !      !");
        } else if (!kasirTerdaftar) {
            System.out.println("!     ! Kasir Tidak Terdaftar !      !");
        }
        System.out.println("!.----------------------------------.!");
    }

    //CASE 3 MENU ADMIN
    public static void PencarianUserTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Masukkan username user: ");
        String targetUser = input.next();
        System.out.println("----------------------------------------------------");
        boolean userTerdaftar = false;
        for (int i = 0; i < jumlahUser; i++) {
            if (regUsernameUser[i].equals(targetUser)) {
                userTerdaftar = true;
                break;
            }
        }
        System.out.println("\n.------------------------------------.");
        if (userTerdaftar) {
            System.out.println("!      ! User Sudah Terdaftar !      !");
        } else if (!userTerdaftar) {
            System.out.println("!      ! User Tidak Terdaftar !      !");
        }
        System.out.println("!.----------------------------------.!");
    }

    //CASE 4 MENU ADMIN | //CASE 2 MENU KASIR | //CASE 2 MENU USER
    public static void tampilkanStokGedung() {
        System.out.println("\n-----------------------------------");
        System.out.println("Sisa Stok Gedung");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahGedung; i++) {
            System.out.println((i + 1) + ". " + namaGedung[i] + "\t: " + stokGedung[i]);
        }
        System.out.println("-----------------------------------");
    }
    
    //CASE 5 MENU ADMIN | //CASE 5 MENU KASIR
    public static void tampilkanStokBarang(){
        System.out.println("\n,-------------------------------<");
        System.out.println("|     Daftar Barang Tersedia    | ");
        System.out.println("|_______________________________|");
        System.out.println("| No. | Nama Barang | Stok \t|");
        System.out.println("|-----|-------------|-----------|");
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("| " + (i + 1) + ".  | " + namaBarang[i] + "\t    | "+ stokBarang[i] + "\t|");
        }
        System.out.println("|_____|_____________|__________/.");
    }

    //CASE 1 MENU KASIR
    public static void cetakStruk() {
        System.out.println("\n==============================================\n");
        System.out.println("\t     BOOKING GEDUNG SOEHAT\n");
        System.out.println("============= NOTA PEMESANAN ANDA ============");
        System.out.println("\nGedung Dipesan"+ cetakGedung[jumlahHistori-1]);
        System.out.println("\nAtas Nama         : " + namaPelanggan[jumlahHistori-1]);
        System.out.println("No. Telepon       : " + noTelpPelanggan[jumlahHistori-1]);
        System.out.println("Tanggal           : " + tampilTanggal[jumlahHistori-1]);
        System.out.println("Jumlah Tamu       : " + tamuPemesan[jumlahHistori-1]);
        System.out.println("\nBarang tambahan"+cetakBarang[jumlahHistori-1]);
        System.out.println("\nTotal Biaya       : Rp." + tampilBiaya[jumlahHistori-1]);
        System.out.println("---------------------------------------------");
        System.out.println("Metode Pembayaran : " + cetakMetodePembayaran[jumlahHistori-1]);
        System.out.println("---------------------------------------------");
        System.out.println("\t   Jl. Soekarno Hatta No.9");
        System.out.println("       Kel. Jatimulyo, Kec. Lowokwaru");
        System.out.println("\t       MALANG 65141");
        System.out.println("---------------------------------------------");
    }

    //CASE 3 MENU KASIR
    public static void tambahkanStokGedung(String targetNamaGedung, int tambahStokGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Masukkan nama gedung: ");
        targetNamaGedung = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan tambahan stok: ");
        tambahStokGedung = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaGedungTersedia = false;
        int indeks = -1;
        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetNamaGedung)) {
                jikaGedungTersedia = true;
                indeks = i;
                break;
            }
        }
        if (jikaGedungTersedia) {
            stokGedung[indeks] += tambahStokGedung;
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Stok Gedung Ditambahkan !    !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Nama Gedung: " + namaGedung[indeks]);
            System.out.println("  Stok Tersedia Sekarang: " + stokGedung[indeks]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Gedung Tidak Tersedia !      !");
            System.out.println("!.----------------------------------!");
        }
        
    }

    //CASE 4 MENU KASIR
    public static void tambahGedung() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("Masukkan Nama Gedung Baru: ");
        String namaGedungBaru = input.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.print("Masukkan Stok Gedung Baru: ");
        int stokGedungBaru = input.nextInt();
        System.out.print("Masukkan Harga Sewa : ");
        double hargaSewaGedungBaru = input.nextDouble();
        int tampilHargaGedungBaru = (int)hargaSewaGedungBaru;
        System.out.print("Masukkan kapasitas maksimal tamu: ");
        int tamuBaru = input.nextInt();
        System.out.println("----------------------------------------------------");
        if (jumlahGedung < namaGedung.length && jumlahGedung < stokGedung.length) {
            namaGedung[jumlahGedung] = namaGedungBaru;
            stokGedung[jumlahGedung] = stokGedungBaru;
            hargaGedung[jumlahGedung] = hargaSewaGedungBaru;
            daftarHargaGedung[jumlahGedung] = tampilHargaGedungBaru;
            tamuGedung[jumlahGedung] = tamuBaru;
            jumlahGedung++;
            System.out.println("\nGedung baru berhasil ditambahkan!");
        } else {
            System.out.println("\n! Mohon maaf, jumlah gedung melebihi batas !");
        }
    }
    
    //CASE 6 MENU KASIR
    public static void tambahkanStokBarang(String targetNamaBarang, int tambahanStokBarang) {
        Scanner input = new Scanner(System.in);
        System.out.print("||> Masukkan nama barang: ");
        targetNamaBarang = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan tambahan stok: ");
        tambahanStokBarang = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaBarangTersedia = false;
        indeksBarang = -1;
        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetNamaBarang)) {
                jikaBarangTersedia = true;
                indeksBarang = i;
                break;
            }
        }
        if (jikaBarangTersedia) {
            stokBarang[indeksBarang] += tambahanStokBarang;
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Stok Barang Ditambahkan !    !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Nama Barang: " + namaBarang[indeksBarang]);
            System.out.println("  Stok Tersedia Sekarang: " + stokBarang[indeksBarang]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Barang Tidak Tersedia !      !");
            System.out.println("!.---------------------------------!");
        }
    }

    //CASE 7 MENU KASIR
    public static void tambahBarang() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("Masukkan Nama Barang Baru: ");
        String namaBarangBaru = input.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.print("Masukkan Stok Barang Baru: ");
        int stokBarangBaru = input.nextInt();
        System.out.println("----------------------------------------------------");
        if (jumlahBarang < namaBarang.length && jumlahBarang < stokBarang.length) {
            namaBarang[jumlahBarang] = namaBarangBaru;
            stokBarang[jumlahBarang] = stokBarangBaru;
            jumlahBarang++;
            System.out.println("\nBarang baru berhasil ditambahkan!");
        } else {
            System.out.println("\n! Mohon maaf, jumlah barang melebihi batas !");
        }
    }

    //CASE 1 MENU USER
    public static void ProsesPemesananGedung() {
        Scanner input = new Scanner(System.in);
        boolean pilihanGedung = true;
        while (pilihanGedung) {
            System.out.println("\n,--------------------------------------------------------<");
            System.out.println("|               Daftar Gedung yang tersedia!             |");
            System.out.println("|________________________________________________________|");
            System.out.printf("| %-3s | %-18s | %-14s | %-10s |\n", "No.", "Nama Gedung", "Harga Sewa", "Maks Tamu");
            System.out.println("|-----|--------------------|----------------|------------|");
            for (int i = 0; i < jumlahGedung; i++) {
                System.out.printf("| %-3d | %-18s | %-14s | %-10s |\n", (i + 1), namaGedung[i], "Rp." + daftarHargaGedung[i],
                tamuGedung[i]);
            }
            System.out.println("|_____|____________________|________________|___________/.");
            System.out.print("||> Masukkan Pilihan Anda: ");
            pilihGedung = input.nextInt();
            if (pilihGedung < 1 || pilihGedung > jumlahGedung) {
                System.out.println("\n.-------------------------------------------.");
                System.out.println("!   Mohon masukkan Angka antara 1 dan 2     !");
                System.out.println("!.-----------------------------------------.!");
                pilihanGedung=true;
            } else {
                pilihanGedung=false;
            }
        }
        for (int i = 0; i < jumlahGedung; i++){
            if (pilihGedung == (i+pilihGedung)) {
                if (stokGedung[pilihGedung-1]>0) {
                    totalGedung ="\n-> "+namaGedung[pilihGedung-1];
                    cetakGedung[jumlahHistori] = totalGedung;
                    do {
                        System.out.print("||> Masukkan Jumlah Tamu: ");
                        jumlahTamu = input.nextInt();
                        if (jumlahTamu <1 || jumlahTamu > tamuGedung[pilihGedung-1]) {
                            System.out.println("----------------------------------------------------");
                            System.out.println("! Mohon masukkan jumlah tamu antara 1 dan "+tamuGedung[pilihGedung-1]+" !");
                        } else {
                            cetakStokGedung[jumlahHistori] = stokGedung[pilihGedung-1];
                            tamuPemesan[jumlahHistori]=jumlahTamu;
                            BarangTambahan();
                            pilihanGedung=false;
                        }
                    } while (jumlahTamu < 1 || jumlahTamu > tamuGedung[pilihGedung-1]);
                }
            }
        }
        if (stokGedung[pilihGedung-1]<=0){
            System.out.println("\n! Gedung telah disewakan !");
            pilihanGedung=false;
            pilihanUser=true;
        }
        if (stokGedung[pilihGedung-1]>0){
            InputDataPengguna();                             
            PilihanMember();                                
            PilihMetodeBayar();
            cetakStruk();
            for (int i = 0; i < jumlahGedung; i++) {
                if (pilihGedung == (i+pilihGedung)) {
                    stokGedung[pilihGedung-1] -= 1;
                }
            }
        }
    }

    //FUNGSI PROSES HITUNG BARANG TAMBAHAN BERDASARKAN JUMLAH TAMU
    public static void BarangTambahan() {
        int jumlahPesananMeja=jumlahTamu;
        if (jumlahPesananMeja <= stokBarang[0]) {
            totalBarang="\n-> "+namaBarang[0]+"           : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            
            stokBarang[0] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Meja tidak mencukupi untuk pesanan tersebut !");
        }
        int jumlahPesananKursi=jumlahTamu;
        if (jumlahPesananKursi <= stokBarang[1]) {
            totalBarang+="\n-> "+namaBarang[1]+"          : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[1] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Kursi tidak mencukupi untuk pesanan tersebut !");
        }
        int jumlahPesananPiring=jumlahTamu;
        if (jumlahPesananPiring <= stokBarang[2]) {
            totalBarang+="\n-> "+namaBarang[2]+"         : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[2] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Piring tidak mencukupi untuk pesanan tersebut !");
        }
        int jumlahPesananSendok=jumlahTamu;
        if (jumlahPesananSendok <= stokBarang[3]) {
            totalBarang+="\n-> "+namaBarang[3]+"         : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[3] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Sendok tidak mencukupi untuk pesanan tersebut !");
        }
        int jumlahPesananGarpu=jumlahTamu;
        if (jumlahPesananGarpu <= stokBarang[4]) {
            totalBarang+="\n-> "+namaBarang[4]+"          : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[4] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Garpu tidak mencukupi untuk pesanan tersebut !");
        }
        cetakBarang[jumlahHistori]=jumlahTotalBarang;
    }

    //FUNGSI UNTUK MEMASUKKAN DATA DIRI USER
    public static void InputDataPengguna() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan Nama Anda: ");
        inputNamaPelanggan = input.nextLine();
        System.out.print("||> Masukkan No. Telepon: ");
        inputNoTelpPelanggan = input.nextLine();
        boolean inputTanggalValid = false;
        while (!inputTanggalValid) {
            System.out.print("||> Masukkan Tanggal Acara (dd/MM/yyyy): ");
            inputTanggal = input.nextLine();
            if (isValidFormat(inputTanggal, dateFormat)) {
                tanggal = dateFormat.parse(inputTanggal, new ParsePosition(0));
                if (tanggal != null && tanggal.getTime() > calendar.getTimeInMillis()) {
                    inputTanggalValid = true;
                    tampilTanggal[jumlahHistori] = inputTanggal;
                } else {
                    System.out.println("Tanggal harus lebih dari tanggal sekarang. Mohon masukkan kembali.");
                }
            } else {
                System.out.println("Format tanggal tidak valid. Mohon masukkan kembali.");
            }
        }
    }

    //FUNGSI UNTUK MEMBER YANG TERDAFTAR
    public static void PilihanMember() {
        Scanner input = new Scanner(System.in);
        String inputUserMember;
        boolean memberValid=false;
        while (!memberValid){
            System.out.println("\n----------------------------------------------------");
            System.out.print("||> Apakah Anda Member (y/t): ");
            inputUserMember = input.nextLine();
            System.out.println("----------------------------------------------------");
            if (inputUserMember.equals("y")){
                memberValid = false;
                do {
                    System.out.print("||> Masukkan Kode Member milik Anda: ");
                    String inputKodeMember = input.next();
                    System.out.println("----------------------------------------------------");
                    for (String verifMember : kodeMember) {
                        if (inputKodeMember.equals(verifMember)) {
                            for (int i = pilihGedung; i <= jumlahGedung; i++) {
                                diskon = 0.13 * hargaGedung[i-1];
                                cetakHargaMember = hargaGedung[i-1] - diskon;
                                totalBiaya=(long)cetakHargaMember;
                                tampilBiaya[jumlahHistori]=totalBiaya;
                            }
                            memberValid=true;
                            break;
                        } 
                    }
                    if (!memberValid) {
                        System.out.println("\n! Kode verifikasi Salah. Silahkan coba lagi !");
                        memberValid=false;
                    }
                } while (!memberValid);
            } else if (inputUserMember.equals("t")){
                for (int i = pilihGedung; i <= jumlahGedung; i++) {
                    diskon = 0 * totalTarif;
                    cetakHargaMember = hargaGedung[i-1] - diskon;
                    totalBiaya=(long)cetakHargaMember;
                    tampilBiaya[jumlahHistori]=totalBiaya;
                    memberValid=true;
                }
            }
        }
    }

    //FUNGSI UNTUK MEMILIH METODE PEMBAYARAN
    public static void PilihMetodeBayar() {
        Scanner input = new Scanner(System.in);
        int inputMetodePembayaran;
        String metodePembayaran1 = "", metodePembayaran2 = "", metodePembayaran3 = "",
               metodePembayaran4 = "", metodePembayaran5 = "", metodePembayaran6 = "";
        boolean metodeBayar = true;
        while (metodeBayar) {
            do {
                System.out.println("\n,------------------------------------------------------------<");
                System.out.println("|                      METODE PEMBAYARAN!                    |");
                System.out.println("|____________________________________________________________|");
                System.out.println("| No.| VIA        | No.Rek/No.telp | Atas nama               |");
                System.out.println("|----|------------|----------------|-------------------------|");
                System.out.println("| 1. | BRI        | 2341760195     | Gerly Vaeyungfan        |");
                System.out.println("| 2. | BNI        | 2341760043     | Aprilia Putri Anggraeni |");
                System.out.println("| 3. | BCA        | 2341760068     | Jaden Natha Kautsar     |");
                System.out.println("| 4. | DANA       | 081547207512   | Gerly Vaeyungfan        |");
                System.out.println("| 5. | ShopeePay  | 085755742091   | Aprilia Putri Anggraeni |");
                System.out.println("| 6. | LinkAja    | 085810393753   | Jaden Natha Kautsar     |");
                System.out.println("|____|____________|________________|________________________/.");
                System.out.print("||> Pilih Metode Pembayaran: ");
                inputMetodePembayaran = input.nextInt();
                metodeBayar=false;
                if (inputMetodePembayaran==1) {
                    metodePembayaran1 += "BRI";
                    totalMetodePembayaran = metodePembayaran1;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                } else if (inputMetodePembayaran==2) {
                    metodePembayaran2 += "BNI";
                    totalMetodePembayaran = metodePembayaran2;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                } else if (inputMetodePembayaran==3) {
                    metodePembayaran3 += "BCA";
                    totalMetodePembayaran = metodePembayaran3;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                } else if (inputMetodePembayaran==4) {
                    metodePembayaran4 += "DANA";
                    totalMetodePembayaran = metodePembayaran4;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                } else if (inputMetodePembayaran==5) {
                    metodePembayaran5 += "ShopeePay";
                    totalMetodePembayaran = metodePembayaran5;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                } else if (inputMetodePembayaran==6) {
                    metodePembayaran6 += "LinkAja";
                    totalMetodePembayaran = metodePembayaran6;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                    cekApakahKodeValid();
                }

                if (jumlahHistori < 100) {
                    namaPelanggan[jumlahHistori] = inputNamaPelanggan;
                    noTelpPelanggan[jumlahHistori] = inputNoTelpPelanggan;
                    tampilTanggal[jumlahHistori] = inputTanggal;
                    tamuPemesan[jumlahHistori] = jumlahTamu;
                    cetakGedung[jumlahHistori] = totalGedung;
                    cetakBarang[jumlahHistori] = totalBarang;
                    tampilBiaya[jumlahHistori] = totalBiaya;
                    cetakMetodePembayaran[jumlahHistori] = totalMetodePembayaran;
                    jumlahHistori++;
                }

                if (inputMetodePembayaran < 1 || inputMetodePembayaran > 6) {
                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 6 !");
                }
            } while (inputMetodePembayaran < 1 || inputMetodePembayaran > 6);
        }
    }

    //FUNGSI UNTUK CEK APAKAH KODE VERIFIKASI VALID
    public static void cekApakahKodeValid() {
        boolean jikaKodeValid = false;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\n.-----------------------------------------.");
            System.out.println("|                                         |");
            System.out.println("|  KODE VERIFIKASI DIKIRIM MELALUI SMS!   |");
            System.out.println("|                                         |");
            System.out.println("|.----------------------------------------'");
            System.out.print("\n||> Masukkan kode verifikasi: ");
            String inputKodeVerifikasi = input.next();
            System.out.println("----------------------------------------------------");
            jikaKodeValid = false;
            for (String kode : kodeVerifikasi) {
                if (inputKodeVerifikasi.equals(kode)) {
                    jikaKodeValid = true;
                    break;
                }
            }
            if (!jikaKodeValid) {
                System.out.println("\n! Kode verifikasi Salah. Silahkan coba lagi !");
            }
        } while (!jikaKodeValid);
    }
    
    //CASE 6 MENU ADMIN
    public static void LaporanPendapatan(Date currentDate) {
        System.out.println("\n======================================================");
        System.out.println("             LAPORAN HARIAN DAN BULANAN");
        System.out.println("\nTanggal: " + dateFormat.format(currentDate));
        System.out.println("======================================================");
        for (int i = 0; i < jumlahHistori; i++) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("Tanggal Acara     : " + tampilTanggal[i]);
            System.out.println("Gedung Yang Disewa" + cetakGedung[i]);
            System.out.println("Barang Yang Telah Tersewa"+cetakBarang[i]);
            System.out.println("Metode Pembayaran : "+cetakMetodePembayaran[i]);
            System.out.println("----------------------------------------------------");
            System.out.println("PENDAPATAN HARIAN : Rp." + tampilBiaya[i]);
            System.out.println("----------------------------------------------------");
            totalPendapatanBulanan += tampilBiaya[i];
        }
        System.out.println("\n====================================================");
        System.out.println("TOTAL PENDAPATAN BULANAN : Rp." + totalPendapatanBulanan);
        System.out.println("====================================================");
    }

    //CASE 7 MENU ADMIN
    public static void LihatHistoriPemesanan() {
        System.out.println("\n-----------------------------------");
        System.out.println("Jumlah Histori : " + jumlahHistori);
        System.out.println("Daftar Histori Pelanggan:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahHistori; i++) {
            System.out.println("Histori ke-" + (i + 1));
            System.out.println("Tanggal           : " + tampilTanggal[i]);
            System.out.println("Atas nama         : " + namaPelanggan[i]);
            System.out.println("No.Telp           : " + noTelpPelanggan[i]);
            System.out.println("Nama Gedung       : " + cetakGedung[i]);
            System.out.println("Nama Barang       : " + cetakBarang[i]);
            System.out.println("Metode Pembayaran : " + cetakMetodePembayaran[i]);
            System.out.println("-----------------------------------");
        }
    }

    //CASE 8 MENU ADMIN
    public static void lihatDataAdmin(){
        System.out.println("\n-----------------------------------");
        System.out.println("Jumlah Admin : " + jumlahAdmin);
        System.out.println("Akun Admin yang telah terdaftar :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahAdmin; i++) {
            System.out.println("Admin ke-" + (i + 1));
            System.out.println("Username : " + regUsernameAdmin[i]);
            System.out.println("Password : " + regPasswordAdmin[i]);
            System.out.println("-----------------------------------");
        }
    }

    //CASE 9 MENU ADMIN
    public static void lihatDataKasir(){
        System.out.println("\n-----------------------------------");
        System.out.println("Jumlah Kasir : " + jumlahKasir);
        System.out.println("Akun Kasir yang telah terdaftar :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahKasir; i++) {
            System.out.println("Kasir ke-" + (i + 1));
            System.out.println("Username : " + regUsernameKasir[i]);
            System.out.println("Password : " + regPasswordKasir[i]);
            System.out.println("-----------------------------------");
        }
    }

    //CASE 10 MENU ADMIN
    public static void LihatDataUser(){
        System.out.println("\n-----------------------------------");
        System.out.println("Jumlah User : " + jumlahUser);
        System.out.println("Akun User yang telah terdaftar :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahUser; i++) {
            System.out.println("User ke-" + (i + 1));
            System.out.println("Username : " + regUsernameUser[i]);
            System.out.println("Password : " + regPasswordUser[i]);
            System.out.println("-----------------------------------");
        }
    }

    //CASE 11 MENU ADMIN
    public static void tambahAkunAdmin() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan username baru: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan password baru: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahAdmin < regUsernameAdmin.length && jumlahAdmin < regPasswordAdmin.length) {
            regUsernameAdmin[jumlahAdmin] = inputUserBaru;
            regPasswordAdmin[jumlahAdmin] = inputPwBaru;
            jumlahAdmin++;
            System.out.println("\n-.......................................-");
            System.out.println("   ! USER ADMIN BERHASIL DITAMBAHKAN !   ");
            System.out.println("-.......................................-\n");
        } else {
            System.out.println("\nMohon maaf, jumlah admin melebihi batas.");
        }
    }

    //CASE 12 MENU ADMIN
    public static void tambahAkunKasir() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan username baru: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Masukkan password baru: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahKasir < regUsernameKasir.length && jumlahKasir < regPasswordKasir.length) {
            regUsernameKasir[jumlahKasir] = inputUserBaru;
            regPasswordKasir[jumlahKasir] = inputPwBaru;
            jumlahKasir++;
            System.out.println("\n-.......................................-");
            System.out.println("   ! USER KASIR BERHASIL DITAMBAHKAN !   ");
            System.out.println("-.......................................-\n");
        } else {
            System.out.println("\nMohon maaf, jumlah kasir melebihi batas.");
        }
    }
}