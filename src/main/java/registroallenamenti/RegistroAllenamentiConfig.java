package registroallenamenti;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Classe di configurazione.
 * 
 * Consente di utilizzare un file di configurazione per settare il 
 * valore default da associare a "tipologia" (quando non specificata).
 * 
 * (Il file di configurazione è "config-registroallenamenti.yml")
 */
public class RegistroAllenamentiConfig extends Configuration {
    
    private String tipologiaDefault;
    
    @JsonProperty
    public String getTipologiaDefault() {
        return tipologiaDefault;
    }
    
    @JsonProperty
    public void setTipologiaDefault(String tipologiaDefault) {
        this.tipologiaDefault = tipologiaDefault;
    }
    
}
