import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProyekBookingGedung {
    
    static int jumlahTamu, stepLogin, menuGedung, inputMetodePembayaran, menuAdmin, menuMember, menuKasir, index, indexKasir,
               jumlahPesananMeja, jumlahPesananKursi, jumlahPesananPiring, 
               jumlahPesananSendok, jumlahPesananGarpu, tambahanStok, indexUser, indexAdmin, pilihGedung, totalPesanMeja=0,
               totalPesanKursi=0, totalPesanPiring=0, totalPesanSendok=0, totalPesanGarpu=0,
               jumlahBarang = 0, jumlahGedung = 0, jumlahUser = 0, jumlahAdmin = 0, jumlahKasir = 0, tambahStokGedung,
               jumlahData=0;
    static long tarif = 0, totalPendapatanBulanan = 0,
                hargaGedung1, hargaGedung2, hargaGedung3, hargaGedung4, totalBiaya, cetakHargaGedung1, cetakHargaGedung2,
                cetakHargaGedung3, cetakHargaGedung4;
    static double totalTarifGedung1 = 0, totalTarifGedung2 = 0, totalTarifGedung3 = 0, totalTarifGedung4 = 0,
                   diskon, cetakHargaMember, totalTarifMember;
    static String inputPesanLagi, inputUserMember, inputNamaPelanggan, inputNoTelpPelanggan, targetBarang, akun, 
                  inputUserAdmin, inputPwAdmin, inputUser, inputPwUser, inputKodeVerif, totalGedung="", totalBarang="",
                  inputUserKasir, inputPwKasir, targetGedung, targetNamaBarang, inputTanggal, jumlahTotalBarang="",
                  metodePembayaran1="", metodePembayaran2="",metodePembayaran3="",metodePembayaran4="",metodePembayaran5="",
                  metodePembayaran6="", totalMetodePembayaran="";
    static boolean pilihMenu, regUsernameAdminValid, pilihanAdmin, userTerdaftar, penggunaValid, ketemu,
                   pilihMember, pilihBarang, langkahSelanjutnya, sewaBarangLagi, metodeBayar, inputTanggalValid,
                   jikaKodeValid, memberValid, jikaBarangDitemukan, jikaGedungDitemukan,
                   jikaGedungTersedia, jikaBarangTersedia, regUsernameKasirValid, pilihanKasir, pilihanGedung;

    static String[] namaPelanggan = new String[100];
    static String[] noTelpPelanggan = new String[100];
    private static String [] tampilTanggal = new String[100];
    static String[] cetakGedung = new String[100];
    static String[] cetakBarang = new String[100];
    static int [] cetakStokGedung = new int[100];
    static int [] tamuPemesan = new int[100];
    static long [] tampilBiaya = new long[100];
    static String[] cetakMetodePembayaran= new String[100];

    static int jumlahHistori = 0;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static Date tanggal = null;

    static boolean isValidFormat(String value, SimpleDateFormat dateFormat) {
        dateFormat.setLenient(false);
        Date parsedDate = dateFormat.parse(value, new ParsePosition(0));
        return parsedDate != null;
    }
    
    static String menuMetodeBayar[] = {"BRI", "BNI", "BCA", "DANA", "GoPay", "LinkAja"};
    static String kodeVerif[] = { "01234", "12345", "23456", "34567", "45678", "56789", "67890" };
    static String kodeMember[] = {"a1b2c3", "12ab34cd", "01000001", "01000111", "01001010"};

    static String[] namaBarang = new String[100];
    static int[] stokBarang = new int[100];

    static String[] namaGedung = new String[100];
    static int[] stokGedung = new int[100];
    
    static String[] regUsernameAdmin = new String[100];
    static String[] regPasswordAdmin = new String[100];

    static String[] regUsernameKasir = new String[100];
    static String[] regPasswordKasir = new String[100];

    static String[] regUsernameUser = new String[100];
    static String[] regPasswordUser = new String[100];

    public static void LihatHistoriPemesanan() {
        System.out.println("\n-----------------------------------");
        System.out.println("Jumlah Histori : " + jumlahHistori);
        System.out.println("Daftar Histori Pelanggan:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahHistori; i++) {
            System.out.println("Histori ke-" + (i + 1));
            System.out.println("Tanggal           : "+ tampilTanggal[i]);
            System.out.println("Atas nama         : " + namaPelanggan[i]);
            System.out.println("No.Telp           : " + noTelpPelanggan[i]);
            System.out.println("Nama Gedung       : " + cetakGedung[i]);
            System.out.println("Nama Barang       : " + cetakBarang[i]);
            System.out.println("Metode Pembayaran : " + cetakMetodePembayaran[i]);
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        regUsernameAdmin[jumlahAdmin] = "april";
        regPasswordAdmin[jumlahAdmin]= "111";
        jumlahAdmin++;
        regUsernameAdmin[jumlahAdmin] = "gerly";
        regPasswordAdmin[jumlahAdmin]= "222";
        jumlahAdmin++;
        regUsernameAdmin[jumlahAdmin] = "jaden";
        regPasswordAdmin[jumlahAdmin]= "333";
        jumlahAdmin++;

        regUsernameKasir[jumlahKasir] = "april";
        regPasswordKasir[jumlahKasir]= "000";
        jumlahKasir++;
        regUsernameKasir[jumlahKasir] = "gerly";
        regPasswordKasir[jumlahKasir]= "000";
        jumlahKasir++;
        regUsernameKasir[jumlahKasir] = "jaden";
        regPasswordKasir[jumlahKasir]= "000";
        jumlahKasir++;

        regUsernameUser[jumlahUser] = "april";
        regPasswordUser[jumlahUser] = "12345";
        jumlahUser++;
        regUsernameUser[jumlahUser] = "gerly";
        regPasswordUser[jumlahUser] = "12345";
        jumlahUser++;
        regUsernameUser[jumlahUser] = "jaden";
        regPasswordUser[jumlahUser] = "12345";
        jumlahUser++;

        namaGedung[jumlahGedung] = " PERNIKAHAN";
        stokGedung[jumlahGedung] = 10;
        jumlahGedung++;
        namaGedung[jumlahGedung] = " AUDITORIUM";
        stokGedung[jumlahGedung] = 10;
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

        do {
            System.out.println("\n T-.___________________________________________________.-T");
            System.out.println(" ||                                                     ||");
            System.out.println(" ||   SELAMAT DATANG DI WEBSITE BOOKING GEDUNG SOEHAT   ||");
            System.out.println(" ||                                                     ||");
            System.out.println("<||.---------------------------------------------------.||>");
            boolean pilihMenu = true;
            while (pilihMenu) {
                do {
                    System.out.println("\n,-------------------------------------<");
                    System.out.println("|              DAFTAR MENU            |");
                    System.out.println("|-------------------------------------|");
                    System.out.println("|   1. Login Admin                    |");
                    System.out.println("|   2. Login Kasir                    |");
                    System.out.println("|   3. Login User                     |");
                    System.out.println("|   4. Daftar Akun User Baru          |");
                    System.out.println("|   5. Pengecekan Gedung Tersedia     |");
                    System.out.println("|   6. Pengecekan Barang Tersedia     |");
                    System.out.println("|   7. Keluar                         |");
                    System.out.println("|_____________________________________/.");
                    System.out.print("||> Masukkan Pilihan Anda: ");
                    stepLogin = input.nextInt();
                    if (stepLogin < 1 || stepLogin > 7) {
                        System.out.println("\n! Mohon masukkan nomor antara 1 dan 7 !");
                    }
                } while (stepLogin < 1 || stepLogin > 7);
                if (stepLogin == 1) {
                    do {
                        System.out.println("\n---------------------------------------------------");
                        System.out.print("||> Masukkan username: ");
                        inputUserAdmin = input.next();
                        System.out.println("---------------------------------------------------");
                        System.out.print("||> Masukkan password: ");
                        inputPwAdmin = input.next();
                        System.out.println("---------------------------------------------------");
                        regUsernameAdminValid = false;
                        indexAdmin = -1;
                        for (int i = 0; i < jumlahAdmin; i++) {
                            if (inputUserAdmin.equals(regUsernameAdmin[i]) && inputPwAdmin.equals(regPasswordAdmin[i])) {
                                regUsernameAdminValid = true;
                                indexAdmin = i;
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
                            System.out.println("\n,----------------------------------<");
                            System.out.println("|            MENU ADMIN            |");
                            System.out.println("|----------------------------------|");
                            System.out.println("|   1. Pencarian Admin Terdaftar   |");
                            System.out.println("|   2. Pencarian Kasir Terdaftar   |");
                            System.out.println("|   3. Pencarian User Terdaftar    |");
                            System.out.println("|   4. Lihat Sisa Stok Gedung      |");
                            System.out.println("|   5. Lihat Sisa Stok Barang      |");
                            System.out.println("|   6. Lihat Data Admin            |");
                            System.out.println("|   7. Lihat Data Kasir            |");
                            System.out.println("|   8. Lihat Data User             |");
                            System.out.println("|   9. Tambah Akun Admin Baru      |");
                            System.out.println("|   10. Tambah Akun Kasir Baru     |");
                            System.out.println("|   11. Lihat Laporan Pendapatan   |");
                            System.out.println("|   12. Lihat Histori Pemesanan    |");
                            System.out.println("|   13. Keluar                     |");
                            System.out.println("|_________________________________/.");
                            System.out.print("||> Masukkan Pilihan Anda: ");
                            menuAdmin = input.nextInt();
                            if (menuAdmin < 1 || menuAdmin > 13) {
                                System.out.println("\n! Mohon masukkan nomor antara 1 dan 13 !");
                            }
                        } while (menuAdmin < 1 || menuAdmin > 13);
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
                                tampilkanStokGedung();
                                break;
                            case 5:
                                tampilkanStokBarang();
                                break;
                            case 6:
                                lihatDataAdmin();
                                break;
                            case 7:
                                lihatDataKasir();
                                break;
                            case 8:
                                LihatDataUser();
                                break;
                            case 9:
                                tambahAkunAdmin();
                                break;
                            case 10:
                                tambahAkunKasir();
                                break;
                            case 11: 
                                LaporanPendapatan(new Date());
                                break;
                            case 12:
                                LihatHistoriPemesanan();
                                break;
                            case 13:
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
                        inputUserKasir = input.next();
                        System.out.println("---------------------------------------------------");
                        System.out.print("||> Masukkan password: ");
                        inputPwKasir = input.next();
                        System.out.println("---------------------------------------------------");
                        regUsernameKasirValid = false;
                        indexKasir = -1;
                        for (int i = 0; i < jumlahKasir; i++) {
                            if (inputUserKasir.equals(regUsernameKasir[i]) && inputPwKasir.equals(regPasswordKasir[i])) {
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
                            System.out.println("\n,----------------------------------<");
                            System.out.println("|            MENU KASIR            |");
                            System.out.println("|----------------------------------|");
                            System.out.println("|   1. Cetak Struk Pemesanan       |");
                            System.out.println("|   2. Lihat Sisa Stok Gedung      |");
                            System.out.println("|   3. Tambah Stok Gedung          |");
                            System.out.println("|   4. Tambah Gedung Baru          |");
                            System.out.println("|   5. Lihat Sisa Stok Barang      |");
                            System.out.println("|   6. Tambah Stok Barang          |");
                            System.out.println("|   7. Tambah Barang Baru          |");
                            System.out.println("|   8. Keluar                      |");
                            System.out.println("|_________________________________/.");
                            System.out.print("||> Masukkan Pilihan Anda: ");
                            menuKasir = input.nextInt();
                            if (menuKasir < 1 || menuKasir > 8) {
                                System.out.println("\n! Mohon masukkan nomor antara 1 dan 8 !");
                            }
                        } while (menuKasir < 1 || menuKasir > 8);
                        switch (menuKasir) {
                            case 1:
                                cetakStruk();
                              break;
                            case 2:
                                tampilkanStokGedung();
                                break;
                            case 3:
                                tambahkanStokGedung(targetGedung, tambahStokGedung);
                                break;
                            case 4:
                                tambahGedung();
                                break;
                            case 5:
                                tampilkanStokBarang();
                                break;
                            case 6:
                                tambahkanStokBarang(targetBarang, tambahanStok);
                                break;
                            case 7:
                                tambahBarang();
                                break;
                            case 8:
                                pilihMenu = true;
                                pilihanKasir = false;
                                break;
                        }
                    }
                } else if (stepLogin == 3) {
                    boolean penggunaValid;
                    do {
                        System.out.println("\n---------------------------------------------------");
                        System.out.print("||> Masukkan username: ");
                        inputUser = input.next();
                        System.out.println("---------------------------------------------------");
                        System.out.print("||> Masukkan password: ");
                        inputPwUser = input.next();
                        System.out.println("---------------------------------------------------");
                        penggunaValid = false;
                        indexUser = -1;
                        for (int i = 0; i < jumlahUser; i++) {
                            if (inputUser.equals(regUsernameUser[i]) && inputPwUser.equals(regPasswordUser[i])) {
                                penggunaValid = true;
                                indexUser = i;
                                break;
                            }
                        }
                        if (penggunaValid) {
                            System.out.println("\n-...................................-");
                            System.out.println("          ! LOGIN BERHASIL !         ");
                            System.out.println("       SELAMAT DATANG, USER :)       ");
                            System.out.println("-...................................-");
                        } else {
                            System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                        }
                    } while (!penggunaValid);
                    boolean pilihMember = true;
                    while (pilihMember) {
                        do {
                            System.out.println("\n,---------------------------------<");
                            System.out.println("|            MENU USER            |");
                            System.out.println("|---------------------------------|");
                            System.out.println("|   1. Pesan Gedung Sekarang      |");
                            System.out.println("|   2. Lihat Sisa Stok Gedung     |");
                            System.out.println("|   3. Keluar                     |");
                            System.out.println("|________________________________/.");
                            System.out.print("||> Masukkan Pilihan Anda: ");
                            menuMember = input.nextInt();
                            if (menuMember < 1 || menuMember > 3) {
                                System.out.println("\n! Mohon masukkan nomor antara 1 dan 3 !");
                            }
                            switch (menuMember) {
                                case 1:
                                    ProsesPemesananGedung();
                                    cetakStruk();
                                    break;
                                case 2:
                                    tampilkanStokGedung();
                                    break;
                                case 3:
                                    pilihMenu = true;
                                    pilihMember = false;
                                    break;
                            }
                        } while (menuMember < 1 || menuMember > 3);
                    }
                } else if (stepLogin == 4){
                    tambahAkunUser();
                } else if (stepLogin == 5) {
                    searchNamaGedung(targetGedung);
                } else if (stepLogin == 6) {
                    cariNamaBarang(targetNamaBarang);
                } else if (stepLogin == 7) {
                    pilihMenu = false;
                    System.exit(0);
                }
            }
        } while (!akun.equalsIgnoreCase("y") || !akun.equalsIgnoreCase("t"));
    }

    public static void PencarianAdminTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("/n----------------------------------------------------");
        System.out.print("||> Masukkan username admin: ");
        String targetAdmin = input.next();
        System.out.println("----------------------------------------------------");
        boolean adminTerdaftar = false;
        for (int i = 0; i < jumlahUser; i++) {
            if (regUsernameUser[i].equals(targetAdmin)) {
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

    public static void PencarianKasirTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("/n----------------------------------------------------");
        System.out.print("||> Masukkan username kasir: ");
        String targetKasir = input.next();
        System.out.println("----------------------------------------------------");
        boolean kasirTerdaftar = false;
        for (int i = 0; i < jumlahUser; i++) {
            if (regUsernameUser[i].equals(targetKasir)) {
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

    public static void tampilkanStokGedung() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Sisa Stok Gedung :");
        for (int i = 0; i < jumlahGedung; i++) {
            System.out.println((i + 1) + ". " + namaGedung[i] + "\t: " + stokGedung[i]);
        }
        System.out.println("----------------------------------------------------");
    }
    
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
            pilihMember = true;
    }

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

    public static void searchNamaGedung(String targetGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
                    System.out.print("||> Masukkan nama gedung: ");
                    targetGedung = input.next();
                    System.out.println("----------------------------------------------------");
        boolean jikaGedungDitemukan = false;
        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetGedung)) {
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

    public static void tambahkanStokGedung(String targetGedung, int tambahStokGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Masukkan nama gedung: ");
        targetGedung = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan tambahan stok: ");
        tambahStokGedung = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaGedungTersedia = false;
        int indeks = -1;
        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetGedung)) {
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

    public static void tambahkanStokBarang(String targetBarang, int tambahanStok) {
        Scanner input = new Scanner(System.in);
        System.out.print("||> Masukkan nama barang: ");
        targetBarang = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan tambahan stok: ");
        tambahanStok = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaBarangTersedia = false;
        index = -1;
        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetBarang)) {
                jikaBarangTersedia = true;
                index = i;
                break;
            }
        }
        if (jikaBarangTersedia) {
            stokBarang[index] += tambahanStok;
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Stok Barang Ditambahkan !    !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Nama Barang: " + namaBarang[index]);
            System.out.println("  Stok Tersedia Sekarang: " + stokBarang[index]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Barang Tidak Tersedia !      !");
            System.out.println("!.---------------------------------!");
        }
    }

    public static void tambahGedung() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("Masukkan Nama Gedung Baru: ");
        String namaGedungBaru = input.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.print("Masukkan Stok Gedung Baru: ");
        int stokGedungBaru = input.nextInt();
        System.out.println("----------------------------------------------------");
        if (jumlahGedung < namaGedung.length && jumlahGedung < stokGedung.length) {
            namaGedung[jumlahGedung] = namaGedungBaru;
            stokGedung[jumlahGedung] = stokGedungBaru;
            jumlahGedung++;
            System.out.println("\nGedung baru berhasil ditambahkan!");
        } else {
            System.out.println("\n! Mohon maaf, jumlah gedung melebihi batas !");
        }
    }
    
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

    public static void cekStokBarang(String targetBarang) {
        boolean jikaBarangTersedia = false;
        int index = -1;
        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetBarang)) {
                jikaBarangTersedia = true;
                index = i;
                break;
            }
        }
        if (jikaBarangTersedia) {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Barang Tersedia !            !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Nama Barang: " + namaBarang[index]);
            System.out.println("  Stok Tersedia: " + stokBarang[index]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Barang Tidak Tersedia !      !");
            System.out.println("!.----------------------------------!");
        }
    }

    public static void ProsesPemesananGedung() {
        Scanner input = new Scanner(System.in);
        pilihanGedung = true;
        while (pilihanGedung) {
            System.out.println("\n,-----------------------------------------------------------<");
            System.out.println("|                 Daftar Gedung yang tersedia!              |");
            System.out.println("|___________________________________________________________|");
            System.out.println("| No. | Nama Gedung | Harga Sewa   | Maks Tamu | Tarif Tamu |");
            System.out.println("|-----|-------------|--------------|-----------|------------|");
            System.out.println("| 1.  | Pernikahan  | Rp.50000000  | 5000      | Rp.500000  |");
            System.out.println("| 2.  | Auditorium  | Rp.20000000  | 2000      | Rp.200000  |");
            System.out.println("|_____|_____________|______________|___________|___________/.");
            System.out.print("||> Masukkan Pilihan Anda: ");
            pilihGedung = input.nextInt();
            if (pilihGedung < 1 || pilihGedung > 2) {
                System.out.println("\n.-------------------------------------------.");
                System.out.println("!   Mohon masukkan Angka antara 1 dan 2     !");
                System.out.println("!.-----------------------------------------.!");
                pilihanGedung=true;
            } else {
                pilihanGedung=false;
            }
        }
        if (pilihGedung == 1) {
            if (stokGedung[0]>0) {
                totalGedung ="\n-> "+namaGedung[0];
                cetakGedung[jumlahHistori] = totalGedung;
                hargaGedung1=50000000;
                totalTarifGedung1+=hargaGedung1;
                cetakHargaGedung1 = (long)totalTarifGedung1;
                do {
                    System.out.print("||> Masukkan Jumlah Tamu: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 5000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Mohon masukkan jumlah tamu antara 1 dan "+stokGedung[0] +"!");
                    } else {
                        stokGedung[0] -= jumlahTamu;
                        cetakStokGedung[jumlahHistori] = stokGedung[0];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        tarif = jumlahTamu * 500000;
                        totalTarifGedung1 += tarif;
                        cetakHargaGedung1+=totalTarifGedung1;
                        totalBiaya = cetakHargaGedung1;
                        tampilBiaya[jumlahHistori] = totalBiaya;
                        BarangTambahan();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 5000);
            } else {
                System.out.println("Gedung telah disewakan");
                    pilihanGedung=false;
            }
        } else if (pilihGedung == 2){
            if (stokGedung[1]>0) {
                totalGedung ="\n-> "+namaGedung[1];
                cetakGedung[jumlahHistori] = totalGedung;
                hargaGedung2=20000000;
                totalTarifGedung2+=hargaGedung2;
                cetakHargaGedung2 = (long)totalTarifGedung2;
                do {
                    System.out.print("||> Masukkan Jumlah Tamu: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 2000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Mohon masukkan jumlah tamu antara 1 dan "+stokGedung[1] +"!");
                    } else {
                        stokGedung[1] -= jumlahTamu;
                        cetakStokGedung[jumlahHistori] = stokGedung[1];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        tarif = jumlahTamu * 200000;
                        totalTarifGedung2 += tarif;
                        cetakHargaGedung2+=totalTarifGedung2;
                        totalBiaya = cetakHargaGedung2;
                        tampilBiaya[jumlahHistori] = totalBiaya;
                        BarangTambahan();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 2000);
            } else {
                System.out.println("Gedung telah disewakan");
                pilihanGedung=false;
            }
        }
        InputDataPengguna();                             
        PilihanMember();                                
        PilihMetodeBayar();
    }

    public static void BarangTambahan() {
        jumlahPesananMeja=jumlahTamu;
        if (jumlahPesananMeja <= stokBarang[0]) {
            totalBarang="\n-> "+namaBarang[0]+"           : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            
            stokBarang[0] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Meja tidak mencukupi untuk pesanan tersebut !");
        }
        jumlahPesananKursi=jumlahTamu;
        if (jumlahPesananKursi <= stokBarang[1]) {
            totalBarang+="\n-> "+namaBarang[1]+"          : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[1] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Kursi tidak mencukupi untuk pesanan tersebut !");
        }
        jumlahPesananPiring=jumlahTamu;
        if (jumlahPesananPiring <= stokBarang[2]) {
            totalBarang+="\n-> "+namaBarang[2]+"         : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[2] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Piring tidak mencukupi untuk pesanan tersebut !");
        }
        jumlahPesananSendok=jumlahTamu;
        if (jumlahPesananSendok <= stokBarang[3]) {
            totalBarang+="\n-> "+namaBarang[3]+"         : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[3] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Sendok tidak mencukupi untuk pesanan tersebut !");
        }
        jumlahPesananGarpu=jumlahTamu;
        if (jumlahPesananGarpu <= stokBarang[4]) {
            totalBarang+="\n-> "+namaBarang[4]+"          : "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            stokBarang[4] -= jumlahTamu;
        } else {
            System.out.println("\n! Stok Garpu tidak mencukupi untuk pesanan tersebut !");
        }
        cetakBarang[jumlahHistori]=jumlahTotalBarang;
    }

    public static void InputDataPengguna() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.print("||> Masukkan Nama Anda: ");
        inputNamaPelanggan = input.nextLine();
        System.out.print("||> Masukkan No. Telepon: ");
        inputNoTelpPelanggan = input.nextLine();
        inputTanggalValid = false;
        while (!inputTanggalValid) {
            System.out.print("||> Masukkan Tanggal Acara (dd/MM/yyyy): ");
            inputTanggal = input.nextLine();
            if (isValidFormat(inputTanggal, dateFormat)) {
                tanggal = dateFormat.parse(inputTanggal, new ParsePosition(0));
                if (tanggal != null && tanggal.getTime() > 0) {
                    inputTanggalValid = true;
                    tampilTanggal[jumlahHistori] = inputTanggal;
                }
            } else {
                System.out.println("Format tanggal tidak valid. Mohon masukkan kembali.");
            }
        }
    }

    
    private static void LaporanPendapatan(Date currentDate) {
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

    public static void PilihMetodeBayar() {
        Scanner input = new Scanner(System.in);
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
                } else if (inputMetodePembayaran==2) {
                    metodePembayaran2 += "BNI";
                    totalMetodePembayaran = metodePembayaran2;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                } else if (inputMetodePembayaran==3) {
                    metodePembayaran3 += "BCA";
                    totalMetodePembayaran = metodePembayaran3;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                } else if (inputMetodePembayaran==4) {
                    metodePembayaran4 += "DANA";
                    totalMetodePembayaran = metodePembayaran4;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                } else if (inputMetodePembayaran==5) {
                    metodePembayaran5 += "ShopeePay";
                    totalMetodePembayaran = metodePembayaran5;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
                } else if (inputMetodePembayaran==6) {
                    metodePembayaran6 += "LinkAja";
                    totalMetodePembayaran = metodePembayaran6;
                    cetakMetodePembayaran[jumlahHistori]=totalMetodePembayaran;
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
            switch (inputMetodePembayaran) {
                case 1:
                    cekApakahKodeValid();
                    break;
                case 2:
                    cekApakahKodeValid();
                    break;
                case 3:
                    cekApakahKodeValid();
                    break;
                case 4:
                    cekApakahKodeValid();
                    break;
                case 5:
                    cekApakahKodeValid();
                    break;
                case 6:
                    cekApakahKodeValid();
                    break;
            }
        }
    }

    public static void cekApakahKodeValid() {
        jikaKodeValid = false;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("\nKode verifikasi dikirim melalui SMS");
            System.out.println("\n----------------------------------------------------");
            System.out.print("Masukkan kode verifikasi: ");
            inputKodeVerif = input.next();
            System.out.println("----------------------------------------------------");
            jikaKodeValid = false;
            for (String kode : kodeVerif) {
                if (inputKodeVerif.equals(kode)) {
                    jikaKodeValid = true;
                    metodeBayar = false;
                    break;
                }
            }
            if (!jikaKodeValid) {
                System.out.println("\n! Kode verifikasi Salah. Silahkan coba lagi !");
            }
        } while (!jikaKodeValid);
    }

    public static void PilihanMember() {
        Scanner input = new Scanner(System.in);
        memberValid=false;
        System.out.print("||> Apakah Anda Member (y/t): ");
        inputUserMember= input.nextLine();
        if (inputUserMember.equals("y")){
            memberValid = false;
            do {
                System.out.print("||> Masukkan Kode Member milik Anda: ");
                String inputKodeMember = input.next();
                System.out.println("----------------------------------------------------");
                for (String verifMember : kodeMember) {
                    if (inputKodeMember.equals(verifMember)) {
                        diskon = 0.1 * totalTarifMember;
                        cetakHargaMember = totalTarifMember - diskon;
                        tampilBiaya[jumlahHistori]=(long) cetakHargaMember;
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
            memberValid=false;
        }
    }

    public static void cetakStruk() {
        System.out.println("\n=============================================\n");
        System.out.println("\t    BOOKING GEDUNG SOEHAT\n");
        System.out.println("==========Informasi Pemesanan Anda!==========");
        System.out.println("\nGedung Dipesan"+ cetakGedung[jumlahHistori-1]);
        System.out.println("\nAtas Nama         : " + namaPelanggan[jumlahHistori-1]);
        System.out.println("No. Telepon       : " + noTelpPelanggan[jumlahHistori-1]);
        System.out.println("Tanggal           : " + tampilTanggal[jumlahHistori-1]);
        System.out.println("Jumlah Tamu       : " + tamuPemesan[jumlahHistori-1]);
        System.out.println("\nBarang tambahan"+cetakBarang[jumlahHistori-1]);
        System.out.println("\nTotal Biaya       : Rp." + tampilBiaya[jumlahHistori-1]);
        System.out.println("--------------------------------------------");
        System.out.println("Metode Pembayaran : " + cetakMetodePembayaran[jumlahHistori-1]);
        System.out.println("--------------------------------------------");
        System.out.println("\t   Jl. Soekarno Hatta No.9");
        System.out.println("       Kel. Jatimulyo, Kec. Lowokwaru");
        System.out.println("\t       MALANG 65141");
        System.out.println("--------------------------------------------");
    }
}