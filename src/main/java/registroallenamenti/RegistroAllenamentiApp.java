package registroallenamenti;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Classe di esecuzione del servizio.
 * 
 * La classe utilizza la configurazione indicata attraverso il file 
 * di configurazione passato.
 */
public class RegistroAllenamentiApp extends Application<RegistroAllenamentiConfig> {

    // Metodo main eseguibile (avvia il server che esegue il servizio)
    public static void main(String[] args) throws Exception {
        new RegistroAllenamentiApp().run(args);
    }
    
    @Override
    public void run(RegistroAllenamentiConfig c, Environment e) throws Exception {
        // Creazione di una risorsa REST "ps" di tipo "PuntiSpesa"
        final RegistroAllenamenti ra = new RegistroAllenamenti(c.getTipologiaDefault());
        
        // Registrazione della risorsa "ps" sul server di esecuzione
        e.jersey().register(ra);
    }
    
    
    
}
