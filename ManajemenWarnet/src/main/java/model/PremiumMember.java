/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class PremiumMember extends Member {

    public PremiumMember(String username, String password, int durasi, int nomorPC) {
        super(username, password, durasi, nomorPC);
    }

    @Override
    public String getMembershipType() {
        return "Premium Member";
    }

    @Override
    public String toString() {
        return super.toString() + "Jenis Keanggotaan: " + getMembershipType() + "\n";
    }
}
