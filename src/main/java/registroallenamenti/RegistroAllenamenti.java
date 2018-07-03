package registroallenamenti;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

/**
 * Classe che implementa il servizio REST RegistroAllenamenti.
 * 
 * Il servizio è offerto al path "/allenamenti".
 */
@Path("/allenamenti")
@Produces(MediaType.APPLICATION_JSON)
public class RegistroAllenamenti {
    
    // Tipologia predefinita di allenamento
    // (da usare se "tipologia" non è indicata)
    private String tipologiaDefault;
    
    // Mappa per la memorizzazione degli allenamenti
    // (la chiave univoca è data dalla concatenazione di nickname e data)
    Map<String,Allenamento> allenamenti;
    
    public RegistroAllenamenti(String tipologiaDefault) {
        this.tipologiaDefault = tipologiaDefault;
        
        this.allenamenti = new HashMap();
    }
    
    // Metodo POST per l'aggiunta di un nuovo allenamento
    // (dati passati attraverso un JSON contenuto nel body della richiesta)
    @POST
    public Response postAllenamento(Allenamento all) {

        String idAll = all.getNickname() + all.getData();
        
        // Se esiste già un allenamento con nickname e data indicati
        if (allenamenti.containsKey(idAll))
            // Restituisce un messaggio di errore "409 Conflict"
            return Response.status(Status.CONFLICT)
                    .entity("Allenamento già registrato.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();

        // Se "tipologia" non è specificata, utilizza il valore predefinito
        if (all.getTipologia().isEmpty())
            all.setTipologia(tipologiaDefault);
        
        // Aggiunge il nuovo allenamento
        allenamenti.put(idAll, all);
        
        // Restituisce "201 Created" (con info su allenamento aggiunto)
        URI allUri = UriBuilder.fromResource(RegistroAllenamenti.class)
                        .path(idAll)
                        .build();
        return Response.created(allUri).build();
    }
}
