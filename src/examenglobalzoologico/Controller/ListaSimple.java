package examenglobalzoologico.Controller;

import examenglobalzoologico.Model.Ave;

public class ListaSimple {
    
    private Nodo inicio;
    private int longitudLista;

    public int getLongitudLista() {
        return longitudLista;
    }
    
    public ListaSimple() {
        inicio = null;
        longitudLista = 0;
    }
    
    public boolean estaVacia() {
        return inicio == null;
    }
    
    public void insertarNodoFinal (Ave ave) {
        Nodo nuevo = new Nodo();
        nuevo.setElemento(ave);
        
        if(estaVacia()) {
            inicio = nuevo;
        } else {
            Nodo auxiliar = inicio;
            while(auxiliar.getSiguienteNodo() != null)
                auxiliar = auxiliar.getSiguienteNodo();
            auxiliar.setSiguienteNodo(nuevo);
        }
        longitudLista++;
    }
    
    public Ave obtenerValor(String valor, boolean esNombre) {
        if(esNombre){
            Nodo auxiliar = inicio;
            if(inicio.getElemento().getNombre().equals(valor))
                return inicio.getElemento();
            do {
                auxiliar = auxiliar.getSiguienteNodo();
                if(auxiliar.getElemento().getNombre().equals(valor))
                    return auxiliar.getElemento();
            } while(auxiliar.getSiguienteNodo() != null);
            
        } else {
            // Se buscara por especie
            Nodo auxiliar = inicio;
            if(inicio.getElemento().getEspecie().equals(valor))
                return inicio.getElemento();
            do {
                auxiliar = auxiliar.getSiguienteNodo();
                if(auxiliar.getElemento().getEspecie().equals(valor))
                    return auxiliar.getElemento();
            } while(auxiliar.getSiguienteNodo() != null);
        }
        return new Ave();
    }
    
    public String obtenerValorPorIndice(int indice) {
        Nodo auxiliar = inicio;
        if (indice == 0) return inicio.getElemento().toString();
        for(int i = 0; i < indice; i++) {
            auxiliar = auxiliar.getSiguienteNodo();
        }
        return auxiliar.getElemento().toString();
    }
    
    public void eliminarNodoPorNombre(String valor) {
        // Eliminacion inicio
        if(inicio.getElemento().getNombre().equals(valor)) {
            inicio = inicio.getSiguienteNodo();
            longitudLista--;
        } else {
            Nodo anterior = inicio;
            Nodo auxiliar = inicio.getSiguienteNodo();
            while(!auxiliar.getElemento().getNombre().equals(valor)) {
                anterior = auxiliar;
                if(auxiliar.getSiguienteNodo() != null)
                    auxiliar = auxiliar.getSiguienteNodo();
            }
            anterior.setSiguienteNodo(auxiliar.getSiguienteNodo()); 
            longitudLista--;
        }
    }
}
