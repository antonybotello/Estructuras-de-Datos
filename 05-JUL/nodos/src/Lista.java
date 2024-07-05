public class Lista {
  
  private Nodo primero;
  private Nodo ultimo;

  
  public Lista() {
    this.primero = null;
    this.ultimo = null;

    
  }


  public Nodo getPrimero() {
    return primero;
  }


  public void setPrimero(Nodo primero) {
    this.primero = primero;
  }


  public Nodo getUltimo() {
    return ultimo;
  }


  public void setUltimo(Nodo ultimo) {
    this.ultimo = ultimo;
  }

 

  
}