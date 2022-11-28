
package information;

abstract class Musicinformation {
  private String name;
  private String time;
  private String artist;
  private String type;
  private String genre;
  private String date;

   public Musicinformation(String name, String time, String artist, String type,
          String genre, String date) {
      this.name = name;
      this. time = time;
      this. artist = artist;
      this.type = type;
      this.genre=genre;
      this.date=date;
  }

  public String getName() {
      return name;
  }

  public String getTime() {
      return time;
  }

  public String getArtist() {
      return artist;
  }

  public String getType() {
      return type;
  }

  public String getGenre() {
      return genre;
  }

  public String getDate() {
      return date;
  }

   public String getMusicInfo() {
      String musicInfo =String.format(" 제목:%s\n 재생시간:%s\n 아티스트::%s\n 곡유형:%s\n 장르:%s\n 발매일 :%s\n"
      , name,time,artist,type,genre,date);
      return musicInfo;
  }


}
