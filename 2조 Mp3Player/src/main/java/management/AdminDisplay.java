/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.List;

/**
 *
 * @author dbswl
 */
public class AdminDisplay implements Observer,DisplayUser {
    private Manage member;
 
    public AdminDisplay(Manage member) {
        this.member = member;
    }

 
    @Override
    public void update() {
        display(member.getMemberNames());
    }
 
    @Override
    public void display(List<Person> members) {
        members.stream().forEach((data) -> {
            if (data.getisAdmin()) {
                 System.out.println("관리자 "+" 아이디 : " + data.getId()+" 비밀번호 : " + data.getPasswd()+" 이름 : " + data.getName());
            }
        });
    }
 
}


