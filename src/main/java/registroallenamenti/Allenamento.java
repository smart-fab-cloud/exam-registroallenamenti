package registroallenamenti;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe di rappresentazione di un allenamento.
 * 
 * Consente di rappresentare le risorse scambiate tra client
 * e servizio (ovvero i dati riguardanti un allenamento).
 */
public class Allenamento {
    
    // Nickname utente
    private String nickname;
    // Data allenamento
    // (Si assuma che sia nel formato "gg-mm-aaaa")
    private String data;
    // Tipologia allenamento
    private String tipologia;
    // Durata allenamento (in minuti) 
    private int durata;
    // Calorie consumate (in kcal)
    private int calorie;
    
    public Allenamento() {
        // Ci pensa Jackson
    }

    
    public Allenamento(
            String nickname, 
            String data, 
            String tipologia, 
            int durata, 
            int calorie) {
        this.nickname = nickname;
        this.data = data;
        this.tipologia = tipologia;
        this.durata = durata;
        this.calorie = calorie;
    }

    @JsonProperty
    public String getNickname() {
        return nickname;
    }

    @JsonProperty
    public String getData() {
        return data;
    }


    @JsonProperty
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @JsonProperty
    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @JsonProperty
    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }
    
    
}
