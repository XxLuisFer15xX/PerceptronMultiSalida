package test;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.Voice;


public class NewClass1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("mbrola.base", "C:\\Users\\Luis Fernando\\Desktop\\mbrola\\mbrola\\mbrola");
        VoiceManager manager =  VoiceManager.getInstance();
        Voice voz = manager.getVoice("mbrola_us1");// se puede usar voz mbrola_us1,mbrola_us2, mbrola_us3 kevin16
        voz.allocate();
            voz.speak("ayer fui al supermercado ");
           /* for(int i=0; i<=10;i++){
            voz.speak(Integer.toString(i));
            }*/
            voz.deallocate();
        
        
  
    }
    
}