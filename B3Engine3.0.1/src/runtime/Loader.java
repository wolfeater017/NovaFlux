package runtime;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

import tools.ProgressBar;

public abstract class Loader extends SwingWorker<Object, Object>{
	
	protected double Progress = 0;
	protected static ProgressBar pb;
	protected static Long threadId;
	
	public Loader(ProgressBar pb){
		Loader.pb = pb;
		init();
		execute();
		
	}
	/**
	 * 
	 * @return-ProgressBar- associated with Loader thread if one exists
	 */
	public static ProgressBar getProgressBar(){ return pb; }
	
	
	/**
	 * Updates Progress of Loading
	 * @param Progress
	 */
	protected void UpdateProgress(double Progress){
		this.Progress = Progress;
		if(pb!=null)
			pb.Update(this.Progress);
	}
	/**
	 * This method is called before thread is started.
	 * If there are any Items that need to be loaded Immediately this is the place
	 */
	protected abstract void init();
	/**
	 * is called within worker thread. All items to be loaded should be put here
	 * @throws Exception
	 */
	protected abstract void LoadingSegments() throws Exception;
	
	@Override
	protected Object doInBackground() throws Exception {
		
		threadId = Thread.currentThread().getId();
		Thread.sleep(200);
		LoadingSegments();
		
		
		return null;
	}
	/*
	 * Early Termination of Worker Thread
	 */
	@SuppressWarnings("deprecation")
	public static void End(){
		
		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);
		for (Thread t: threads) { 
		    if (t.getId() == threadId) { t.stop();}
		}
	}
	/**
	 * Use this method to load a BufferedImage
	 * @param name
	 * @return
	 */
	public static BufferedImage resImage(String name){
		String path = "/Res/Images/";
		try{
			return ImageIO.read( Loader.class.getResourceAsStream(path + name) );
		}catch(IOException e ){
			e.printStackTrace();
			System.out.println("Invalid Image path: " + path + name );
		}
		return null;
	}
	
	public static URL resAudio(String name){
		return Loader.class.getResource("/Res/Audio/" + name);
	}

}