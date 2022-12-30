public class Veicolo{
    private String targa;
    private String marca;
    private String modello;
    private int n_posti;

    public Veicolo(String targa, String marca, String modello, int n_posti){
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.n_posti = n_posti;
    }

    public Veicolo(Veicolo v){
        this.targa = v.targa;
        this.marca = v.marca;
        this.modello = v.modello;
        this.n_posti = v.n_posti;
    }

    public String getTarga(){
        return this.targa;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModello(){
        return this.modello;
    }

    public int getNPosti(){
        return this.n_posti;
    }

    public void setTarga(String targa){
        this.targa = targa;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setModello(String modello){
        this.modello = modello;
    }

    public void setNPosti(int n_posti){
        this.n_posti = n_posti;
    }

    public String toString(){
        return "Targa: " + this.targa + " Marca: " + this.marca + " Modello: " + this.modello + " Numero posti: " + this.n_posti;
    }

}