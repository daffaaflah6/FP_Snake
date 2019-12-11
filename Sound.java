import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip EAT = Applet.newAudioClip(Sound.class.getResource("eat.wav"));
	public static final AudioClip LEVELUP = Applet.newAudioClip(Sound.class.getResource("levelup.wav"));
	public static final AudioClip PLAY = Applet.newAudioClip(Sound.class.getResource("game.wav"));
}