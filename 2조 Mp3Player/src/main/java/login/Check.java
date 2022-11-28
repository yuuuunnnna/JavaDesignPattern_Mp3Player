/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
//import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dbswl
 */
public class Check {
    private String id;
    private String passwd;
    private Authority authority;
    
    public Check(Authority authority){
        this.authority = authority;
    }
    public void get(String id){
        authority.getidentify(id);
    }
    
    
}
