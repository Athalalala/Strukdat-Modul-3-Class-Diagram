import java.util.Scanner;

abstract class Rental {
    protected int id;

    public Rental(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void header() {
        System.out.println("=== DATA RENTAL PS ===");
    }

    public abstract void info();
}


class Pelanggan extends Rental {
    private String nama;
    private String noHP;

    public Pelanggan(int id, String nama, String noHP) {
        super(id);
        this.nama = nama;
        this.noHP = noHP;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void info() {
        System.out.println("ID    : " + id);
        System.out.println("Nama  : " + nama);
        System.out.println("No HP : " + noHP);
    }
}


class SesiMain extends Rental {
    private String jam;
    private int durasi;

    public SesiMain(int id, String jam, int durasi) {
        super(id);
        this.jam = jam;
        this.durasi = durasi;
    }

    @Override
    public void info() {
        System.out.println("ID      : " + id);
        System.out.println("Jam     : " + jam);
        System.out.println("Durasi  : " + durasi + " jam");
    }
}


class Pembayaran extends Rental {
    private double total;

    public Pembayaran(int id, double total) {
        super(id);
        this.total = total;
    }

    @Override
    public void info() {
        System.out.println("ID    : " + id);
        System.out.println("Total : Rp " + String.format("%,.0f", total));
    }
}


public class MainApp {

    static Scanner input = new Scanner(System.in);

    static Pelanggan[] dataPelanggan = new Pelanggan[100];
    static SesiMain[] dataSesi = new SesiMain[100];
    static Pembayaran[] dataBayar = new Pembayaran[100];

    static int jmlPelanggan = 0;
    static int jmlSesi = 0;
    static int jmlBayar = 0;

    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("\n=== SISTEM RENTAL PS ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Tambah Sesi Main");
            System.out.println("3. Tambah Pembayaran");
            System.out.println("4. Tampilkan Semua");
            System.out.println("5. Cari Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1: tambahPelanggan(); break;
                case 2: tambahSesi(); break;
                case 3: tambahPembayaran(); break;
                case 4: tampilSemua(); break;
                case 5: cariData(); break;
                case 0: System.out.println("Keluar..."); break;
                default: System.out.println("Input tidak valid!");
            }

        } while (pilih != 0);
    }

    static void tambahPelanggan() {
        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("No HP: ");
        String noHP = input.nextLine();

        dataPelanggan[jmlPelanggan++] = new Pelanggan(id, nama, noHP);
    }

    static boolean cekID(int id) {
        for (int i = 0; i < jmlPelanggan; i++) {
            if (dataPelanggan[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    static void tambahSesi() {
        System.out.print("ID Pelanggan: ");
        int id = input.nextInt();
        input.nextLine();

        if (!cekID(id)) {
            System.out.println("ID tidak ditemukan!");
            return;
        }

        System.out.print("Jam mulai: ");
        String jam = input.nextLine();

        System.out.print("Durasi (jam): ");
        int durasi = input.nextInt();

        dataSesi[jmlSesi++] = new SesiMain(id, jam, durasi);
    }

    static void tambahPembayaran() {
        System.out.print("ID Pelanggan: ");
        int id = input.nextInt();

        if (!cekID(id)) {
            System.out.println("ID tidak ditemukan!");
            return;
        }

        System.out.print("Total bayar: ");
        double total = input.nextDouble();

        dataBayar[jmlBayar++] = new Pembayaran(id, total);
    }

    static void tampilSemua() {
        if (jmlPelanggan == 0) {
            System.out.println("Belum ada data!");
            return;
        }

        for (int i = 0; i < jmlPelanggan; i++) {
            int id = dataPelanggan[i].getId();

            System.out.println("\n-------------------");
            dataPelanggan[i].header();
            System.out.println("DATA PELANGGAN");
            dataPelanggan[i].info();

            for (int j = 0; j < jmlSesi; j++) {
                if (dataSesi[j].getId() == id) {
                    System.out.println(">> SESI MAIN");
                    dataSesi[j].info();
                }
            }

            for (int j = 0; j < jmlBayar; j++) {
                if (dataBayar[j].getId() == id) {
                    System.out.println(">> PEMBAYARAN");
                    dataBayar[j].info();
                }
            }

            System.out.println("-------------------");
        }
    }

    static void cariData() {
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();

        boolean ditemukan = false;

        for (int i = 0; i < jmlPelanggan; i++) {
            if (dataPelanggan[i].getId() == id) {
                ditemukan = true;

                System.out.println("\n=== HASIL ===");
                dataPelanggan[i].header();
                dataPelanggan[i].info();

                for (int j = 0; j < jmlSesi; j++) {
                    if (dataSesi[j].getId() == id) {
                        dataSesi[j].info();
                    }
                }

                for (int j = 0; j < jmlBayar; j++) {
                    if (dataBayar[j].getId() == id) {
                        dataBayar[j].info();
                    }
                }
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan!");
        }
    }
}