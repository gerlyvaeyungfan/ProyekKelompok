import java.util.Scanner;

public class ProyekBookingGedung {
    static String[] namaBarang = new String[5];
    static int[] stokBarang = new int[5];
    static int jumlahBarang = 0;
    static String[] namaGedung = new String[4];
    static int[] stokGedung = new int[4];
    static int jumlahGedung = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String akun, inputUserAdmin, inputPwAdmin, inputUserMember, inputPwMember, inputKodeVerivPil1, inputKodeVerivPil2;
        String kodeVeriv[] = { "01234", "12345", "23456", "34567", "45678", "56789", "67890" };
        int tamuPemesan=0, stepLogin, menuGedung, inputamuPemesanetodePembayaran, menuAdmin, menuMember;
        String nama, noTelp, tgl, namaPemesan="", noTelpPemesan="", tglPemesan="", inputPesanLagi;
        long tarif = 0, hargaMeja, hargaKursi, hargaKarpet, hargaSound, hargaMic, totalTarif = 0,
            hargaGedung1, hargaGedung2, hargaGedung3, hargaGedung4;
        int jumlahTamu, inputJumlahPesananGedung, jumlahPesananMeja, jumlahPesananKursi,jumlahPesananKarpet,
            jumlahPesananSound, jumlahPesananMic;
        int pilihGedung,totalPesanMeja=0,totalPesanKursi=0, totalPesanKarpet=0, totalPesanSound=0, totalPesanMic=0;
        int jumlahPesanGedung1=0, jumlahPesanGedung2=0, jumlahPesanGedung3=0, jumlahPesanGedung4=0, totalPesanGedung=0;
        String cetakGedung = "", cetakBarang="";

        namaGedung[jumlahGedung] = "Pernikahan";
        stokGedung[jumlahGedung] = 10;
        jumlahGedung++;
        namaGedung[jumlahGedung] = "Olahraga";
        stokGedung[jumlahGedung] = 10;
        jumlahGedung++;
        namaGedung[jumlahGedung] = "Kesenian";
        stokGedung[jumlahGedung] = 10;
        jumlahGedung++;
        namaGedung[jumlahGedung] = "Auditorium";
        stokGedung[jumlahGedung] = 10;
        jumlahGedung++;

        namaBarang[jumlahBarang] = "Meja";
        stokBarang[jumlahBarang] = 10000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Kursi";
        stokBarang[jumlahBarang] = 10000;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Karpet";
        stokBarang[jumlahBarang] = 100;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Sound";
        stokBarang[jumlahBarang] = 50;
        jumlahBarang++;
        namaBarang[jumlahBarang] = "Mic";
        stokBarang[jumlahBarang] = 100;
        jumlahBarang++;

        String[][] users = {
                { "april", "111" },
                { "gerly", "222" },
                { "jaden", "333" },
        };

        String[] regUserMemb = new String[100];
        String[] regPwMemb = new String[100];

        int jmlUserMemb = 0;
        regUserMemb[jmlUserMemb] = "april";
        regPwMemb[jmlUserMemb] = "12345";
        jmlUserMemb++;
        regUserMemb[jmlUserMemb] = "gerly";
        regPwMemb[jmlUserMemb] = "12345";
        jmlUserMemb++;
        regUserMemb[jmlUserMemb] = "jaden";
        regPwMemb[jmlUserMemb] = "12345";
        jmlUserMemb++;

        boolean halUtama = false;
        do {
            System.out.println(" T-.___________________________________________________.-T");
            System.out.println(" ||                                                     ||");
            System.out.println(" ||   SELAMAT DATANG DI WEBSITE BOOKING GEDUNG SOEHAT   ||");
            System.out.println(" ||        ! Silahkan masuk untuk melanjutkan !         ||");
            System.out.println(" ||                                                     ||");
            System.out.println("<||.---------------------------------------------------.||>");
            System.out.print("\n||> Apakah Anda sudah punya akun ? (y/t) : ");
            akun = input.next();

            if (akun.equalsIgnoreCase("t")) {
                System.out.println("---------------------------------------------------");
                System.out.print("||> Masukkan username baru: ");
                String inputUserBaru = input.next();
                System.out.println("---------------------------------------------------");
                System.out.print("||> Masukkan password baru: ");
                String inputPwBaru = input.next();
                System.out.println("---------------------------------------------------");
                if (jmlUserMemb < regUserMemb.length && jmlUserMemb < regPwMemb.length) {
                    regUserMemb[jmlUserMemb] = inputUserBaru;
                    regPwMemb[jmlUserMemb] = inputPwBaru;
                    jmlUserMemb++;
                    System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                    System.out.println("   ! USER BARU BERHASIL TERDAFTAR !   ");
                    System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-\n");
                } else {
                    System.out.println("\nMohon maaf, jumlah member melebihi batas.");
                }

            } else if (akun.equalsIgnoreCase("y")) {
                boolean choiceMenu = true;
                while (choiceMenu) {
                    do {
                        System.out.println("\n,----------------------------------------------<");
                        System.out.println("|  Selamat Datang di Website Booking Gedung:)  |");
                        System.out.println("|        Silahkan pilih halaman login!         |");
                        System.out.println("|----------------------------------------------|");
                        System.out.println("|   1. Login Admin                             |");
                        System.out.println("|   2. Login Member                            |");
                        System.out.println("|   3. Keluar                                  |");
                        System.out.println("|_____________________________________________/.");
                        System.out.print("||> Masukkan Pilihan Anda 1/2/3 : ");
                        stepLogin = input.nextInt();
                        if (stepLogin < 1 || stepLogin > 3) {
                            System.out.println("\n! Mohon masukkan nomor antara 1 dan 3 !");
                        }
                    } while (stepLogin < 1 || stepLogin > 3);

                    if (stepLogin == 1) {
                        boolean userAdminValid = true;
                        do {
                            System.out.println("\n---------------------------------------------------");
                            System.out.print("||> Masukkan username: ");
                            inputUserAdmin = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Masukkan password: ");
                            inputPwAdmin = input.next();
                            System.out.println("---------------------------------------------------");
                            userAdminValid = false;
                            for (String[] user : users) {
                                if (user[0].equals(inputUserAdmin) && user[1].equals(inputPwAdmin)) {
                                    userAdminValid = true;
                                    break;
                                }
                            }
                            if (userAdminValid) {
                                System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                                System.out.println("          ! LOGIN BERHASIL !          ");
                                System.out.println("       SELAMAT DATANG, ADMIN :)       ");
                                System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                            } else {
                                System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                            }
                        } while (!userAdminValid);

                        boolean choiceAdm = true;
                        while (choiceAdm) {
                            do {
                                System.out.println("\n,----------------------------------<");
                                System.out.println("|            MENU ADMIN            |");
                                System.out.println("|----------------------------------|");
                                System.out.println("|   1. Lihat Data Member           |");
                                System.out.println("|   2. Lihat sisa stok gedung      |");
                                System.out.println("|   3. Tambah stok gedung          |");
                                System.out.println("|   4. Lihat sisa stok barang      |");
                                System.out.println("|   5. Tambah stok barang          |");
                                System.out.println("|   6. Keluar                      |");
                                System.out.println("|_________________________________/.");
                                System.out.print("||> Masukkan Pilihan Anda 1/2/3/4/5/6 : ");
                                menuAdmin = input.nextInt();
                                if (menuAdmin < 1 || menuAdmin > 6) {
                                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 6 !");
                                }
                            } while (menuAdmin < 1 || menuAdmin > 6);
                            switch (menuAdmin) {
                                case 1:
                                    System.out.println("\n-----------------------------------");
                                    System.out.println("Jumlah Member : " + jmlUserMemb);
                                    System.out.println("User member yang telah terdaftar :");
                                    System.out.println("-----------------------------------");
                                    for (int i = 0; i < jmlUserMemb; i++) {
                                        System.out.println("Member ke-" + (i + 1));
                                        System.out.println("Username : " + regUserMemb[i]);
                                        System.out.println("Password : " + regPwMemb[i]);
                                        System.out.println("-----------------------------------");
                                    }
                                    break;
                                case 2:
                                    tampilkanStokGedung();
                                    break;
                                case 3:
                                    tampilkanStokGedung();
                                    System.out.println("\n------------------------------------");
                                    System.out.print("||> Masukkan nama gedung   : ");
                                    String targetGedung = input.next();
                                    System.out.println("------------------------------------");
                                    System.out.print("||> Masukkan tambahan stok : ");
                                    int tambahanStokGd = input.nextInt();
                                    System.out.println("------------------------------------");
                                    tambahStokGedung(targetGedung, tambahanStokGd);
                                    break;
                                case 4:
                                    System.out.println("\n,-------------------------------<");
                                    System.out.println("|     Daftar Barang Tersedia    | ");
                                    System.out.println("|_______________________________|");
                                    System.out.println("| No. | Nama Barang | Stok \t|");
                                    System.out.println("|-----|-------------|-----------|");
                                    for (int i = 0; i < jumlahBarang; i++) {
                                        System.out.println("| " + (i + 1) + ".  | " + namaBarang[i] + "\t    | "
                                                + stokBarang[i] + "\t|");
                                    }
                                    System.out.println("|_____|_____________|__________/.");
                                    break;
                                case 5:
                                    System.out.println("\n,-------------------------------<");
                                    System.out.println("|     Daftar Barang Tersedia    | ");
                                    System.out.println("|_______________________________|");
                                    System.out.println("| No. | Nama Barang | Stok \t|");
                                    System.out.println("|-----|-------------|-----------|");
                                    for (int i = 0; i < jumlahBarang; i++) {
                                        System.out.println("| " + (i + 1) + ".  | " + namaBarang[i] + "\t    | "
                                                + stokBarang[i] + "\t|");
                                    }
                                    System.out.println("|_____|_____________|__________/.");
                                    System.out.println("\n------------------------------------");
                                    System.out.print("||> Masukkan nama barang   : ");
                                    String targetBarang = input.next();
                                    System.out.println("------------------------------------");
                                    System.out.print("||> Masukkan tambahan stok : ");
                                    int tambahanStok = input.nextInt();
                                    System.out.println("------------------------------------");
                                    tambahStokBarang(targetBarang, tambahanStok);
                                    break;
                                case 6:
                                    choiceMenu = true;
                                    choiceAdm = false;
                                    halUtama = false;
                                    break;
                            }
                        }
                    } else if (stepLogin == 2) {
                        boolean userMemberValid;
                        do {
                            System.out.println("\n---------------------------------------------------");
                            System.out.print("||> Masukkan username : ");
                            inputUserMember = input.next();
                            System.out.println("---------------------------------------------------");
                            System.out.print("||> Masukkan password : ");
                            inputPwMember = input.next();
                            System.out.println("---------------------------------------------------");
                            userMemberValid = false;
                            for (int i = 0; i < jmlUserMemb; i++) {
                                if (inputUserMember.equals(regUserMemb[i]) && inputPwMember.equals(regPwMemb[i])) {
                                    userMemberValid = true;
                                    break;
                                }
                            }
                            if (userMemberValid) {
                                System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                                System.out.println("          ! LOGIN BERHASIL !         ");
                                System.out.println("      SELAMAT DATANG, MEMBER :)      ");
                                System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                            } else {
                                System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !");
                            }
                        } while (!userMemberValid);

                        boolean choiceMemb = true;
                        while (choiceMemb) {
                            do {
                                System.out.println("\n,---------------------------------<");
                                System.out.println("|           MENU MEMBER           |");
                                System.out.println("|---------------------------------|");
                                System.out.println("|   1. Pesan Gedung               |");
                                System.out.println("|   2. Cetak Struk  Booking       |");
                                System.out.println("|   3. Lihat sisa stok gedung     |");
                                System.out.println("|   4. Lihat Sisa Stok barang     |");
                                System.out.println("|   5. Pengecekan barang tersedia |");
                                System.out.println("|   6. Keluar                     |");
                                System.out.println("|________________________________/.");
                                System.out.print("||> Masukkan Pilihan Anda 1/2/3/4/5/6 : ");
                                menuMember = input.nextInt();
                                if (menuMember < 1 || menuMember > 6) {
                                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 6 !");
                                }
                                switch (menuMember) {
                                    case 1:
                                        boolean pilihBarang;
                                        boolean langkahSelanjutnya = true;
                                        boolean gedungDipilih = true;
                                            while (gedungDipilih) {
                                                System.out.println("\n,------------------------------------------<");
                                                System.out.println("|        Daftar Gedung yang tersedia!      |");
                                                System.out.println("|__________________________________________|");
                                                System.out.println("| No. | Nama Gedung | Maks Tamu | Tarif    |");
                                                System.out.println("|-----|-------------|-----------|----------|");
                                                System.out.println("| 1.  | Pernikahan  | 900       | Rp.90000 |");
                                                System.out.println("| 2.  | Olahraga    | 250       | Rp.25000 |");
                                                System.out.println("| 3.  | Kesenian    | 100       | Rp.10000 |");
                                                System.out.println("| 4.  | Auditorium  | 500       | Rp.50000 |");
                                                System.out.println("|_____|_____________|___________|_________/.");
                                                System.out.print("||> Masukkan Pilihan Anda : ");
                                                pilihGedung = input.nextInt();
                                                while (pilihGedung<1 || pilihGedung>4) {
                                                    System.out.println("\n! Pilihan Salah. Mohon masukkan angka antara 1 dan 4 !\n");
                                                    System.out.print("||> Masukkan Pilihan Anda : ");
                                                    pilihGedung = input.nextInt();
                                                }
                                                if (pilihGedung < 1 || pilihGedung > 4) {
                                                    System.out.println("\n.-------------------------------------------.");
                                                    System.out.println("!   Mohon masukkan Angka antara 1 dan 4     !");
                                                    System.out.println("!.-----------------------------------------.!");
                                                }
                                                boolean gedungFiks =true;
                                                while (gedungFiks){
                                                System.out.println("----------------------------------------------------");
                                                System.out.print("||> Jumlah Gedung yang ingin dipesan : ");
                                                inputJumlahPesananGedung=input.nextInt();
                                                if (pilihGedung == 1) {
                                                        if (inputJumlahPesananGedung > 0 && inputJumlahPesananGedung <= stokGedung[0]) {
                                                            jumlahPesanGedung1 += inputJumlahPesananGedung;
                                                            totalPesanGedung += jumlahPesanGedung1;
                                                            cetakGedung += ("\n\t\t  " + namaGedung[0] + "\t" + jumlahPesanGedung1);
                                                            stokGedung[0] -= inputJumlahPesananGedung;
                                                            hargaGedung1=inputJumlahPesananGedung*500000;
                                                            totalTarif+=hargaGedung1;
                                                            gedungDipilih = false;
                                                            System.out.println("\n.----------------------------------.");
                                                            System.out.println("!      ! Pemesanan Berhasil !      !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Gedung: " + namaGedung[0]);
                                                            System.out.println("  Jumlah Dipesan: " + inputJumlahPesananGedung);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                        } else if (inputJumlahPesananGedung>stokGedung[0]){
                                                            System.out.println("\n.----------------------------------.");
                                                            System.out.println("!    ! Gagal Melakukan Pesanan !   !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Stok Tersedia: " + stokGedung[0]);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                            gedungDipilih = false;
                                                            break;
                                                        }else if (inputJumlahPesananGedung < 1) {
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("! Mohon masukkan jumlah gedung minimal 1 !");
                                                            System.out.println("----------------------------------------------------");
                                                            gedungFiks=true;
                                                        }
                                                } else if (pilihGedung == 2) {
                                                    if (inputJumlahPesananGedung > 0 && inputJumlahPesananGedung <= stokGedung[1]) {
                                                            jumlahPesanGedung2 += inputJumlahPesananGedung;
                                                            totalPesanGedung += jumlahPesanGedung2;
                                                            cetakGedung += ("\n\t\t  " + namaGedung[1] + "\t" + jumlahPesanGedung1);
                                                            stokGedung[1] -= inputJumlahPesananGedung;
                                                            hargaGedung2=inputJumlahPesananGedung*400000;
                                                            totalTarif+=hargaGedung2;
                                                            gedungDipilih = false;
                                                            System.out.println("\n.----------------------------------.");
                                                            System.out.println("!      ! Pemesanan Berhasil !      !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Gedung: " + namaGedung[1]);
                                                            System.out.println("  Jumlah Dipesan: " + inputJumlahPesananGedung);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                        } else if (inputJumlahPesananGedung>stokGedung[1]){
                                                            System.out.println("\n.-----------------------------------.");
                                                            System.out.println("!    ! Gagal Melakukan Pesanan !   !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Stok Tersedia: " + stokGedung[1]);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                            gedungDipilih = false;
                                                            break;
                                                        } else if (inputJumlahPesananGedung < 1) {
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("! Mohon masukkan jumlah gedung minimal 1 !");
                                                            System.out.println("----------------------------------------------------");
                                                            gedungFiks=true;
                                                        }
                                                } else if (pilihGedung == 3) {
                                                    if (inputJumlahPesananGedung > 0 && inputJumlahPesananGedung <= stokGedung[2]) {
                                                            jumlahPesanGedung3 += inputJumlahPesananGedung;
                                                            totalPesanGedung += jumlahPesanGedung3;
                                                            cetakGedung += ("\n\t\t  " + namaGedung[2] + "\t" + jumlahPesanGedung3);
                                                            stokGedung[2] -= inputJumlahPesananGedung;
                                                            hargaGedung3=inputJumlahPesananGedung*200000;
                                                            totalTarif+=hargaGedung3;
                                                            gedungDipilih = false;
                                                            System.out.println("\n.----------------------------------.");
                                                            System.out.println("!      ! Pemesanan Berhasil !      !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Gedung: " + namaGedung[2]);
                                                            System.out.println("  Jumlah Dipesan: " + inputJumlahPesananGedung);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                        } else if (inputJumlahPesananGedung>stokGedung[2]){
                                                            System.out.println("\n.-----------------------------------.");
                                                            System.out.println("!    ! Gagal Melakukan Pesanan !   !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Stok Tersedia: " + stokGedung[2]);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                            gedungDipilih = false;
                                                            break;
                                                        } else if (inputJumlahPesananGedung < 1) {
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("! Mohon masukkan jumlah gedung minimal 1 !");
                                                            System.out.println("----------------------------------------------------");
                                                            gedungFiks=true;
                                                        }
                                                } else if (pilihGedung == 4) {
                                                    if (inputJumlahPesananGedung > 0 && inputJumlahPesananGedung <= stokGedung[3]) {
                                                            jumlahPesanGedung4 += inputJumlahPesananGedung;
                                                            totalPesanGedung += jumlahPesanGedung4;
                                                            cetakGedung += ("\n\t\t  " + namaGedung[3] + "\t" + jumlahPesanGedung4);
                                                            stokGedung[3] -= inputJumlahPesananGedung;
                                                            hargaGedung4=inputJumlahPesananGedung*300000;
                                                            totalTarif+=hargaGedung4;
                                                            gedungDipilih = false;
                                                            System.out.println("\n.----------------------------------.");
                                                            System.out.println("!      ! Pemesanan Berhasil !      !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Gedung: " + namaGedung[3]);
                                                            System.out.println("  Jumlah Dipesan: " + inputJumlahPesananGedung);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                        } else if (inputJumlahPesananGedung>stokGedung[3]){
                                                            System.out.println("\n.-----------------------------------.");
                                                            System.out.println("!    ! Gagal Melakukan Pesanan !   !");
                                                            System.out.println("!.---------------------------------!");
                                                            System.out.println("  Stok Tersedia: " + stokGedung[3]);
                                                            System.out.println(".-----------------------------------.\n");
                                                            gedungFiks=false;
                                                            gedungDipilih = false;
                                                            break;
                                                        } else if (inputJumlahPesananGedung < 1) {
                                                            System.out.println("----------------------------------------------------");
                                                            System.out.println("! Mohon masukkan jumlah gedung minimal 1 !");
                                                            System.out.println("----------------------------------------------------");
                                                            gedungFiks=true;
                                                        }
                                                }
                                                System.out.println("----------------------------------------------------");
                                                System.out.print("||> Masukkan Nama Anda : ");
                                                nama = input.next();
                                                namaPemesan+=nama;
                                                input.nextLine();
                                                System.out.print("||> Masukkan No. Telepon : ");
                                                noTelp = input.next();
                                                noTelpPemesan+=noTelp;
                                                input.nextLine();
                                                System.out.print("||> Masukkan Tanggal Acara (DD-MM-YYY) : ");
                                                tgl = input.next();
                                                tglPemesan+=tgl;
                                                input.nextLine();

                                                do {
                                                    System.out.print("||> Masukkan Jumlah Tamu : ");
                                                    jumlahTamu = input.nextInt();
                                                    
                                                    if (jumlahTamu <1 || jumlahTamu> 900) {
                                                        System.out.println("----------------------------------------------------");
                                                        System.out.println("! Mohon masukkan jumlah tamu antara 1 dan 900 !");
                                                    } else {
                                                        tamuPemesan+=jumlahTamu;
                                                        tarif = jumlahTamu * 90000;
                                                        totalTarif += tarif;
                                                    }
                                                } while (jumlahTamu < 1 || jumlahTamu > 900);
                                                boolean sewaBarangLagi = true;
                                                while (sewaBarangLagi) {
                                                    System.out.println("----------------------------------------------------");
                                                    System.out.print("||> Apakah Anda ingin menyewa barang tambahan? (y/t) : ");
                                                    String inputSewaBarang = input.next();
                                                    System.out.println("----------------------------------------------------");

                                                    while (!inputSewaBarang.equalsIgnoreCase("y") && !inputSewaBarang.equalsIgnoreCase("t")) {
                                                        System.out.println("\n! Pilihan Salah. Mohon masukkan huruf y atau t !");
                                                        System.out.println("\n----------------------------------------------------");
                                                        System.out.print("||> Apakah Anda ingin menyewa barang tambahan? (y/t) : ");
                                                        inputSewaBarang = input.next();
                                                        System.out.println("----------------------------------------------------");
                                                    }

                                                    if (inputSewaBarang.equalsIgnoreCase("y")) {
                                                        pilihBarang = true;
                                                        while (pilihBarang) {
                                                            do {
                                                                System.out.println("\n,--------------------------------------------------<");
                                                                System.out.println("|              Daftar Barang yang tersedia!        |");
                                                                System.out.println("|__________________________________________________|");
                                                                System.out.println("| No. | Nama Barang | Harga          | Jumlah Stok |");
                                                                System.out.println("|-----|-------------|----------------|-------------|");
                                                                System.out.println("| 1.  | Meja        | Rp.10000/pcs   | 10000       |");
                                                                System.out.println("| 2.  | Kursi       | Rp.5000/pcs    | 10000       |");
                                                                System.out.println("| 3.  | Karpet      | Rp.7000/pcs    | 10          |");
                                                                System.out.println("| 4.  | Sound       | Rp.200000/pcs  | 5           |");
                                                                System.out.println("| 5.  | Mic         | Rp.50000/pcs   | 10          |");
                                                                System.out.println("|_____|_____________|________________|____________/.");
                                                                System.out.print("||> Masukkan Pilihan Anda 1/2/3/4/5 : ");
                                                                menuGedung = input.nextInt();
                                                                pilihBarang = false;
                                                                if (menuGedung < 1 || menuGedung > 5) {
                                                                    System.out.println("\n! Pilihan Salah.Mohon masukkan angka antara 1 dan 4 !\n");
                                                                }
                                                                
                                                                System.out.println("----------------------------------------------------");
                                                                switch (menuGedung) {
                                                                    case 1:
                                                                       System.out.print("||> Jumlah Meja yang akan dipesan : ");
                                                                        jumlahPesananMeja = input.nextInt();
                                                                        if (jumlahPesananMeja > 0 && jumlahPesananMeja <= stokBarang[0]) {
                                                                            totalPesanMeja+=jumlahPesananMeja;
                                                                            cetakBarang+="\n\t\t  "+namaBarang[0]+"   : \t"+totalPesanMeja;
                                                                            stokBarang[0] -= jumlahPesananMeja;
                                                                            hargaMeja = jumlahPesananMeja * 10000;
                                                                            totalTarif += hargaMeja;
                                                                            System.out.println("Pesanan Meja diterima.");
                                                                        } else {
                                                                            System.out.println("Stok Meja tidak mencukupi untuk pesanan tersebut.");
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        System.out.print("||> Jumlah Kursi yang akan dipesan : ");
                                                                        jumlahPesananKursi = input.nextInt();
                                                                        if (jumlahPesananKursi > 0 && jumlahPesananKursi <= stokBarang[1]) {
                                                                            totalPesanKursi+=jumlahPesananKursi;
                                                                            cetakBarang+="\n\t\t  "+namaBarang[1]+"  : \t"+totalPesanKursi;
                                                                            stokBarang[1] -= jumlahPesananKursi;
                                                                            hargaKursi = jumlahPesananKursi * 5000;
                                                                            totalTarif += hargaKursi;
                                                                            System.out.println("Pesanan Kursi diterima.");
                                                                        } else {
                                                                            System.out.println("Stok Meja tidak mencukupi untuk pesanan tersebut.");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        System.out.print("||> Jumlah Karpet yang akan dipesan : ");
                                                                        jumlahPesananKarpet = input.nextInt();
                                                                        if (jumlahPesananKarpet > 0 && jumlahPesananKarpet <= stokBarang[2]) {
                                                                            totalPesanKarpet+=jumlahPesananKarpet;
                                                                            cetakBarang+="\n\t\t  "+namaBarang[2]+" : \t"+totalPesanKarpet;
                                                                            stokBarang[2] -= jumlahPesananKarpet;
                                                                            hargaKarpet = jumlahPesananKarpet * 7000;
                                                                            totalTarif += hargaKarpet;
                                                                            System.out.println("Pesanan Karpet diterima.");
                                                                        } else {
                                                                            System.out.println("Stok Meja tidak mencukupi untuk pesanan tersebut.");
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        System.out.print("||> Jumlah Sound yang akan dipesan : ");
                                                                        jumlahPesananSound = input.nextInt();
                                                                        if (jumlahPesananSound > 0 && jumlahPesananSound <= stokBarang[3]) {
                                                                            totalPesanSound+=jumlahPesananSound;
                                                                            cetakBarang+="\n\t\t  "+namaBarang[3]+"  : \t"+totalPesanSound;
                                                                            stokBarang[3] -= jumlahPesananSound;
                                                                            hargaSound = jumlahPesananSound * 200000;
                                                                            totalTarif += hargaSound;
                                                                            System.out.println("Pesanan Sound diterima.");
                                                                        } else {
                                                                            System.out.println("Stok Meja tidak mencukupi untuk pesanan tersebut.");
                                                                        }
                                                                        break;
                                                                    case 5:
                                                                        System.out.print("||> Jumlah Mic yang akan dipesan : ");
                                                                        jumlahPesananMic = input.nextInt();
                                                                        if (jumlahPesananMic > 0 && jumlahPesananMic <= stokBarang[4]) {
                                                                            totalPesanMic+=jumlahPesananMic;
                                                                            cetakBarang+="\n\t\t  "+namaBarang[4]+"    : \t"+totalPesanMic+"\n";
                                                                            stokBarang[4] -= jumlahPesananMic;
                                                                            hargaMic = jumlahPesananMic * 50000;
                                                                            totalTarif += hargaMic;
                                                                            System.out.println("Pesanan Mic diterima.");
                                                                        } else {
                                                                            System.out.println("Stok Meja tidak mencukupi untuk pesanan tersebut.");
                                                                        }
                                                                        break;
                                                                    default:
                                                                        break;
                                                                }
                                                            } while (menuGedung < 1 || menuGedung > 5);
                                                            sewaBarangLagi=true;
                                                        }continue;
                                                    } else if(inputSewaBarang.equalsIgnoreCase("t")){
                                                        sewaBarangLagi=false;
                                                        continue;
                                                    }
                                                }
                                        boolean metodeBayar = false;
                                        while (!metodeBayar) {
                                            do {
                                                System.out.println("\n,-------------------------------------------------------------------<");
                                                System.out.println("|                        METODE PEMBAYARAN!                         |");
                                                System.out.println("|___________________________________________________________________|");
                                                System.out.println("| No.| VIA                      | No.Rek/No.telp | Atas nama        |");
                                                System.out.println("|----|--------------------------|----------------|------------------|");
                                                System.out.println("| 1. | BRI/BNI/BCA              | 2341760195     | Gerly Vaeyungfan |");
                                                System.out.println("| 2. | DANA/ShopeePay/LinkAja   | 085604054712   | Gerly Vaeyungfan |");
                                                System.out.println("|____|__________________________|________________|_________________/.");
                                                System.out.print("||> Pilih Metode Pembayaran 1/2 : ");
                                                inputamuPemesanetodePembayaran = input.nextInt();
                                                metodeBayar=true;
                                                if (inputamuPemesanetodePembayaran < 1 || inputamuPemesanetodePembayaran > 2) {
                                                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 2 !");
                                                }
                                            } while (inputamuPemesanetodePembayaran < 1 || inputamuPemesanetodePembayaran > 2);
                                            switch (inputamuPemesanetodePembayaran) {
                                                case 1:
                                                    boolean isKode1Valid = false;
                                                    do {
                                                        System.out.println("\nKode verivikasi dikirim melalui SMS");
                                                        System.out.println("\n----------------------------------------------------");
                                                        System.out.print("Masukkan kode verivikasi : ");
                                                        inputKodeVerivPil1 = input.next();
                                                        System.out.println("\n----------------------------------------------------");
                                                        isKode1Valid = false;
                                                        for (String kode : kodeVeriv) {
                                                            if (inputKodeVerivPil1.equals(kode)) {
                                                                isKode1Valid = true;
                                                                metodeBayar=true;
                                                                break;
                                                            }
                                                        }
                                                        if (!isKode1Valid) {
                                                            System.out.println("\n! Kode verivikasiikasi Salah. Silahkan coba lagi !");
                                                        }
                                                    } while (!isKode1Valid);
                                                    break;
                                                case 2:
                                                    boolean isKode2Valid = false;
                                                    do {
                                                        System.out.println("\nKode verivikasiikasi dikirim melalui SMS");
                                                        System.out.println("\n----------------------------------------------------");
                                                        System.out.print("||> Masukkan Kode verivikasi : ");
                                                        inputKodeVerivPil2 = input.next();
                                                        System.out.println("------------------------------------------------------");
                                                        isKode2Valid = false;
                                                        for (String kode : kodeVeriv) {
                                                            if (inputKodeVerivPil2.equals(kode)) {
                                                                isKode2Valid = true;
                                                                metodeBayar=true;
                                                                break;
                                                            }
                                                        }
                                                        if (!isKode2Valid) {
                                                            System.out.println("|n! Kode verivikasiikasi Salah. Silahkan coba lagi !");
                                                        } else {
                                                            langkahSelanjutnya = true;
                                                        }
                                                    } while (!isKode2Valid);
                                            }
                                        }
                                        
                                                do {
                                                System.out.print("||> Apakah Anda ingin melakukan pemesanan lagi? (y/t) : ");
                                                inputPesanLagi = input.next();
                                                if (inputPesanLagi.equalsIgnoreCase("t")) {
                                                    gedungDipilih = false;
                                                    sewaBarangLagi = false;
                                                    pilihBarang = false;
                                                    break;
                                                } else if (inputPesanLagi.equalsIgnoreCase("y")) {
                                                    gedungDipilih = true;
                                                    sewaBarangLagi = false;
                                                    pilihBarang = false;
                                                    break;
                                                } while (!inputPesanLagi.equalsIgnoreCase("y")||!inputPesanLagi.equalsIgnoreCase("t"));
                                            } while (!gedungDipilih);
                                    }
                                }
                                        break;
                                    case 2:
                                        cetakStruk(cetakGedung, namaPemesan, noTelpPemesan, tglPemesan, tamuPemesan, cetakBarang, totalTarif, totalPesanGedung);
                                        break;
                                    case 3:
                                        tampilkanStokGedung();
                                        choiceMemb = true;
                                        break;
                                    case 4:
                                        System.out.println("\n,-------------------------------<");
                                        System.out.println("|     Daftar Barang Tersedia    | ");
                                        System.out.println("|_______________________________|");
                                        System.out.println("| No. | Nama Barang | Stok \t|");
                                        System.out.println("|-----|-------------|-----------|");
                                        for (int i = 0; i < jumlahBarang; i++) {
                                            System.out.println("| " + (i + 1) + ".  | " + namaBarang[i] + "\t    | "+ stokBarang[i] + "\t|");
                                        }
                                        System.out.println("|_____|_____________|__________/.");
                                        choiceMemb = true;
                                        break;
                                    case 5:
                                        System.out.println("\n----------------------------------------------------");
                                        System.out.print("||> Masukkan nama barang : ");
                                        String targetBarang = input.next();
                                        System.out.println("----------------------------------------------------");
                                        cekStokBarang(targetBarang);
                                        break;
                                    case 6:
                                        choiceMenu = true;
                                        choiceMemb = false;
                                        halUtama = false;
                                        break;
                                }
                            } while (menuMember < 1 || menuMember > 6);
                        }
                    } else if (stepLogin == 3) {
                        System.out.println();
                        choiceMenu = false;
                        halUtama = true;
                    }
                }
            } else if (!akun.equalsIgnoreCase("y") || !akun.equalsIgnoreCase("t")) {
                System.out.println("\n! Pilihan tidak tersedia. Mohon masukkan huruf y/t !\n");
            }

        } while (!akun.equalsIgnoreCase("y") || !akun.equalsIgnoreCase("t"));
    }

    

    static void tampilkanStokGedung() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Sisa Stok Gedung :");
        for (int i = 0; i < jumlahGedung; i++) {
            System.out.println((i + 1) + ". " + namaGedung[i] + "\t: " + stokGedung[i]);
        }
        System.out.println("----------------------------------------------------");
    }

    public static void cariNamaBarang(String targetNamaBarang) {
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
        boolean isGedungFound = false;

        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetGedung)) {
                isGedungFound = true;
                System.out.println("\n.---------------------------------.");
                System.out.println("!       ! Gedung Tersedia !       !");
                System.out.println("!.-------------------------------.!");
                break;
            }
        }

        if (!isGedungFound) {
            System.out.println("\n.-----------------------------------.");
            System.out.println("!     ! Gedung Tidak Tersedia !     !");
            System.out.println("!.---------------------------------.!");
        }
    }

    public static void tambahStokGedung(String targetGedung, int tambahanStokGd) {
        boolean isGedungTersedia = false;
        int indeks = -1;

        for (int i = 0; i < jumlahGedung; i++) {
            if (namaGedung[i].equalsIgnoreCase(targetGedung)) {
                isGedungTersedia = true;
                indeks = i;
                break;
            }
        }

        if (isGedungTersedia) {
            stokGedung[indeks] += tambahanStokGd;
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

    public static void tambahStokBarang(String targetBarang, int tambahanStok) {
        boolean isBarangTersedia = false;
        int index = -1;

        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetBarang)) {
                isBarangTersedia = true;
                index = i;
                break;
            }
        }

        if (isBarangTersedia) {
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

    public static void tambahGedung(String cetakGedung, int stokGd) {
        if (jumlahGedung < namaGedung.length && jumlahGedung < stokGedung.length) {
            namaGedung[jumlahGedung] = cetakGedung;
            stokGedung[jumlahGedung] = stokGd;
            jumlahGedung++;
        } else {
            System.out.println("\nMohon maaf, jumlah gedung melebihi batas.");
        }
    }

    public static void tambahBarang(String namaBrg, int stokBrg) {
        if (jumlahBarang < namaBarang.length && jumlahBarang < stokBarang.length) {
            namaBarang[jumlahBarang] = namaBrg;
            stokBarang[jumlahBarang] = stokBrg;
            jumlahBarang++;
        } else {
            System.out.println("\nMohon maaf, jumlah barang melebihi batas.");
        }
    }

    public static void cekStokBarang(String targetBarang) {
        boolean isBarangTersedia = false;
        int index = -1;
        for (int i = 0; i < jumlahBarang; i++) {
            if (namaBarang[i].equalsIgnoreCase(targetBarang)) {
                isBarangTersedia = true;
                index = i;
                break;
            }
        }
        if (isBarangTersedia) {
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

    public static void cetakStruk(String cetakGedung, String namaPemesan, String noTelpPemesan, String tglPemesan, int tamuPemesan,
                                  String cetakBarang, long totalTarif, int totalPesanGedung) {
        System.out.println("-------------------------------------------\n");
        System.out.println("\t   BOOKING GEDUNG SOEHAT\n");
        System.out.println("---------Informasi Pemesanan Anda!---------");
        System.out.println("\t\t\t\tqty");
        System.out.println("Nama Gedung     : " + (cetakGedung));
        System.out.println("Atas Nama       : " + namaPemesan);
        System.out.println("No. Telepon     : " + noTelpPemesan);
        System.out.println("Tanggal         : " + tglPemesan);
        System.out.println("Jumlah Tamu     : " + tamuPemesan);
        System.out.println("Barang tambahan : " + (cetakBarang));
        System.out.println("Total Biaya     : Rp." + totalTarif);
        System.out.println("Total Gedung    : " + totalPesanGedung);
        System.out.println("------------------------------------------");
        System.out.println("\t  Jl. Soekarno Hatta No.9");
        System.out.println("      Kel. Jatimulyo, Kec. Lowokwaru");
        System.out.println("\t      MALANG 65141");
        System.out.println("------------------------------------------\n");
    }

}
