package examenglobalzoologico.Model;

public class Animal {
    
    protected String especie;
    protected String nombre;
    protected float peso;
    protected int numeroJaula;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float edad) {
        this.peso = edad;
    }

    public int getNumeroJaula() {
        return numeroJaula;
    }

    public void setNumeroJaula(int numeroJaula) {
        this.numeroJaula = numeroJaula;
    }

    public Animal(String especie, String nombre, float peso, int numeroJaula) {
        this.especie = especie;
        this.nombre = nombre;
        this.peso = peso;
        this.numeroJaula = numeroJaula;
    }

    public Animal() {}   
}
