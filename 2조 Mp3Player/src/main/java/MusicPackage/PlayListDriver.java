package MusicPackage;

import java.util.Scanner;

public class PlayListDriver {

    String id;

    public PlayListDriver(String id) {
        this.id = id;
        System.out.println("@@@플레이리스트@@@\n");

        System.out.println("0 : 리스트추가/삭제 1 : 리스트 음악 추가/삭제 "
                + "2 : 플레이리스트 목록/리스트 음악정보 출력 3 : 종료\n");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        switch (select) {
            case 0:
                selectZero();
                break;
            case 1:
                selectOne();
                break;
            case 2:
                selectTwo();
                break;
            case 3:
                System.out.println("종료");
                break;
        }
    }

    public void selectZero() {
        PlayList listCommand = new PlayList();
        addDeleteMyList mylist = new addDeleteMyList(id);
        addMusicList addmusiclist = new addMusicList(mylist);
        deleteMusicList deletemusiclist = new deleteMusicList(mylist);
        listCommand.setCommand(0, addmusiclist, deletemusiclist);

        System.out.println("리스트 1 : 추가 2 : 삭제");
        Scanner listSc = new Scanner(System.in);
        int list = listSc.nextInt();
        if (list == 1) {
            listCommand.runAddCommand(0);
        } else if (list == 2) {
            listCommand.runDeleteCommand(0);
        }
    }

    public void selectOne() {
        PlayList musicCommand = new PlayList();
        addDeleteMyMusic mymusic = new addDeleteMyMusic(id);
        addMusicOnList addmusiconlist = new addMusicOnList(mymusic);
        deleteMusicOnList deletemusiconlist = new deleteMusicOnList(mymusic);
        musicCommand.setCommand(1, addmusiconlist, deletemusiconlist);

        System.out.println("음악 1 : 추가 2 : 삭제");
        Scanner musicSc = new Scanner(System.in);
        int music = musicSc.nextInt();
        if (music == 1) {
            musicCommand.runAddCommand(1);
        } else if (music == 2) {
            musicCommand.runDeleteCommand(1);
        }
    }

    public void selectTwo() {
        PlayList showCommand = new PlayList();
        showMyList showmylist = new showMyList(id);
        showMusic showmusic = new showMusic(showmylist);
        showMusicList showmusiclist = new showMusicList(showmylist);
        showCommand.setCommand(2, showmusic, showmusiclist);

        System.out.println("1 : 선택한 리스트의 음악 목록 출력 2 : 리스트 목록 출력");
        Scanner showSc = new Scanner(System.in);
        int show = showSc.nextInt();
        if (show == 1) {
            showCommand.runAddCommand(2);
        } else if (show == 2) {
            showCommand.runDeleteCommand(2);
        }
    }
}
