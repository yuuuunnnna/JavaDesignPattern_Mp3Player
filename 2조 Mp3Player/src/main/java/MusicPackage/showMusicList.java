package MusicPackage;

public class showMusicList implements Command{
    private showMyList listshow;
    
    public showMusicList(showMyList listshow) {
        this.listshow = listshow;
    }    
    public void execute() {
        listshow.showList();
    }
}
