/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

/**
 *
 * @author dbswl
 */
public class Person {

    private boolean isAdmin;
    private String name;
    private String id;
    private String passwd;
    private String countMusic;
    private String Period;

    public Person(String id, String passwd, String name, boolean isAdmin, String countMusic, String Period) {
        this.isAdmin = isAdmin;
        this.name = name;
        this.passwd = passwd;
        this.id = id;
        this.countMusic = countMusic;
        this.Period = Period;
    }

    public boolean getisAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getcountMusic() {
        return countMusic;
    }

    public String getPeriod() {
        return Period;
    }

    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
