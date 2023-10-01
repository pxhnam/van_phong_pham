/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author admin
 */
public class User {

    private static String MaNV;

    public User() {
    }

    public User(String MaNV) {
        User.MaNV = MaNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        User.MaNV = MaNV;
    }
}
