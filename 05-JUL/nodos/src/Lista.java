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
  public void anexarFinalList (int dato){
    Nodo nuevo ;
    nuevo=new Nodo(dato);
    if (primero==null){
        primero=nuevo;
        ultimo=nuevo;
        } else {
            ultimo.setEnlace(nuevo);
            ultimo=nuevo;
            ultimo.setEnlace(null);
        }
    }
  
}