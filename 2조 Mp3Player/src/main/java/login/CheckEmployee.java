/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author dbswl
 */
public class CheckEmployee implements Authority {
    
    public void getidentify(String id){
        System.out.println("관리자계정 확인되었습니다. "+id+"로 로그인합니다.");
    }
}
