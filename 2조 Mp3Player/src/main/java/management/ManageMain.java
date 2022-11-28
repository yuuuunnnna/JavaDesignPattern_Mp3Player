/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dbswl
 */
public class ManageMain {

    private static String id;
    private static boolean c;
    private static boolean tempisAdmin;
    private static String temppasswd;
    private static String tempname;
    private static String tempid;
    private static String tempMusic;
    private static String tempPeriod;
    Manage member = new Manage();
    public static String service;
    static int check = 0;
    private static String realId;
    boolean first = true;

    public ManageMain(String id) throws IOException {

        member.registeruser(new AdminDisplay(member));
        member.registeruser(new NormalDisplay(member));
        if (first == true) {
            addData();
            first = false;
        } else {

        }

        System.out.println("사용자 관리입니다.");

        selectService();

    }

    public static void addFile(String tempId, String tempPasswd, String tempName, boolean tempisAdmin) throws IOException { //id_passwd.txt 파일에 사용자 추가

        try {
            BufferedWriter bos = new BufferedWriter(new FileWriter("DB\\id_passwd.txt", true));
            bos.write(tempId + "/" + tempPasswd + "/" + tempName + "/0/0\n");
            bos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //사용자에게 맞는 폴더 생성
        if (tempisAdmin != true) {
            String path = "DB\\playlist\\" + tempId; //폴더 경로
            String fileName = path + "\\information.txt";
            File Folder = new File(path);

            if (!Folder.exists()) {
                try {
                    Folder.mkdir(); //폴더 생성합니다.

                    // 파일 객체 생성
                    File file = new File(fileName);
                    // true 지정시 파일의 기존 내용에 이어서 작성
                    FileWriter fw = new FileWriter(file);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else {

            }
        }

    }

    public void deleteFile(String tempId) { // id_passwd.txt에서 사용자 삭제
        boolean ok = readfile(tempId);

        String dummy = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("DB\\id_passwd.txt"));
            String line;
            for (int i = 0; i < check - 1; i++) {
                line = br.readLine();
                dummy += (line + "\r\n");

            }
            br.readLine();
            while ((line = br.readLine()) != null) {
                dummy += (line + "\r\n");
            }
            FileWriter fw = new FileWriter("DB\\id_passwd.txt");
            fw.write(dummy);
            fw.close();
            br.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        File file = new File("DB\\playlist\\" + tempId);
        if (file.exists()) { //파일존재여부확인
            if (file.isDirectory()) { //파일이 디렉토리인지 확인
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].delete()) {
                        System.out.println(files[i].getName() + " 삭제성공");
                    } else {
                        System.out.println(files[i].getName() + " 삭제실패");
                    }
                }
            }
            if (file.delete()) {
                System.out.println("파일삭제 성공");
            } else {
                System.out.println("파일삭제 실패");
            }
        } else {
            System.out.println("파일이 존재하지 않습니다.");

        }

    }

    public void modifyFile(String tempId, String tempPasswd, String tempName) { // id_passwd.txt 수정
        boolean ok = readfile(tempId);

        String data = tempId + "/" + tempPasswd + "/" + tempName + "/" + tempMusic + "/" + tempPeriod;
        String dummy = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("DB\\id_passwd.txt"));
            String line;
            for (int i = 0; i < check - 1; i++) {
                line = br.readLine();
                dummy += (line + "\r\n");

            }
            br.readLine();
            dummy += data + "\r\n";
            while ((line = br.readLine()) != null) {
                dummy += (line + "\r\n");
            }
            FileWriter fw = new FileWriter("DB\\id_passwd.txt");
            fw.write(dummy);
            fw.close();
            br.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addData() throws IOException { // 옵저버 패턴에 객체 추가

        boolean isAdmin;

        String[] array;

        try {
            File myFile = new File("DB\\id_passwd.txt"); // 사용자의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                // System.out.println("line : " +line);
                array = line.split("/");
                String know = array[0].substring(0, 1);

                if (know == "a") {
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }
                member.addMemberName(new Person(array[0], array[1], array[2], isAdmin, array[3], array[4]));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void selectService() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("===================================================");
        System.out.println("add/modify/delete 중 원하시는 서비스를 입력해 주세요 (사용자관리 종료:q)");
        service = in.readLine();
        if (service.equals("q")) {
            System.out.println("===================================================");
            System.out.println("사용자관리 종료합니다. ");
        } else if (service.equals("modify")) {

            System.out.println("변경하실 id를 입력해 주세요");
            InputUser();
            modifyUser();
        } else if (service.equals("delete")) {
            deleteUser();

        } else if (service.equals("add")) {
            addUserr();
        } else {
            System.out.println("다시 입력해주세요 "); // 반복 추가 해야함
            selectService();
        }
    }

    public boolean InputUser() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(" 아이디  : ");
        id = in.readLine();

        System.out.println("===================================================");

        c = readfile(id); // 등록 확인

        return c; // 등록 확인
    }

    public boolean readfile(String id) { // 등록이 되어있는지 확인
        String str = id;
        Boolean ok = true;
        try {
            File myFile = new File("DB\\id_passwd.txt"); // 사용자의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            if (id.length() == 0) { // 만약 입력하지않았다면 경고문과 로그인 취소    
                return ok;
            }
            String line = null;
            String[] array;
            check = 0;
            while ((line = reader.readLine()) != null && ok == true) {
                // System.out.println("line : " +line);
                array = line.split("/");
                String idp = array[0];

                check++;
                if (idp.equals(str)) { // 일치하는 계정 존재
                    tempid = array[0];
                    temppasswd = array[1];
                    tempname = array[2];
                    tempMusic = array[3];
                    tempPeriod = array[4];
                    ok = false;

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ok;
    }

    public void modifyUser() throws IOException { // 비밀번호, 이름 변경

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String regExp = "^[0-9]+$"; // 숫자랑 문자 허용
        
        if (c == false) {
            System.out.println("변경요청 : 계정정보");
            System.out.println("id : " + tempid + " / passwd : " + temppasswd + " / name : " + tempname);
            System.out.print("변경 요청을 하신 계정정보가 맞으신가요? (yes/no) (사용자관리 종료:q)");
            String check = in.readLine();
            if (check.equals("q")) {
                System.out.println("===================================================");
                System.out.println("사용자관리 종료합니다. ");
            } else if (check.equals("yes")) {

                System.out.println("변경하실 id의 passwd/name을 입력해 주세요");
                System.out.println("id :  " + id);
                System.out.println("8자 이상의 영숫자로 비밀번호를 구성해주세요 ");
                System.out.print("passwd : ");
                temppasswd = in.readLine();
                        if(temppasswd.matches(regExp)&& temppasswd.length()<8){
                            System.out.println("비밀번호를 영숫자를 섞어서 8자 이상 입력해 주세요");
                            modifyUser();
                        }
                System.out.print("name : ");
                tempname = in.readLine();
                System.out.println("===================================================");
                if (id.charAt(0) == 'a') {
                    tempisAdmin = true;
                } else {
                    tempisAdmin = false;
                }

                member.setUser(id, temppasswd, tempname, tempisAdmin);
                modifyFile(id, temppasswd, tempname);
                System.out.println("변경되었습니다.");

            } else {
                System.out.println("다시 입력해주세요"); // 반복 추가
                InputUser();
                modifyUser();
            }
        } else {
            System.out.println("다시 입력해주세요"); // 반복 추가
            InputUser();
            modifyUser();
        }
    }

    public void addUserr() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String regExp = "^[0-9]+$"; // 숫자랑 문자 허용
        
        System.out.println("추가하실 id/passwd/name을 입력해 주세요 ");
        System.out.println("u(일반사용자)/a(관리자) + 숫자 4개의 조합으로 아이디를 구성해주세요 ");
        System.out.print("id :  ");
        tempid = in.readLine();
        if(tempid.charAt(0)!='a' && tempid.charAt(0)!='u'){
            System.out.println("아이디의 권한을 다시 입력해주세요");
            addUserr();
        }
        else if(tempid.length()!=5){
            System.out.println("아이디의 길이를 5자로 지정해주세요");
            addUserr();
        }

        else if(!tempid.matches(regExp)){
            System.out.println("8자 이상의 영숫자로 비밀번호를 구성해주세요 ");
         System.out.print("passwd : ");
        temppasswd = in.readLine();
        if(temppasswd.matches(regExp) || temppasswd.length()<8){
            System.out.println("비밀번호를 영숫자를 섞어서 8자 이상 입력해 주세요");
            addUserr();
        }
        else{
            
        
        System.out.print("name : ");
        tempname = in.readLine();
        System.out.println("===================================================");
        if (tempid.charAt(0) == 'a') {
            tempisAdmin = true;
        } else {
            tempisAdmin = false;
        }
        c = readfile(tempid);
        if (c == false) {
            System.out.println("이미 존재하는 id 입니다. 다시 입력해주세요");
            addUserr();
        } else {
            System.out.println("추가요청 : 계정정보");
            System.out.println("id : " + tempid + " / passwd : " + temppasswd + " / name : " + tempname);
            System.out.print("추가 요청을 하신 계정정보가 맞으신가요? (yes/no) (사용자관리 종료:q)");
            String check = in.readLine();
            if (check.equals("q")) {
                System.out.println("===================================================");
                System.out.println("사용자관리 종료합니다. ");
            } else if (check.equals("yes")) {
                addFile(tempid, temppasswd, tempname, tempisAdmin);
                System.out.println("추가 되었습니다.");
                member.addUser(new Person(tempid, temppasswd, tempname, tempisAdmin, "0", "0"));

            } else {
                System.out.println("다시 입력해주세요");
                addUserr();
            }

        }
        }
        }
        

    }

    public void deleteUser() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        member.notifyuser();
        System.out.println("삭제하실 id를 입력해 주세요");
        InputUser();
        if (c == false) {
            System.out.println("삭제요청 : 계정정보");
            System.out.println("id : " + tempid + " / passwd : " + temppasswd + " / name : " + tempname);
            System.out.print("삭제 요청을 하신 계정정보가 맞으신가요? (yes/no) (사용자관리 종료:q)");
            String check = in.readLine();
            if (check.equals("q")) {
                System.out.println("===================================================");
                System.out.println("사용자관리 종료합니다. ");
            } else if (check.equals("yes")) {
                deleteFile(tempid);
                System.out.println("삭제되었습니다.");
                System.out.println("===================================================");

                member.deleteMemberName(id);
                //deleteData();
            } else {
                System.out.println("다시 입력해주세요");
                deleteUser();
            }
        } else {
            System.out.println("다시 입력해주세요");
            deleteUser();
        }
    }

}
