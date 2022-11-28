package MusicPackage;

public class addMusicList implements Command {
    private addDeleteMyList musiclist;
    
    public addMusicList(addDeleteMyList musiclist) {
        this.musiclist = musiclist;
    }
    
    public void execute() {
        musiclist.addList();
    }
}
