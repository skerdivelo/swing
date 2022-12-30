public class ParcoVeicolo {
    private Veicolo[] mezzi;
    private int MAX_NUM_VEICOLI = 1000;
    private int codice;

    public ParcoVeicolo(){
        this.mezzi = new Veicolo[MAX_NUM_VEICOLI];
        this.codice = 0;
    }

    public int setVeicolo(Veicolo v){
        if(this.codice < MAX_NUM_VEICOLI){
            this.mezzi[this.codice] = v;
            this.codice++;
            return this.codice - 1;
        }
        return -1;
    }


    public Veicolo getVeicolo(int codice){
        if(codice < this.codice){
            return this.mezzi[codice];
        }
        return null;
    }

    public Veicolo getVeicolo(String targa){
        for(int i = 0; i < this.codice; i++){
            if(this.mezzi[i].getTarga().equals(targa)){
                return this.mezzi[i];
            }
        }
        return null;
    }

    public int rimuoviVeicolo(int codice){
        if(codice < this.codice){
            this.mezzi[codice] = null;
            return 0;
        }
        return -1;
    }

    public int rimuoviVeicolo(String targa){
        for(int i = 0; i < this.codice; i++){
            if(this.mezzi[i].getTarga().equals(targa)){
                this.mezzi[i] = null;
                return 0;
            }
        }
        return -1;
    }

    public int getNumMezzi(){
        return this.codice;
    }

    public int getNumMaxMezzi(){
        return this.MAX_NUM_VEICOLI;
    }

    public String[] inventarioVeicoliPosti(int posti){
        int i,j;  
        String inventario[]=new String[MAX_NUM_VEICOLI];
        String  marca[]=new String[MAX_NUM_VEICOLI];
        int veicoli[]=new int[MAX_NUM_VEICOLI];
        for (i=0;i<MAX_NUM_VEICOLI;i++)
        if (mezzi[i]!=null){   
            if (mezzi[i].getNPosti()==posti){
                for (j=0;j<500;j++)
                 if (marca[j]==null){
                     marca[j]=new String(mezzi[i].getMarca());
                     veicoli[j]=1;
                     break;
                 }
                 else {
                   if (marca[j].equals(mezzi[i].getMarca())){ 
                     veicoli[j]++;
                     break;
                   }  
                 } 
             }
         }  
        for(j=0;marca[j]!=null;j++)  
         inventario[j]= marca[j]+" --> "+veicoli[j];   
        return inventario;
        //ritorna un array di stringhe che contiene il numero di veicoli di una certa marca con un certo numero di posti
    }

    public String[] inventarioVeicoliMarca(){
        int i,j;  
        String inventario[]=new String[MAX_NUM_VEICOLI];
        String  marca[]=new String[MAX_NUM_VEICOLI];
        int veicoli[]=new int[MAX_NUM_VEICOLI];
        for (i=0;i<MAX_NUM_VEICOLI;i++)
        if (mezzi[i]!=null){   
            for (j=0;j<500;j++)
             if (marca[j]==null){
                 marca[j]=new String(mezzi[i].getMarca());
                 veicoli[j]=1;
                 break;
             }
             else {
               if (marca[j].equals(mezzi[i].getMarca())){ 
                 veicoli[j]++;
                 break;
               }  
             } 
         }
        for(j=0;marca[j]!=null;j++)
            inventario[j]= marca[j]+" --> "+veicoli[j];
        return inventario;
        //ritorna un array di stringhe che contiene il numero di veicoli di una certa marca
    }
}
