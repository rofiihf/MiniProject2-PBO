/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.AbstractMember;
import model.Member;
import model.PremiumMember;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenWarnet implements CRUDService {

    private static final ArrayList<AbstractMember> daftarMember = new ArrayList<>();

    // Method untuk mengecek apakah nomor PC sudah dipakai oleh member lain
    private boolean isNomorPCAvailable(int nomorPC) {
        for (AbstractMember member : daftarMember) {
            if (member.getNomorPC() == nomorPC) {
                return false; // Nomor PC sudah digunakan oleh member lain
            }
        }
        return true; // Nomor PC tersedia
    }

    @Override
    public void tambahMember(AbstractMember member) {
        if (isNomorPCAvailable(member.getNomorPC())) {
            daftarMember.add(member);
            System.out.println("Member berhasil ditambahkan!");
        } else {
            System.out.println("Nomor PC sudah dipakai oleh member lain. Silakan gunakan nomor PC yang berbeda.");
        }
    }

    @Override
    public void lihatDaftarMember() {
        if (daftarMember.isEmpty()) {
            System.out.println("Belum ada member.");
        } else {
            System.out.println("Daftar Member:");
            for (AbstractMember m : daftarMember) {
                System.out.println(m.toString());
            }
        }
    }

    @Override
    public void updateMember(String username) {
        Scanner scanner = new Scanner(System.in);
        for (AbstractMember m : daftarMember) {
            if (m.getUsername().equals(username)) {
                System.out.println("Masukkan data baru (ketik 0 jika tidak ingin mengubah):");
                System.out.print("Username baru: ");
                String newUsername = scanner.nextLine();
                if (!newUsername.equals("0")) m.setUsername(newUsername);

                System.out.print("Password baru: ");
                String newPassword = scanner.nextLine();
                if (!newPassword.equals("0")) m.setPassword(newPassword);

                System.out.print("Durasi baru (dalam jam): ");
                int newDurasi = scanner.nextInt();
                if (newDurasi != 0) m.setDurasi(newDurasi);

                System.out.print("Nomor PC baru: ");
                int newNomorPC = scanner.nextInt();
                
                // Mengecek apakah nomor PC baru sudah dipakai atau belum
                if (newNomorPC != 0) {
                    if (isNomorPCAvailable(newNomorPC)) {
                        m.setNomorPC(newNomorPC);
                        System.out.println("Nomor PC berhasil diperbarui.");
                    } else {
                        System.out.println("Nomor PC sudah dipakai oleh member lain.");
                    }
                }

                System.out.println("Member berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Member tidak ditemukan.");
    }

    @Override
    public void hapusMember(String username) {
        AbstractMember memberDihapus = null;
        for (AbstractMember m : daftarMember) {
            if (m.getUsername().equals(username)) {
                memberDihapus = m;
                break;
            }
        }

        if (memberDihapus != null) {
            daftarMember.remove(memberDihapus);
            System.out.println("Member " + username + " berhasil dihapus.");
        } else {
            System.out.println("Member tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        ManajemenWarnet manajemenWarnet = new ManajemenWarnet();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Manajemen Member Warnet ===");
            System.out.println("1. Tambah Regular Member");
            System.out.println("2. Tambah Premium Member");
            System.out.println("3. Lihat Daftar Member");
            System.out.println("4. Update Member");
            System.out.println("5. Hapus Member");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();
                    System.out.print("Masukkan durasi (dalam jam): ");
                    int durasi = scanner.nextInt();
                    System.out.print("Masukkan nomor PC: ");
                    int nomorPC = scanner.nextInt();
                    Member memberBaru = new Member(username, password, durasi, nomorPC);
                    manajemenWarnet.tambahMember(memberBaru);
                    break;
                case 2:
                    System.out.print("Masukkan username: ");
                    String premiumUsername = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String premiumPassword = scanner.nextLine();
                    System.out.print("Masukkan durasi (dalam jam): ");
                    int premiumDurasi = scanner.nextInt();
                    System.out.print("Masukkan nomor PC: ");
                    int premiumNomorPC = scanner.nextInt();
                    PremiumMember premiumMember = new PremiumMember(premiumUsername, premiumPassword, premiumDurasi, premiumNomorPC);
                    manajemenWarnet.tambahMember(premiumMember);
                    break;
                case 3:
                    manajemenWarnet.lihatDaftarMember();
                    break;
                case 4:
                    System.out.print("Masukkan username member yang ingin di-update: ");
                    String usernameUpdate = scanner.nextLine();
                    manajemenWarnet.updateMember(usernameUpdate);
                    break;
                case 5:
                    System.out.print("Masukkan username member yang ingin dihapus: ");
                    String usernameHapus = scanner.nextLine();
                    manajemenWarnet.hapusMember(usernameHapus);
                    break;
                case 6:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Manajemen Member.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}

