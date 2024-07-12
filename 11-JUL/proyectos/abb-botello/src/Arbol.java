public class Arbol {
    private Nodo raiz;
    private Nodo p;
    private Nodo q;

    public Arbol(Persona persona) {
        this.raiz = new Nodo();
        this.p = new Nodo();
        this.raiz.setIzqNodo(null);
        this.raiz.setDerNodo(null);
        this.raiz.setPersona(persona);
        this.p = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void anexarNodo(Persona persona) {
        if (raiz.getPersona() == null) {
            raiz.setPersona(persona);
        } else {
            p = raiz;
            q = p;
            while (q != null && p.getPersona() != persona) {
                p = q;
                if (persona.getFecha() != determinarMayor(persona, p.getPersona()).getFecha()) {
                    q = q.getIzqNodo();
                } else {
                    q = q.getDerNodo();
                }
                if (p.getPersona().getFecha() == persona.getFecha()) {
                    System.out.println("Fechas Iguales");
                }
            }
            if (determinarMayor(persona, p.getPersona()) == p.getPersona()) {

                insertarIzquierda(p, persona);
            } else {
                insertarDerecha(p, persona);
            }
        }
    }

    public void insertarIzquierda(Nodo r, Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.setPersona(persona);
        nuevo.setIzqNodo(null);
        nuevo.setDerNodo(null);
        r.setIzqNodo(nuevo);
    }

    public void insertarDerecha(Nodo r, Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.setPersona(persona);
        nuevo.setIzqNodo(null);
        nuevo.setDerNodo(null);
        r.setDerNodo(nuevo);
    }

    public void buscarElemlento(String nombre, Nodo r) {
        if (r == null) {
            System.out.println(" persona no encontrada");
            return;
        }
        if (r.getPersona().getNombre() == nombre) {
            System.out.println(" persona encontrada");
            return;
        } else {
            Persona paux = new Persona();
            if (determinarMayor(r.getPersona(), paux) == paux)
                buscarElemlento(nombre, r.getDerNodo());
            else
                buscarElemlento(nombre, r.getIzqNodo());
        }
    }

    public void imprimirPreOrden(Nodo p) {
        if (p != null) {
            System.out.print(" " + p.getPersona().getNombre());
            imprimirPreOrden(p.getIzqNodo());
            imprimirPreOrden(p.getDerNodo());
        }
    }

    public void imprimirPostOrden(Nodo p) {
        if (p != null) {
            imprimirPostOrden(p.getIzqNodo());
            imprimirPostOrden(p.getDerNodo());
            System.out.print(" " + p.getPersona().getNombre());
        }
    }

    public void imprimirInOrden(Nodo p) {
        if (p != null) {
            imprimirInOrden(p.getIzqNodo());
            System.out.print(" " + p.getPersona().getNombre());
            imprimirInOrden(p.getDerNodo());
        }
    }

    public Persona determinarMayor(Persona p1, Persona p2) {
        int[] fecha1 = p1.getFecha();
        int[] fecha2 = p2.getFecha();

        if (fecha1[2] < fecha2[2]) {
            return p1;
        } else if (fecha1[2] == fecha2[2]) {
            if (fecha1[1] < fecha2[1]) {
                return p1;
            } else if (fecha1[1] == fecha2[1]) {
                if (fecha1[0] < fecha2[0]) {
                    return p1;
                } else {
                    return p2;
                }

            } else {
                return p2;
            }
        } else {
            return p2;
        }

    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getP() {
        return p;
    }

    public void setP(Nodo p) {
        this.p = p;
    }

    public Nodo getQ() {
        return q;
    }

    public void setQ(Nodo q) {
        this.q = q;
    }

}
