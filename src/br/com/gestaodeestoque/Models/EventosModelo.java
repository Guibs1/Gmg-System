package br.com.gestaodeestoque.Models;

public class EventosModelo {
    
    private String evento_titulo;
    private String data_inicio;
    private String evento_desc;
    private String evento_data_termino;
    private int eventosProx;

    public int getEventosProx() {
        return eventosProx;
    }

    public void setEventosProx(int eventosProx) {
        this.eventosProx = eventosProx;
    }

    public String getEvento_titulo() {
        return evento_titulo;
    }

    public void setEvento_titulo(String evento_titulo) {
        this.evento_titulo = evento_titulo;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getEvento_desc() {
        return evento_desc;
    }

    public void setEvento_desc(String evento_desc) {
        this.evento_desc = evento_desc;
    }

    public String getEvento_data_termino() {
        return evento_data_termino;
    }

    public void setEvento_data_termino(String evento_data_termino) {
        this.evento_data_termino = evento_data_termino;
    }
    
    
}
