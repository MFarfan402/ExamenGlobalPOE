package examenglobalzoologico.Model;

public class Ave extends Animal{
    
    private String colorPlumaje;
    private int alturaMaximaVuelo;
    private boolean esHervibora;

    public String getColorPlumaje() {
        return colorPlumaje;
    }

    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    public int getAlturaMaximaVuelo() {
        return alturaMaximaVuelo;
    }

    public void setAlturaMaximaVuelo(int alturaMaximaVuelo) {
        this.alturaMaximaVuelo = alturaMaximaVuelo;
    }

    public boolean getEsHervibora() {
        return esHervibora;
    }

    public void setEsHervibora(boolean esHervibora) {
        this.esHervibora = esHervibora;
    }

    public Ave(String especie, String nombre, float peso, int numeroJaula, 
            String colorPlumaje, int alturaMaximaVuelo, boolean esHervibora) {
        super(especie, nombre, peso, numeroJaula);
        this.colorPlumaje = colorPlumaje;
        this.alturaMaximaVuelo = alturaMaximaVuelo;
        this.esHervibora = esHervibora;
    }
    
    public Ave() {}

    @Override
    public String toString() {
        String tipoAnimal = esHervibora ? "Herviboro" : "Carnivoro";
        return "Especie:\t\t" + especie + 
                "\nNombre:\t\t" + nombre + 
                "\nNumero de Jaula:\t" + numeroJaula + 
                "\nColor de Plumaje:\t" + colorPlumaje + 
                "\n Altura Maxima de Vuelo:\t" + alturaMaximaVuelo + 
                "\nTipo Animal:\t\t" + tipoAnimal + "\n\n";
    }
}
