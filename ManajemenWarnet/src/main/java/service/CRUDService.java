/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author user
 */
import model.AbstractMember;

public interface CRUDService {
    void tambahMember(AbstractMember member);
    void lihatDaftarMember();
    void updateMember(String username);
    void hapusMember(String username);
}
