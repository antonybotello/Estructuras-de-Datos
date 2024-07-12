public class Nodo {
    private Persona persona; 
    private Nodo izqNodo; 
    private Nodo derNodo;



    
    public Nodo() {
        this.persona = null;
        this.izqNodo = null;
        this.derNodo = null;
    }
    
    public Nodo(Persona persona) {
        this.persona = persona;
        this.izqNodo = null;
        this.derNodo = null;
    }

    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Nodo getIzqNodo() {
        return izqNodo;
    }
    public void setIzqNodo(Nodo izqNodo) {
        this.izqNodo = izqNodo;
    }
    public Nodo getDerNodo() {
        return derNodo;
    }
    public void setDerNodo(Nodo derNodo) {
        this.derNodo = derNodo;
    }

    
}
