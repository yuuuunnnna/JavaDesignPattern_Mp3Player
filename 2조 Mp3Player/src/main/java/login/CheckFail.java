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
public class CheckFail implements Authority{
    public void getidentify(String id){
        System.out.println("아이디/비밀번호가 잘못되었습니다. 다시 입력해 주세요.");
    }
}
