/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author dbswl
 */
public class Manage extends SubjectManage {

    private List<Person> member = new ArrayList<>();
    
 public Manage(){
     observers = new ArrayList<>();
     
 }
    public List<Person> getMemberNames() {
        return member;
    }
 
    public void addMemberName(Person person) {  // 사용자 추가
        this.member.add(person);
        
    }
        public void deleteMemberName(String id) { // 사용자 삭제
        
        member.removeIf(i->i.getId().equals(id)); //removeIf 사용
        notifyuser();
    }
        public void addUser(Person person){  // 사용자 등록
         this.member.add(person);
        notifyuser();
        }
   
    @Override
    public void registeruser(Observer view) { // Observer 객체 등록
        observers.add(view);
        
    }

    @Override
    public void deleteuser(Observer view) {  // Observer 객체 삭제
       observers.remove(view);
       notifyuser();
    }

    @Override
    public void notifyuser() { // 변경사실을 알림
       observers.stream().forEach(data -> {
            data.update();
        });
    }
    
    public void setUser(String id, String passwd, String name,boolean isAdmin){ // 변경
        for(Person m : member){
            if(m.getId().equals(id)){
                m.setPasswd(passwd);
                m.setName(name);
            }
        }
        notifyuser();
    }
}


