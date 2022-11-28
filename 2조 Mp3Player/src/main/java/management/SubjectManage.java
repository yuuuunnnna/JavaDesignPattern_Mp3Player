/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbswl
 */
public abstract class SubjectManage {
    protected List<Observer> observers;
            
    protected List<Person> member;
    
    public abstract void registeruser(Observer view);
    public abstract void deleteuser(Observer view);
    public abstract void notifyuser();
    public abstract void addMemberName(Person person);
    public abstract void deleteMemberName(String id);
    public abstract void addUser(Person person);
}
 


