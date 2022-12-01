package pattern.adapter;

public class Main {
	public static void main(String[] args) {
		MediaPlayer player = new MP3();
		
		player.play("adapter 예시.mp3");
		
		MediaPlayer MP4player = new FormatAdapter(new MP4());
		
		MP4player.play("게임 영상.mp4");
		
		
	}
}
