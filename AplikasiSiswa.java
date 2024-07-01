import java.util.Scanner;
class Siswa {
    private String NIS;
    private String Nama;
    private String Kelas;
    private String Alamat;

    public Siswa(String NIS, String Nama, String Kelas, String Alamat) {
        this.NIS = NIS;
        this.Nama = Nama;
        this.Kelas = Kelas;
        this.Alamat = Alamat;
    }

    public String getNis() {
        return NIS;
    }

    public String getNama() {
        return Nama;
    }

    public String getKelas() {
        return Kelas;
    }

    public String getAlamat() {
        return Alamat;
    }

    @Override
    public String toString() {
        return "NIS: " + NIS + ", Nama: " + Nama + ", Kelas: " + Kelas + ", Alamat: " + Alamat;
    }
}

public class AplikasiSiswa {
    private static Siswa[] siswaArray = new Siswa[100];
    private static int jumlahSiswa = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Siswa");
            System.out.println("2. Tampilkan Data Siswa");
            System.out.println("3. Cari Data Siswa Berdasarkan NIS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1:
                    tambahDataSiswa(scanner);
                    break;
                case 2:
                    tampilkanDataSiswa();
                    break;
                case 3:
                    cariDataSiswa(scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    private static void tambahDataSiswa(Scanner scanner) {
        System.out.print("Masukkan NIS: ");
        String NIS = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String Nama = scanner.nextLine();
        System.out.print("Masukkan Kelas: ");
        String Kelas = scanner.nextLine();
        System.out.print("Masukkan Alamat: ");
        String Alamat = scanner.nextLine();

        siswaArray[jumlahSiswa] = new Siswa(NIS, Nama, Kelas, Alamat);
        jumlahSiswa++;
        System.out.println("Data siswa berhasil ditambahkan.");
    }

    private static void tampilkanDataSiswa() {
        if (jumlahSiswa == 0) {
            System.out.println("Tidak ada data siswa.");
            return;
        }
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println(siswaArray[i]);
        }
    }

    private static void cariDataSiswa(Scanner scanner) {
        System.out.print("Masukkan NIS yang dicari: ");
        String NIS = scanner.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < jumlahSiswa; i++) {
            if (siswaArray[i].getNis().equals(NIS)) {
                System.out.println(siswaArray[i]);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Data siswa dengan NIS " + NIS + " tidak ditemukan.");
        }
    }
}
