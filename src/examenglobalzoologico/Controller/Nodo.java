
package examenglobalzoologico.Controller;

import examenglobalzoologico.Model.Ave;

public class Nodo {
    private Ave elemento;
    private Nodo siguienteNodo;

    public Nodo() {
        this.elemento = null;
        this.siguienteNodo = null;
    }

    public Ave getElemento() {
        return elemento;
    }

    public void setElemento(Ave elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}
