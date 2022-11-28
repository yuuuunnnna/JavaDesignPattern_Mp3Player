package MusicPackage;

public class deleteMusicList implements Command{
    private addDeleteMyList musiclist;
    
    public deleteMusicList(addDeleteMyList musiclist) {
        this.musiclist = musiclist;
    }
    
    public void execute() {
        musiclist.deleteList();
    }
}
