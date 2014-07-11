package audio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import runtime.Loader;
import newdawn.easyogg.OggClip;


/**
 * 
 * @author Ben Bemis
 *
 */
public class OggManager {
	
	private static Map<String,OggClip> oggMap = new HashMap<String,OggClip>();
	
	public static void addOgg(String id, String path){
		try {
			oggMap.put(id, new OggClip( Loader.getInputStream(path) ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static OggClip getOgg(String id){
		return oggMap.get(id);
	}
	
	public static void playOgg(String id){
		oggMap.get(id).play();
	}
	
	public static void pauseOgg(String id){
		oggMap.get(id).pause();
	}
	
	public static void resumeOgg(String id){
		oggMap.get(id).resume();
	}
	
	public static void loopOgg(String id){
		oggMap.get(id).loop();
	}
	
	public static void stopOgg(String id){
		oggMap.get(id).stop();
	}
	
	public static void closeOgg(String id){
		oggMap.get(id).stop();
		oggMap.get(id).close();
		oggMap.remove(id);
	}
	
	public static void destroy(){
		
		for(OggClip o: oggMap.values() )
			o.close();
		System.out.println("ALL BITSTREAMS CLOSED");
		
		oggMap.clear();

	}
	
	
	
	
}
