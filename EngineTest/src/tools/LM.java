package tools;

import java.awt.image.BufferedImage;

import audio.AudioPlayer;
import runtime.Loader;
import tools.ProgressBar;

public class LM extends Loader{
	
	public static BufferedImage BBBTITLE,BLOB_A,BLOB_B,BLOB_C,BLOB_D,BLOB_E,
	BLOB_A2,BLOB_B2,BLOB_C2,BLOB_D2;
	
	public static MapProcessor RANDOM_MAP,MAZE_MAP;
	public static String SOUND_SUCCESS,MUSIC_CASTLEMANIA;
	
	public LM(){ super(null); }
	
	public LM( ProgressBar pb){ super(pb);  }

	@Override
	protected void init() {
		pb.Update(0.01);
		
		//load everything necessary for the loading screen but nothing more
		
		BBBTITLE = Loader.resImage("Title.png");
		MUSIC_CASTLEMANIA = "MusicCastleMania";
		AudioPlayer.addMusic(MUSIC_CASTLEMANIA, "background.ogg");
	}
	
	private void firstThird(){
		
		BLOB_A = Loader.resImage("OvalMan/A.png");
		BLOB_B = Loader.resImage("OvalMan/B.png");
		BLOB_C = Loader.resImage("OvalMan/C.png");
		BLOB_D = Loader.resImage("OvalMan/D.png");
		BLOB_E = Loader.resImage("OvalMan/E.png");
		BLOB_A2 = Loader.resImage("OvalMan/A2.png");
		BLOB_B2 = Loader.resImage("OvalMan/B2.png");
		BLOB_C2 = Loader.resImage("OvalMan/C2.png");
		BLOB_D2 = Loader.resImage("OvalMan/D2.png");
		this.UpdateProgress(.33);
	}
	
	private void secondThird(){
		
		RANDOM_MAP = new MapProcessor( Loader.resImage("RandomMap.png") );
		MAZE_MAP = new MapProcessor( Loader.resImage("Maze.png") );
		this.UpdateProgress(.66);
	}
	
	private void thirdThird(){
		SOUND_SUCCESS = "SoundSuccess";
		AudioPlayer.addSound(SOUND_SUCCESS, "Success.ogg");
		
		this.UpdateProgress(1.0);
	}

	@Override
	protected void LoadingSegments() throws Exception {
		// Load additional information but update progress percentage in between
//		Thread.sleep(1000);
		firstThird();
//		Thread.sleep(1000);
		secondThird();
//		Thread.sleep(1000);
		thirdThird();
		
	}
	
	@Override
	protected void UpdateProgress(double Progress) {
		super.UpdateProgress(Progress);
		if(pb!=null)
			pb.Update(Progress);
	}
	

}

