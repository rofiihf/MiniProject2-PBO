/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public abstract class AbstractMember {
    private String username;
    private String password;
    private int durasi;
    private int nomorPC;

    public AbstractMember(String username, String password, int durasi, int nomorPC) {
        this.username = username;
        this.password = password;
        this.durasi = durasi;
        this.nomorPC = nomorPC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public int getNomorPC() {
        return nomorPC;
    }

    public void setNomorPC(int nomorPC) {
        this.nomorPC = nomorPC;
    }

    @Override
    public String toString() {
        return "Username: " + username + "\n" +
               "Password: " + password + "\n" +
               "Durasi: " + durasi + " jam\n" +
               "Nomor PC: " + nomorPC + "\n" +
               "-----------------------------------------";
    }

    // Method abstrak
    public abstract String getMembershipType();
}
