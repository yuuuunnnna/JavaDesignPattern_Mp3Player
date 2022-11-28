/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author dbswl
 */
import MusicPackage.*;
import management.*;
import login.*;
import information.*;
import buyticket.BuywantTicket;
import Search.*;
import PlaySystem.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu { // 기능들 메뉴 

    private static String id;
    private static boolean isAdmin;
    private static String music;
    private static String period;

    public static void main(String args[]) throws IOException {

        Login login = new Login(); // 로그인
        id = login.getId();
        isAdmin = login.getisAdmin();
        music = login.getMusic();
        period = login.getPeriod();

        if (isAdmin == true) { // 관리자로 로그인 하였을 때 메뉴
            Admin();

        } else { // 일반 사용자로 로그인 하였을 때 메뉴
            Normal();
        }

    }

    public static void Admin() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String c;
        System.out.println("===================================================");
        System.out.println("관리자 " + id + "님" + "  원하시는 기능을 선택해 주세요");
        System.out.println("1. 사용자 관리  2. 음악 추가  (숫자로 입력해주세요) (로그아웃: q)");
        System.out.print(">>");
        c = in.readLine();

        switch (c) {
            case ("1"):
                ManageMain manage = new ManageMain(id);
                Admin();
                break;
            case ("2"):
                BuilderPattern makemusic = new BuilderPattern();

                System.out.println("=========================");
                System.out.println("새로운 음악을 추가합니다.");
                System.out.println("=========================");
                makemusic.constructMusic();
                System.out.println("다음과 같은 새로운 음악이 추가되었습니다.");
                Admin();
                break;
            case ("q"):
                System.out.println("관리자"+id+"님, 로그아웃합니다.");
                break;
            default:
                System.out.println("다시 입력해 주세요");
                Admin();
                break;
        }
    }

    public static void Normal() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String c;
        System.out.println("===================================================");
        System.out.println("일반사용자 " + id + "님의 남은 잔여 이용권 : 횟수: " + music + "회 / 기간: " + period + "일   원하시는 기능을 선택해 주세요");
        System.out.println("1. 음악검색  2. 이용권 구매 3. 플레이리스트 추가/삭제/목록  4. 음악 재생 (숫자로 입력해주세요) (로그아웃: q)");
        System.out.print(">>");
        c = in.readLine();
        System.out.println("===================================================");
        switch (c) {
            case ("1"):
                Search search = new Search();
                search.ChangeState();
                Normal();
                break;
            case ("2"):
                BuywantTicket buy = new BuywantTicket(id);
                music = Login.getMusic();
                period = Login.getPeriod();
                Normal();
                break;
            case ("3"): // 플레이리스트
                PlayListDriver playlistdriver = new PlayListDriver(id);
                Normal();
                break;
            case ("4"): // 음악 재생
                MainPlaySystem mainplaysystem = new MainPlaySystem(id, music);
                music = Login.getMusic();
                period = Login.getPeriod();
                Normal();
                break;
            case ("q"):
                System.out.println("일반사용자"+id+"님, 로그아웃합니다.");
                break;
            default:
                System.out.println("다시 입력해 주세요");
                Normal();
                break;
        }
    }

}
