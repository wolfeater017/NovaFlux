package audio;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.openal.AL;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


import runtime.Loader;

public class AudioPlayer {
	
	
	private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	private static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void addSound(String key, String path){
		try {
			soundMap.put(key, new Sound(Loader.Audio(path)) );
		} catch (SlickException e) {
			System.out.println("Invalid Audio File: " + Loader.Audio(path).toString());
			e.printStackTrace();
		}
	}
	
	public static void addMusic(String key, String path){
		try {
			musicMap.put(key, new Music(Loader.Audio(path)) );
		} catch (SlickException e) {
			System.out.println("Invalid Audio File: " + Loader.Audio(path).toString());
			e.printStackTrace();
		}
	}
	
	public static Sound getSound(String key){
		return soundMap.get(key);
	}
	
	public static Music getMusic(String key){
		return musicMap.get(key);
	}
	
	public static void playSoundEffect(String key){
		soundMap.get(key).play();
	}
	
	public static void playMusic(String key){
		musicMap.get(key).play();
	}
	
	public static void loopMusic(String key){
		musicMap.get(key).loop();
	}
	
	public static void destroy(){
		
		for(Sound s : soundMap.values())
			s.stop();
		for(Music m: musicMap.values())
			m.stop();
		
		AL.destroy();
	}
	
	
	
	
	
	
	
	
	

}