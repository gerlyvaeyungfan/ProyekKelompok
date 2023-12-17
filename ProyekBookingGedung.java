import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ProyekBookingGedung {
    static int stepLogin, menuGedung, pilihGedung, jumlahTamu, menuAdmin, menuKasir, menuUser, indeksBarang, indexKasir, tambahanStokBarang,
               jumlahBarang = 0, jumlahGedung = 0, jumlahUser = 0, jumlahAdmin = 0, jumlahKasir = 0, tambahStokGedung, jumlahData=0,
               jumlahHistori=0, totalBuilding=0, totalItem = 0, bahasa;
    static long totalBiaya, totalPendapatanBulanan = 0;
    static double hargaGedung1 = 5000000, hargaGedung2 = 2000000, cetakHargaMember, diskon, totalTarif;
    static String inputNamaPelanggan, inputNoTelpPelanggan, inputTanggal, totalGedung = "", totalBarang = "", jumlahTotalBarang = "",
                  totalMetodePembayaran = "", targetNamaGedung, targetNamaBarang;
    static boolean pilihanUser;

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

    static String[] ItemName = new String[100];
    static int[] ItemStock = new int[100];

    static String[] BuildingName = new String[100];
    static int[] BuidlingStock = new int[100];
    
    static String[] regUsernameAdmin = new String[100];
    static String[] regPasswordAdmin = new String[100];

    static String[] regUsernameKasir = new String[100];
    static String[] regPasswordKasir = new String[100];

    static String[] regUsernameUser = new String[100];
    static String[] regPasswordUser = new String[100];

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

        namaGedung[jumlahGedung] = "PERNIKAHAN";
        stokGedung[jumlahGedung] = 1;
        jumlahGedung++;
        namaGedung[jumlahGedung] = "AUDITORIUM";
        stokGedung[jumlahGedung] = 1;
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

        BuildingName[totalBuilding] = "WEDDING HALL";
        BuidlingStock[totalBuilding] = 1;
        totalBuilding++;
        BuildingName[totalBuilding] = "AUDITORIUM";
        BuidlingStock[totalBuilding] = 1;
        totalBuilding++;
        
        ItemName[totalItem] = "Table";
        ItemStock[totalItem] = 20000;
        totalItem++;
        ItemName[totalItem] = "Chair";
        ItemStock[totalItem] = 20000;
        totalItem++;
        ItemName[totalItem] = "Plate";
        ItemStock[totalItem] = 20000;
        totalItem++;
        ItemName[totalItem] = "Spoon";
        ItemStock[totalItem] = 20000;
        totalItem++;
        ItemName[totalItem] = "Fork";
        ItemStock[totalItem] = 20000;
        totalItem++;
        
        do {
            System.out.println("\n  .-=============================================-.");
            System.out.println("  ||                                             ||");
            System.out.println("  ||     PILIH BAHASA / CHOOSE YOUR LANGUAGE     ||");
            System.out.println("  ||                                             ||");
            System.out.println("  ||=============================================||");
            System.out.println("  ||                                             ||");
            System.out.println("  ||     1. BAHASA INDONESIA                     ||");
            System.out.println("  ||     2. ENGLISH                              ||");
            System.out.println("  ||                                             ||");
            System.out.println("=====================================================");
            System.out.print("||> Masukkan Bahasa / Input your language (1/2): ");
            bahasa = input.nextInt();
            if (bahasa < 1 || bahasa > 2 ){
                System.out.println("Mohon Masukkan nomor 1 atau 2 / Please input number 1 or 2 : ");
            }
        } while (bahasa < 1 || bahasa > 2);
        switch (bahasa){
            case 1 :
                System.out.println("\n T-.__________________________________________________________.-T");
                System.out.println(" ||                                                            ||");
                System.out.println(" ||       SELAMAT DATANG DI WEBSITE BOOKING GEDUNG SOEHAT      ||");
                System.out.println(" ||                                                            ||");
                System.out.println("<||.----------------------------------------------------------.||>");
                boolean pilihMenu = true;
                while (pilihMenu) {
                    do {
                        System.out.println("\n,----------------------------------------------------------------<");
                        System.out.println("|                           DAFTAR MENU                          |");
                        System.out.println("|----------------------------------------------------------------|");
                        System.out.println("|   1. Login Admin                5. Pencarian Gedung Tersedia   |");
                        System.out.println("|   2. Login Kasir                6. Pencarian Barang Tersedia   |");
                        System.out.println("|   3. Login User                 7. Keluar                      |");
                        System.out.println("|   4. Daftar Akun User Baru                                     |");
                        System.out.println("|_______________________________________________________________/.");
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
                                System.out.println("\n,-----------------------------------------------------------------<");
                                System.out.println("|                             MENU ADMIN                          |");
                                System.out.println("|-----------------------------------------------------------------|");
                                System.out.println("|   1. Pencarian Admin Terdaftar     8. Lihat Data Admin          |");
                                System.out.println("|   2. Pencarian Kasir Terdaftar     9. Lihat Data Kasir          |");
                                System.out.println("|   3. Pencarian User Terdaftar      10. Lihat Data User          |");
                                System.out.println("|   4. Lihat Sisa Stok Gedung        11. Tambah Akun Admin Baru   |");
                                System.out.println("|   5. Lihat Sisa Stok Barang        12. Tambah Akun Kasir Baru   |");
                                System.out.println("|   6. Lihat Laporan Pendapatan      13. Keluar                   |");
                                System.out.println("|   7. Lihat Histori Pemesanan                                    |");
                                System.out.println("|________________________________________________________________/.");
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
                                    if (jumlahHistori>0){
                                        LaporanPendapatan(new Date());
                                    } else {
                                        System.out.println("\n! Belum ada laporan pendapatan yang akan dicetak !");
                                    }
                                    break;
                                case 7:
                                    if (jumlahHistori>0){
                                        LihatHistoriPemesanan();
                                    } else {
                                        System.out.println("\n! Belum ada Histori pemesanan yang akan dicetak !");
                                    }
                                    break;
                                case 8:
                                    lihatDataAdmin();
                                    break;
                                case 9:
                                    lihatDataKasir();
                                    break;
                                case 10:
                                    LihatDataUser();
                                    break;
                                case 11:
                                    tambahAkunAdmin();
                                    break;
                                case 12:
                                    tambahAkunKasir();
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
                                System.out.println("\n,-----------------------------------------------------------<");
                                System.out.println("|                         MENU KASIR                        |");
                                System.out.println("|-----------------------------------------------------------|");
                                System.out.println("|   1. Cetak Struk Pemesanan     5. Lihat Sisa Stok Barang  |");
                                System.out.println("|   2. Lihat Sisa Stok Gedung    6. Tambah Stok Barang      |");
                                System.out.println("|   3. Tambah Stok Gedung        7. Tambah Barang Baru      |");
                                System.out.println("|   4. Tambah Gedung Baru        8. Keluar                  |");
                                System.out.println("|__________________________________________________________/.");
                                System.out.print("||> Masukkan Pilihan Anda: ");
                                menuKasir = input.nextInt();
                                if (menuKasir < 1 || menuKasir > 8) {
                                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 8 !");
                                }
                            } while (menuKasir < 1 || menuKasir > 8);
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
                                    tambahkanStokGedung(targetNamaGedung, tambahStokGedung);
                                    break;
                                case 4:
                                    tambahGedung();
                                    break;
                                case 5:
                                    tampilkanStokBarang();
                                    break;
                                case 6:
                                    tambahkanStokBarang(targetNamaBarang, tambahanStokBarang);
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
                        boolean regUsernameUserValid;
                        do {
                            System.out.println("\n---------------------------------------------------");
                            System.out.print("||> Masukkan username: ");
                            String inputUsernameUser = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Masukkan password: ");
                            String inputPasswordUser = input.next();
                            System.out.println("---------------------------------------------------");
                            regUsernameUserValid = false;
                            int indeksUser = -1;
                            for (int i = 0; i < jumlahUser; i++) {
                                if (inputUsernameUser.equals(regUsernameUser[i]) && inputPasswordUser.equals(regPasswordUser[i])) {
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
                                System.out.println("\n! Login failed. Username or password might be wrong. Please try again !");
                            }
                        } while (!regUsernameUserValid);
                        pilihanUser = true;
                        while (pilihanUser) {
                            do {
                                System.out.println("\n,---------------------------------<");
                                System.out.println("|            MENU USER            |");
                                System.out.println("|---------------------------------|");
                                System.out.println("|   1. Pesan Gedung Sekarang      |");
                                System.out.println("|   2. Lihat Sisa Stok Gedung     |");
                                System.out.println("|   3. Keluar                     |");
                                System.out.println("|________________________________/.");
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
                    } else if (stepLogin == 4){
                        tambahAkunUser();
                    } else if (stepLogin == 5) {
                        cariNamaGedung(targetNamaGedung);
                    } else if (stepLogin == 6) {
                        cariNamaBarang(targetNamaBarang);
                    } else if (stepLogin == 7) {
                        pilihMenu = false;
                        System.exit(0);
                    }
                }
            case 2 :
                System.out.println("\n T-.__________________________________________________________.-T");
                System.out.println(" ||                                                            ||");
                System.out.println(" ||       WELCOME TO OUR WEBSITE BOOKING GEDUNG SOEHAT         ||");
                System.out.println(" ||                                                            ||");
                System.out.println("<||.----------------------------------------------------------.||>");
                pilihMenu = true;
                while (pilihMenu) {
                    do {
                        System.out.println("\n,----------------------------------------------------------------<");
                        System.out.println("|                           LIST OF MENU                         |");
                        System.out.println("|----------------------------------------------------------------|");
                        System.out.println("|   1. Login Admin              5. Check Available Building      |");
                        System.out.println("|   2. Login Cashier            6. Check Available Item          |");
                        System.out.println("|   3. Login User               7. Exit                          |");
                        System.out.println("|   4. Sign For New User                                         |");
                        System.out.println("|_______________________________________________________________/.");
                        System.out.print("||> Input your choice : ");
                        stepLogin = input.nextInt();
                        if (stepLogin < 1 || stepLogin > 7) {
                            System.out.println("\n! Please input number between 1 and 7 !");
                        }
                    } while (stepLogin < 1 || stepLogin > 7);
                    if (stepLogin == 1) {
                        boolean regUsernameAdminValid = true;
                        do {
                            System.out.println("\n---------------------------------------------------");
                            System.out.print("||> Input username : ");
                            String inputUsernameAdmin = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Input password: ");
                            String inputPasswordAdmin = input.next();
                            System.out.println("---------------------------------------------------");
                            regUsernameAdminValid = false;
                            int indexAdmin = -1;
                            for (int i = 0; i < jumlahAdmin; i++) {
                                if (inputUsernameAdmin.equals(regUsernameAdmin[i]) && inputPasswordAdmin.equals(regPasswordAdmin[i])) {
                                    regUsernameAdminValid = true;
                                    indexAdmin = i;
                                    break;
                                }
                            }
                            if (regUsernameAdminValid) {
                                System.out.println("\n-....................................-");
                                System.out.println("            ! LOGIN SUCCED !          ");
                                System.out.println("            WELCOME, ADMIN :)         ");
                                System.out.println("-....................................-");
                            } else {
                                System.out.println("\n! Login failed. Username or password might be wrong. Please try again !");
                            }
                        } while (!regUsernameAdminValid);
                        boolean pilihanAdmin = true;
                        while (pilihanAdmin) {
                            do {
                                System.out.println("\n,-----------------------------------------------------------------<");
                                System.out.println("|                             ADMIN MENU                          |");
                                System.out.println("|-----------------------------------------------------------------|");
                                System.out.println("|   1. Find Registered Admin     8. Check Admins' Data            |");
                                System.out.println("|   2. Find Registered Cashier   9. Check Cashiers' Data          |");
                                System.out.println("|   3. Find Registered User      10. Check Users' Data            |");
                                System.out.println("|   4. Check Building Stock      11. Add New Admin Account        |");
                                System.out.println("|   5. Check Item Stock          12. Add New Cashier Account      |");
                                System.out.println("|   6. Check Income Report       13. Exit                         |");
                                System.out.println("|   7. Check Payment History                                      |");
                                System.out.println("|________________________________________________________________/.");
                                System.out.print("||> Input your choice : ");
                                menuAdmin = input.nextInt();
                                if (menuAdmin < 1 || menuAdmin > 13) {
                                    System.out.println("\n! Please input number between 1 and 13 !");
                                }
                            } while (menuAdmin < 1 || menuAdmin > 13);
                            switch (menuAdmin) {
                                case 1:
                                    PencarianAdminTerdaftarEng();
                                    break;
                                case 2:
                                    PencarianKasirTerdaftarEng();
                                    break;
                                case 3:
                                    PencarianUserTerdaftarEng();
                                    break;
                                case 4:
                                    tampilkanStokGedungEng();
                                    break;
                                case 5:
                                    tampilkanStokBarangEng();
                                    break;
                                case 6:
                                    if (jumlahHistori>0){
                                        LaporanPendapatanEng(new Date());
                                    } else {
                                        System.out.println("\n! There are no earnings reports yet to be printed !");
                                    }
                                    break;
                                case 7:
                                    if (jumlahHistori>0){
                                        LihatHistoriPemesananEng();
                                    } else {
                                        System.out.println("\n! There is no order history to print yet !");
                                    }
                                    break;
                                case 8:
                                    lihatDataAdminEng();
                                    break;
                                case 9:
                                    lihatDataKasirEng();
                                    break;
                                case 10:
                                    LihatDataUserEng();
                                    break;
                                case 11:
                                    tambahAkunAdminEng();
                                    break;
                                case 12:
                                    tambahAkunKasirEng();
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
                            System.out.print("||> Input Username : ");
                            String inputUsernameKasir = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Input Password : ");
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
                                System.out.println("            ! LOGIN SUCCED !          ");
                                System.out.println("           WELCOME, Cashier :)        ");
                                System.out.println("-....................................-");
                            } else {
                                System.out.println("\n! Login failed. Username or password might be wrong. Please try again !");
                            }
                        } while (!regUsernameKasirValid);
                        boolean pilihanKasir = true;
                        while (pilihanKasir) {
                            do {
                                System.out.println("\n,-----------------------------------------------------------<");
                                System.out.println("|                       CASHIER MENU                        |");
                                System.out.println("|-----------------------------------------------------------|");
                                System.out.println("|   1. Print Receipt           5. Check Item Stock          |");
                                System.out.println("|   2. Check Building Stock    6. Add Item Stock            |");
                                System.out.println("|   3. Add Building Stock      7. Add New Item              |");
                                System.out.println("|   4. Add New Building        8. Exit                      |");
                                System.out.println("|__________________________________________________________/.");
                                System.out.print("||> Input your choice : ");
                                menuKasir = input.nextInt();
                                if (menuKasir < 1 || menuKasir > 8) {
                                    System.out.println("\n! Please input number between 1 and 8 !");
                                }
                            } while (menuKasir < 1 || menuKasir > 8);
                            switch (menuKasir) {
                                case 1:
                                    if (jumlahHistori>0){
                                    cetakStrukEng();
                                    } else {
                                        System.out.println("\n! There is no receipt to print !");
                                    }
                                    break;
                                case 2:
                                    tampilkanStokGedungEng();
                                    break;
                                case 3:
                                    tambahkanStokGedungEng(targetNamaGedung, tambahStokGedung);
                                    break;
                                case 4:
                                    tambahGedungEng();
                                    break;
                                case 5:
                                    tampilkanStokBarangEng();
                                    break;
                                case 6:
                                    tambahkanStokBarangEng(targetNamaBarang, tambahanStokBarang);
                                    break;
                                case 7:
                                    tambahBarangEng();
                                    break;
                                case 8:
                                    pilihMenu = true;
                                    pilihanKasir = false;
                                    break;
                            }
                        }
                    } else if (stepLogin == 3) {
                        boolean regUsernameUserValid;
                        do {
                            System.out.println("\n---------------------------------------------------");
                            System.out.print("||> Input username : ");
                            String inputUsernameUser = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Input password: ");
                            String inputPasswordUser = input.next();
                            System.out.println("---------------------------------------------------");
                            regUsernameUserValid = false;
                            int indexUser = -1;
                            for (int i = 0; i < jumlahUser; i++) {
                                if (inputUsernameUser.equals(regUsernameUser[i]) && inputPasswordUser.equals(regPasswordUser[i])) {
                                    regUsernameUserValid = true;
                                    indexUser = i;
                                    break;
                                }
                            }
                            if (regUsernameUserValid) {
                                System.out.println("\n-...................................-");
                                System.out.println("           ! LOGIN SUCCED !          ");
                                System.out.println("           WELCOME, USER :)          ");
                                System.out.println("-...................................-");
                            } else {
                                System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                            }
                        } while (!regUsernameUserValid);
                        boolean pilihMember = true;
                        while (pilihMember) {
                            do {
                                System.out.println("\n,---------------------------------<");
                                System.out.println("|            USER MENU            |");
                                System.out.println("|---------------------------------|");
                                System.out.println("|   1. Book a Building            |");
                                System.out.println("|   2. Check Available Buildings  |");
                                System.out.println("|   3. Exit                       |");
                                System.out.println("|________________________________/.");
                                System.out.print("||> Input your choice : ");
                                menuUser = input.nextInt();
                                if (menuUser < 1 || menuUser > 3) {
                                    System.out.println("\n! Please input number between 1 and 3 !");
                                }
                                switch (menuUser) {
                                    case 1:
                                        ProsesPemesananGedungEng();
                                        cetakStrukEng();
                                        break;
                                    case 2:
                                        tampilkanStokGedungEng();
                                        break;
                                    case 3:
                                        pilihMenu = true;
                                        pilihMember = false;
                                        break;
                                }
                            } while (menuUser < 1 || menuUser > 3);
                        }
                    } else if (stepLogin == 4){
                        tambahAkunUserEng();
                    } else if (stepLogin == 5) {
                        searchNamaGedungEng(targetNamaGedung);
                    } else if (stepLogin == 6) {
                        cariNamaBarangEng(targetNamaBarang);
                    } else if (stepLogin == 7) {
                        pilihMenu = false;
                        System.exit(0);
                    }
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

    //CASE 2 MENU ADMIN
    public static void PencarianKasirTerdaftar() {
        Scanner input = new Scanner(System.in);
        System.out.println("/n----------------------------------------------------");
        System.out.print("||> Masukkan username kasir: ");
        String targetKasir = input.next();
        System.out.println("----------------------------------------------------");
        boolean kasirTerdaftar = false;
        for (int i = 0; i < jumlahKasir; i++) {
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
            System.out.println("\n,----------------------------------------------<");
            System.out.println("|         Daftar Gedung yang tersedia!         |");
            System.out.println("|______________________________________________|");
            System.out.println("| No. | Nama Gedung | Harga Sewa   | Maks Tamu |");
            System.out.println("|-----|-------------|--------------|-----------|");
            System.out.println("| 1.  | Pernikahan  | Rp.5000000   | 5000      |");
            System.out.println("| 2.  | Auditorium  | Rp.2000000   | 2000      |");
            System.out.println("|_____|_____________|______________|__________/.");
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
                hargaGedung1=5000000;
                do {
                    System.out.print("||> Masukkan Jumlah Tamu: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 5000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Mohon masukkan jumlah tamu antara 1 dan 5000 !");
                    } else {
                        cetakStokGedung[jumlahHistori] = stokGedung[0];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        BarangTambahan();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 5000);
            } else {
                System.out.println("Gedung telah disewakan");
                    pilihanUser=true;
            }
        } else if (pilihGedung == 2){
            if (stokGedung[1]>0) {
                totalGedung ="\n-> "+namaGedung[1];
                cetakGedung[jumlahHistori] = totalGedung;
                hargaGedung2=2000000;
                do {
                    System.out.print("||> Masukkan Jumlah Tamu: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 2000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Mohon masukkan jumlah tamu antara 1 dan 2000 !");
                    } else {
                        cetakStokGedung[jumlahHistori] = stokGedung[1];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        BarangTambahan();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 2000);
            } else {
                System.out.println("Gedung telah disewakan");
                pilihanUser=true;
            }
        }
        InputDataPengguna();                             
        PilihanMember();                                
        PilihMetodeBayar();
        cetakStruk();
        if (pilihGedung == 1) {
            stokGedung[0] -= 1;
        } else if (pilihGedung==2){
            stokGedung[1] -= 1;
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
                    if (pilihGedung==1){
                        for (String verifMember : kodeMember) {
                            if (inputKodeMember.equals(verifMember)) {
                                diskon = 0.13 * hargaGedung1;
                                cetakHargaMember = hargaGedung1 - diskon;
                                totalBiaya=(long)cetakHargaMember;
                                tampilBiaya[jumlahHistori]=totalBiaya;
                                memberValid=true;
                                break;
                            } 
                        }
                        if (!memberValid) {
                            System.out.println("\n! Kode verifikasi Salah. Silahkan coba lagi !");
                            memberValid=false;
                        }
                    } else if (pilihGedung==2){
                        for (String verifMember : kodeMember) {
                            if (inputKodeMember.equals(verifMember)) {
                                diskon = 0.13 * hargaGedung2;
                                cetakHargaMember = hargaGedung2 - diskon;
                                totalBiaya=(long)cetakHargaMember;
                                tampilBiaya[jumlahHistori]=totalBiaya;
                                memberValid=true;
                                break;
                            }
                        }
                        if (!memberValid) {
                            System.out.println("\n! Kode verifikasi Salah. Silahkan coba lagi !");
                            memberValid=false;
                        }
                    }
                } while (!memberValid);
            } else if (inputUserMember.equals("t")){
                if (pilihGedung == 1) {
                    diskon = 0 * totalTarif;
                    cetakHargaMember = hargaGedung1 - diskon;
                    totalBiaya=(long)cetakHargaMember;
                    tampilBiaya[jumlahHistori]=totalBiaya;
                    memberValid=true;
                } else if (pilihGedung == 2){
                    diskon = 0 * totalTarif;
                    cetakHargaMember = hargaGedung2 - diskon;
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

    public static void PencarianAdminTerdaftarEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Input Username of admin : ");
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
            System.out.println("!    ! Admin Already Registered !    !");
        } else if (!adminTerdaftar) {
            System.out.println("!      ! Admin Not Registered !      !");
        }
        System.out.println("!.----------------------------------.!");
    }

    public static void PencarianKasirTerdaftarEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("/n----------------------------------------------------");
        System.out.print("||> Input Username of Cashier: ");
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
            System.out.println("!   ! Cashier Already Registered !   !");
        } else if (!kasirTerdaftar) {
            System.out.println("!     ! Cashier Not Registered !     !");
        }
        System.out.println("!.----------------------------------.!");
    }

    public static void PencarianUserTerdaftarEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Input Username of user: ");
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
            System.out.println("!     ! User Already Registerd !     !");
        } else if (!userTerdaftar) {
            System.out.println("!       ! User Not Registered !      !");
        }
        System.out.println("!.----------------------------------.!");
    }

    public static void tampilkanStokGedungEng() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Available Building  :");
        for (int i = 0; i < jumlahGedung; i++) {
            System.out.println((i + 1) + ". " + BuildingName[i] + "\t: " + BuidlingStock[i]);
        }
        System.out.println("----------------------------------------------------");
    }
    
    public static void tampilkanStokBarangEng(){
        System.out.println("\n,-------------------------------<");
        System.out.println("|     List of Available Item    | ");
        System.out.println("|_______________________________|");
        System.out.println("| No. | Item Name   | Stock \t|");
        System.out.println("|-----|-------------|-----------|");
        for (int i = 0; i < totalItem; i++) {
            System.out.println("| " + (i + 1) + ".  | " + ItemName[i] + "\t    | "+ ItemStock[i] + "\t|");
        }
        System.out.println("|_____|_____________|__________/.");
    }

    public static void cariNamaBarangEng(String targetNamaBarang) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Input Item Name : ");
        targetNamaBarang = input.next();
        System.out.println("----------------------------------------------------");
        boolean isBarangDitemukan = false;
        for (int i = 0; i < totalItem; i++) {
            if (ItemName[i].equalsIgnoreCase(targetNamaBarang)) {
                isBarangDitemukan = true;
                System.out.println("\n.------------------------------------.");
                System.out.println("!          ! Item available !        !");
                System.out.println("!.----------------------------------.!");
                break;
            }
        }
        if (!isBarangDitemukan) {
            System.out.println("\n.--------------------------------------.");
            System.out.println("!         ! Item Not Available !       !");
            System.out.println("!.------------------------------------.!");
        }
    }

    public static void searchNamaGedungEng(String targetNamaGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Input Building Name : ");
        targetNamaGedung = input.next();
        System.out.println("----------------------------------------------------");
        boolean jikaGedungDitemukan = false;
        for (int i = 0; i < totalBuilding; i++) {
            if (BuildingName[i].equalsIgnoreCase(targetNamaGedung)) {
                jikaGedungDitemukan = true;
                System.out.println("\n.---------------------------------.");
                System.out.println("!     ! Building Available !      !");
                System.out.println("!.-------------------------------.!");
                break;
            }
        }
        if (!jikaGedungDitemukan) {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!     ! Building Not Available !    !");
            System.out.println("!.---------------------------------.!");
        }
    }

    public static void tambahkanStokGedungEng(String targetNamaGedung, int tambahStokGedung) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("||> Input Building Name : ");
        targetNamaGedung = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Input how many stock you want to add : ");
        tambahStokGedung = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaGedungTersedia = false;
        int indeks = -1;
        for (int i = 0; i < totalBuilding; i++) {
            if (BuildingName[i].equalsIgnoreCase(targetNamaGedung)) {
                jikaGedungTersedia = true;
                indeks = i;
                break;
            }
        }
        if (jikaGedungTersedia) {
            BuidlingStock[indeks] += tambahStokGedung;
            System.out.println("\n.-----------------------------------.");
            System.out.println("!     ! Building Stock Added !      !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Building Name: " + BuildingName[indeks]);
            System.out.println("  Stock : " + BuidlingStock[indeks]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!    ! Building Not Available !     !");
            System.out.println("!.----------------------------------!");
        }
        
    }

    public static void tambahkanStokBarangEng(String targetNamaBarang, int tambahanStokBarang) {
        Scanner input = new Scanner(System.in);
        System.out.print("||> Input Item Name : ");
        targetNamaBarang = input.next();
        System.out.println("----------------------------------------------------");
        System.out.print("||> Input how many stock you want to add : ");
        tambahanStokBarang = input.nextInt();
        System.out.println("----------------------------------------------------");
        boolean jikaBarangTersedia = false;
        indeksBarang = -1;
        for (int i = 0; i < totalItem; i++) {
            if (ItemName[i].equalsIgnoreCase(targetNamaBarang)) {
                jikaBarangTersedia = true;
                indeksBarang = i;
                break;
            }
        }
        if (jikaBarangTersedia) {
            ItemStock[indeksBarang] += tambahanStokBarang;
            System.out.println("\n.-----------------------------------.");
            System.out.println("!        ! Item Stock Added !       !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Item Name: " + ItemName[indeksBarang]);
            System.out.println("  Stock : " + ItemStock[indeksBarang]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.----------------------------------.");
            System.out.println("!      ! Item Not Available !      !");
            System.out.println("!.---------------------------------!");
        }
    }

    public static void tambahGedungEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("Input New Building Name: ");
        String namaGedungBaru = input.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.print("Input New Building Stock: ");
        int stokGedungBaru = input.nextInt();
        System.out.println("----------------------------------------------------");
        if (totalBuilding < BuildingName.length && totalBuilding < BuidlingStock.length) {
            BuildingName[totalBuilding] = namaGedungBaru;
            BuidlingStock[totalBuilding] = stokGedungBaru;
            totalBuilding++;
            System.out.println("\nNew Building Added !");
        } else {
            System.out.println("\n! Sorry, amount of stock has reached limit !");
        }
    }
    
    public static void tambahBarangEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------");
        System.out.print("Input New Item Name: ");
        String namaBarangBaru = input.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.print("Input New Item Stock: ");
        int stokBarangBaru = input.nextInt();
        System.out.println("----------------------------------------------------");
        if (totalItem < ItemName.length && totalItem < ItemStock.length) {
            ItemName[totalItem] = namaBarangBaru;
            ItemStock[totalItem] = stokBarangBaru;
            totalItem++;
            System.out.println("\nNew Item Added!");
        } else {
            System.out.println("\n! Sorry, amount of stock has reached limit !");
        }
    }

    public static void cekStokBarangEng(String targetNamaBarang) {
        boolean jikaBarangTersedia = false;
        int index = -1;
        for (int i = 0; i < jumlahBarang; i++) {
            if (ItemName[i].equalsIgnoreCase(targetNamaBarang)) {
                jikaBarangTersedia = true;
                index = i;
                break;
            }
        }
        if (jikaBarangTersedia) {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!        ! Item Available !         !");
            System.out.println("!.----------------------------------!");
            System.out.println("  Item Name: " + ItemName[index]);
            System.out.println("  Stock: " + ItemStock[index]);
            System.out.println(".-----------------------------------.");
        } else {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!       ! Item Not Available !      !");
            System.out.println("!.----------------------------------!");
        }
    }

    public static void ProsesPemesananGedungEng() {
        Scanner input = new Scanner(System.in);
        boolean pilihanGedung = true;
        while (pilihanGedung) {
            System.out.println("\n,--------------------------------------------------<");
            System.out.println("|            List of Available Building !          |");
            System.out.println("|__________________________________________________|");
            System.out.println("| No. | Buildings Name | Price        | Max. Guest |");
            System.out.println("|-----|----------------|--------------|------------|");
            System.out.println("| 1.  | Wedding Hall   | Rp.5000000   | 5000       |");
            System.out.println("| 2.  | Auditorium     | Rp.2000000   | 2000       |");
            System.out.println("|_____|________________|______________|___________/.");
            System.out.print("||> Input your choice: ");
            pilihGedung = input.nextInt();
            if (pilihGedung < 1 || pilihGedung > 2) {
                System.out.println("\n.-------------------------------------------.");
                System.out.println("!   Please input number between 1 and 2     !");
                System.out.println("!.-----------------------------------------.!");
                pilihanGedung=true;
            } else {
                pilihanGedung=false;
            }
        }
        if (pilihGedung == 1) {
            if (BuidlingStock[0]>0) {
                totalGedung ="\n-> "+BuildingName[0];
                cetakGedung[jumlahHistori] = totalGedung;
                hargaGedung1=5000000;
                do {
                    System.out.print("||> Input number of guest: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 5000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Please input guest between 1 and "+stokGedung[0] +"!");
                    } else {
                        cetakStokGedung[jumlahHistori] = BuidlingStock[0];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        BarangTambahanEng();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 5000);
            } else {
                System.out.println("Building has been booked");
                    pilihanGedung=false;
            }
        } else if (pilihGedung == 2){
            if (BuidlingStock[1]>0) {
                totalGedung ="\n-> "+BuildingName[1];
                cetakGedung[jumlahHistori] = totalGedung;
                hargaGedung2=2000000;
                do {
                    System.out.print("||> Input number of guest: ");
                    jumlahTamu = input.nextInt();
                    if (jumlahTamu <1 || jumlahTamu> 2000) {
                        System.out.println("----------------------------------------------------");
                        System.out.println("! Please input guest between 1 and "+BuidlingStock[1] +"!");
                    } else {
                        cetakStokGedung[jumlahHistori] = BuidlingStock[1];
                        tamuPemesan[jumlahHistori]=jumlahTamu;
                        BarangTambahanEng();
                        pilihanGedung=false;
                    }
                } while (jumlahTamu < 1 || jumlahTamu > 2000);
            } else {
                System.out.println("Gedung has been booked");
                pilihanGedung=false;
            }
        }
        if (BuidlingStock[0]>0 || BuidlingStock[1]>0) {
            InputDataPenggunaEng();                             
            PilihanMemberEng();                                
            PilihMetodeBayarEng();
            if (pilihGedung == 1) {
                BuidlingStock[0] -= 1;
            } else if (pilihGedung == 2){
                BuidlingStock[1] -= 1;
            }
        }
    }

    public static void BarangTambahanEng() {
        int jumlahPesananMeja=jumlahTamu;
        if (jumlahPesananMeja <= ItemStock[0]) {
            totalBarang="\n-> "+ItemName[0]+"     \t: "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            
            ItemStock[0] -= jumlahTamu;
        } else {
            System.out.println("\n! Insufficient table stock for the order !");
        }
        int jumlahPesananKursi=jumlahTamu;
        if (jumlahPesananKursi <= ItemStock[1]) {
            totalBarang+="\n-> "+ItemName[1]+"     \t: "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            ItemStock[1] -= jumlahTamu;
        } else {
            System.out.println("\n! Insufficient chair stock for the order !");
        }
        int jumlahPesananPiring=jumlahTamu;
        if (jumlahPesananPiring <= ItemStock[2]) {
            totalBarang+="\n-> "+ItemName[2]+"     \t: "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            ItemStock[2] -= jumlahTamu;
        } else {
            System.out.println("\n! Insufficient plate stock for the order !");
        }
        int jumlahPesananSendok=jumlahTamu;
        if (jumlahPesananSendok <= ItemStock[3]) {
            totalBarang+="\n-> "+ItemName[3]+"     \t: "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            ItemStock[3] -= jumlahTamu;
        } else {
            System.out.println("\n! Insufficient spoon stock for the order !");
        }
        int jumlahPesananGarpu=jumlahTamu;
        if (jumlahPesananGarpu <= ItemStock[4]) {
            totalBarang+="\n-> "+ItemName[4]+"     \t: "+jumlahTamu;
            jumlahTotalBarang+=totalBarang;
            ItemStock[4] -= jumlahTamu;
        } else {
            System.out.println("\n! Insufficient fork stock for the order !");
        }
        cetakBarang[jumlahHistori]=jumlahTotalBarang;
    }

    public static void InputDataPenggunaEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.print("||> Input your name: ");
        inputNamaPelanggan = input.nextLine();
        System.out.print("||> Input your telephone number: ");
        inputNoTelpPelanggan = input.nextLine();
        boolean inputTanggalValid = false;
        while (!inputTanggalValid) {
            System.out.print("||> Input date you want to book (dd/MM/yyyy): ");
            inputTanggal = input.nextLine();
            if (isValidFormat(inputTanggal, dateFormat)) {
                tanggal = dateFormat.parse(inputTanggal, new ParsePosition(0));
                if (tanggal != null && tanggal.getTime() > calendar.getTimeInMillis()) {
                    inputTanggalValid = true;
                    tampilTanggal[jumlahHistori] = inputTanggal;
                } else {
                    System.out.println("Date of the event must be in the future. Please try again.");
                }
            } else {
                System.out.println("Date format is not valid. Please try again.");
            }
        }
    }

    private static void LaporanPendapatanEng(Date currentDate) {
        System.out.println("\n======================================================");
        System.out.println("             DAILY AND MONTHLY INCOME REPORT ");
        System.out.println("\nDate: " + dateFormat.format(currentDate));
        System.out.println("======================================================");
        for (int i = 0; i < jumlahHistori; i++) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("Booked on  : " + tampilTanggal[i]);
            System.out.println("Name of Building " + cetakGedung[i]);
            System.out.println("Name of Item "+cetakBarang[i]);
            System.out.println("Payment Method : "+cetakMetodePembayaran[i]);
            System.out.println("----------------------------------------------------");
            System.out.println("DAILY INCOME : Rp." + tampilBiaya[i]);
            System.out.println("----------------------------------------------------");
            totalPendapatanBulanan += tampilBiaya[i];
        }
        System.out.println("\n====================================================");
        System.out.println("TOTAL MONTHLY INCOME : Rp." + totalPendapatanBulanan);
        System.out.println("====================================================");
    }

    public static void LihatHistoriPemesananEng() {
        System.out.println("\n-----------------------------------");
        System.out.println("Total History : " + jumlahHistori);
        System.out.println("List of Payment History:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahHistori; i++) {
            System.out.println("Histori number-" + (i + 1));
            System.out.println("Date              : " + tampilTanggal[i]);
            System.out.println("Name              : " + namaPelanggan[i]);
            System.out.println("Telephone         : " + noTelpPelanggan[i]);
            System.out.println("Building          : " + cetakGedung[i]);
            System.out.println("Item              : " + cetakBarang[i]);
            System.out.println("Payment Method    : " + cetakMetodePembayaran[i]);
            System.out.println("-----------------------------------");
        }
    }

    public static void tambahAkunAdminEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input New Username: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input New Password: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahAdmin < regUsernameAdmin.length && jumlahAdmin < regPasswordAdmin.length) {
            regUsernameAdmin[jumlahAdmin] = inputUserBaru;
            regPasswordAdmin[jumlahAdmin] = inputPwBaru;
            jumlahAdmin++;
            System.out.println("\n-.......................................-");
            System.out.println("   ! USER ADMIN ADDED !   ");
            System.out.println("-.......................................-\n");
        } else {
            System.out.println("\nSorry, total admin account has reached limit.");
        }
    }

    public static void tambahAkunKasirEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input new username: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input new password: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahKasir < regUsernameKasir.length && jumlahKasir < regPasswordKasir.length) {
            regUsernameKasir[jumlahKasir] = inputUserBaru;
            regPasswordKasir[jumlahKasir] = inputPwBaru;
            jumlahKasir++;
            System.out.println("\n-.......................................-");
            System.out.println("   ! USER CASHIER ADDED !   ");
            System.out.println("-.......................................-\n");
        } else {
            System.out.println("\nSorry, total cashier account has reached limit.");
        }
    }

    public static void tambahAkunUserEng() {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input new username: ");
        String inputUserBaru = input.next();
        System.out.println("---------------------------------------------------");
        System.out.print("||> Input new password: ");
        String inputPwBaru = input.next();
        System.out.println("---------------------------------------------------");
        if (jumlahUser < regUsernameUser.length && jumlahUser < regPasswordUser.length) {
            regUsernameUser[jumlahUser] = inputUserBaru;
            regPasswordUser[jumlahUser] = inputPwBaru;
            jumlahUser++;
            System.out.println("\n-....................................-");
            System.out.println("   ! NEW USER ADDED !   ");
            System.out.println("-....................................-\n");
        } else {
            System.out.println("\nSorry, total user account has reached limit.");
        }
    }

    public static void lihatDataAdminEng(){
        System.out.println("\n-----------------------------------");
        System.out.println("Total account : " + jumlahAdmin);
        System.out.println("List of registered account  :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahAdmin; i++) {
            System.out.println("Admin number-" + (i + 1));
            System.out.println("Username : " + regUsernameAdmin[i]);
            System.out.println("Password : " + regPasswordAdmin[i]);
            System.out.println("-----------------------------------");
        }
    }

    public static void lihatDataKasirEng(){
        System.out.println("\n-----------------------------------");
        System.out.println("Total account : " + jumlahKasir);
        System.out.println("List of registered account :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahKasir; i++) {
            System.out.println("Cashier number-" + (i + 1));
            System.out.println("Username : " + regUsernameKasir[i]);
            System.out.println("Password : " + regPasswordKasir[i]);
            System.out.println("-----------------------------------");
        }
    }

    public static void LihatDataUserEng(){
        System.out.println("\n-----------------------------------");
        System.out.println("Total account : " + jumlahUser);
        System.out.println("List of registered account :");
        System.out.println("-----------------------------------");
        for (int i = 0; i < jumlahUser; i++) {
            System.out.println("User number-" + (i + 1));
            System.out.println("Username : " + regUsernameUser[i]);
            System.out.println("Password : " + regPasswordUser[i]);
            System.out.println("-----------------------------------");
        }
    }

    public static void PilihMetodeBayarEng() {
        Scanner input = new Scanner(System.in);
        int inputMetodePembayaran;
        String metodePembayaran1 = "", metodePembayaran2 = "", metodePembayaran3 = "",
               metodePembayaran4 = "", metodePembayaran5 = "", metodePembayaran6 = "";
        boolean metodeBayar = true;
        while (metodeBayar) {
            do {
                System.out.println("\n,---------------------------------------------------------------<");
                System.out.println("|                        PAYMENT METHOD!                        |");
                System.out.println("|_______________________________________________________________|");
                System.out.println("| No.| VIA        | Account/Telephone | Name                    |");
                System.out.println("|----|------------|-------------------|-------------------------|");
                System.out.println("| 1. | BRI        | 2341760195        | Gerly Vaeyungfan        |");
                System.out.println("| 2. | BNI        | 2341760043        | Aprilia Putri Anggraeni |");
                System.out.println("| 3. | BCA        | 2341760068        | Jaden Natha Kautsar     |");
                System.out.println("| 4. | DANA       | 081547207512      | Gerly Vaeyungfan        |");
                System.out.println("| 5. | ShopeePay  | 085755742091      | Aprilia Putri Anggraeni |");
                System.out.println("| 6. | LinkAja    | 085810393753      | Jaden Natha Kautsar     |");
                System.out.println("|____|____________|___________________|________________________/.");
                System.out.print("||> Select payment method: ");
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
                    System.out.println("\n! Please input number between 1 and 6 !");
                }
            } while (inputMetodePembayaran < 1 || inputMetodePembayaran > 6);
            switch (inputMetodePembayaran) {
                case 1:
                    cekApakahKodeValidEng();
                    break;
                case 2:
                    cekApakahKodeValidEng();
                    break;
                case 3:
                    cekApakahKodeValidEng();
                    break;
                case 4:
                    cekApakahKodeValidEng();
                    break;
                case 5:
                    cekApakahKodeValidEng();
                    break;
                case 6:
                    cekApakahKodeValidEng();
                    break;
            }
        }
    }

    public static void cekApakahKodeValidEng() {
        Scanner input = new Scanner(System.in);
        boolean jikaKodeValid = false;
        do {
            System.out.println("\n.-----------------------------------------.");
            System.out.println("|                                         |");
            System.out.println("|    VERIFICATION CODE SENT BY MESSAGE    |");
            System.out.println("|                                         |");
            System.out.println("|.----------------------------------------'");
            System.out.print("\n||> Input verification code: ");
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
                System.out.println("\n! Verification Code wrong, please try again !");
            }
        } while (!jikaKodeValid);
    }

    public static void PilihanMemberEng() {
        Scanner input = new Scanner(System.in);
        String inputUserMember;
        boolean memberValid=false;
        while (!memberValid){
            System.out.println("\n----------------------------------------------------");
            System.out.print("||> Are you a memeber (y/n): ");
            inputUserMember= input.nextLine();
            System.out.println("----------------------------------------------------");
            if (inputUserMember.equals("y")){
                memberValid = false;
                do {
                    System.out.print("||> Input Your Code Member: ");
                    String inputKodeMember = input.next();
                    System.out.println("----------------------------------------------------");
                    if (pilihGedung==1){
                        for (String verifMember : kodeMember) {
                            if (inputKodeMember.equals(verifMember)) {
                                diskon = 0.13 * hargaGedung1;
                                    cetakHargaMember = hargaGedung1 - diskon;
                                    totalBiaya=(long)cetakHargaMember;
                                    tampilBiaya[jumlahHistori]=totalBiaya;
                                    memberValid=true;
                                break;
                            }
                        }
                        if (!memberValid) {
                            System.out.println("\n! Verification code is wrong. Please try again !");
                            memberValid=false;
                        }
                    } else if (pilihGedung==2){
                        for (String verifMember : kodeMember) {
                            if (inputKodeMember.equals(verifMember)) {
                                diskon = 0.13 * hargaGedung2;
                                cetakHargaMember = hargaGedung2 - diskon;
                                totalBiaya=(long)cetakHargaMember;
                                tampilBiaya[jumlahHistori]=totalBiaya;
                                memberValid=true;
                                break;
                            }
                        }
                        if (!memberValid) {
                            System.out.println("\n! Verification code is wrong. Please try again !");
                            memberValid=false;
                        }
                    }
                } while (!memberValid);
            } else if (inputUserMember.equals("n")){
                if (pilihGedung == 1) {
                    diskon = 0 * totalTarif;
                    cetakHargaMember = hargaGedung1 - diskon;
                    totalBiaya=(long)cetakHargaMember;
                    tampilBiaya[jumlahHistori]=totalBiaya;
                    memberValid=true;
                } else if (pilihGedung == 2){
                    diskon = 0 * totalTarif;
                    cetakHargaMember = hargaGedung2 - diskon;
                    totalBiaya=(long)cetakHargaMember;
                    tampilBiaya[jumlahHistori]=totalBiaya;
                    memberValid=true;
                }
            }
        }
    }

    public static void cetakStrukEng() {
        System.out.println("\n==============================================\n");
        System.out.println("\t     BOOKING GEDUNG SOEHAT\n");
        System.out.println("=============== YOUR ORDER NOTE ==============");
        System.out.println("\nBooked Building "+ cetakGedung[jumlahHistori-1]);
        System.out.println("\nCustomer's name  : " + namaPelanggan[jumlahHistori-1]);
        System.out.println("Telephone          : " + noTelpPelanggan[jumlahHistori-1]);
        System.out.println("Date               : " + tampilTanggal[jumlahHistori-1]);
        System.out.println("Total Guest        : " + tamuPemesan[jumlahHistori-1]);
        System.out.println("\nAdditional Item"+cetakBarang[jumlahHistori-1]);
        System.out.println("\nTotal Price       : Rp." + tampilBiaya[jumlahHistori-1]);
        System.out.println("---------------------------------------------");
        System.out.println("Payment Method : " + cetakMetodePembayaran[jumlahHistori-1]);
        System.out.println("---------------------------------------------");
        System.out.println("\t   Jl. Soekarno Hatta No.9");
        System.out.println("       Kel. Jatimulyo, Kec. Lowokwaru");
        System.out.println("\t       MALANG 65141");
        System.out.println("---------------------------------------------");
    }

}
