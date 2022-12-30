/*
    ATTENZIONE : DALLA RIGA 6 FINO ALLA 36 E' IL COMPITO CHE HO FATTO. LE ALTRE RIGHE SONO PER LA GRAFICA, QUINDI SE SI VUOLE VEDERE SOLO IL COMPITO BASTA TOGLIERE IL COMMENTO DALLA RIGHE 6-36
 */


/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParcoVeicolo parco1 = new ParcoVeicolo();  //creo un nuovo parco veicoli
        Scanner input = new Scanner(System.in); 
        String targa, marca, modello; //creo le variabili che mi servono per inserire i dati
        int n_posti, codice; //creo le variabili che mi servono per inserire i dati
        Veicolo v;  //creo un nuovo veicolo
        
        //inserisco i dati
        for(int i = 0; i < parco1.getNumMaxMezzi(); i++){
            System.out.println("Inserisci targa della macchina " + (i+1) + ": ");
            targa = input.nextLine();
            System.out.println("Inserisci marca della macchina " + (i+1) + ": ");
            marca = input.nextLine();
            System.out.println("Inserisci modello della macchina " + (i+1) + ": ");
            modello = input.nextLine();
            System.out.println("Inserisci numero posti della macchina " + (i+1) + ": ");
            n_posti = input.nextInt();
            input.nextLine();
            v = new Veicolo(targa, marca, modello, n_posti); //creo un nuovo veicolo con i dati inseriti
            codice = parco1.setVeicolo(v); //inserisco il veicolo nel parco veicoli
            if(codice == -1){ //se il parco è pieno esco dal ciclo
                System.out.println("Parco pieno");
                break;
            }
        }

    }
}
*/

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Main {
    public static void main(String[] args) {
        List<Veicolo> veicoli = new ArrayList<>();

        //crea la finestra
        JFrame frame = new JFrame("Parco Veicoli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        //crea il pannello
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel);

        // creo la scroll bar
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);


        // crea i campi di testo
        JTextField targaField = new JTextField();
        JTextField marcaField = new JTextField();
        JTextField modelloField = new JTextField();
        JTextField postiField = new JTextField();

        // aggiunge i campi di testo al pannello
        panel.add(new JLabel("Targa:"));
        panel.add(targaField);
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modello:"));
        panel.add(modelloField);
        panel.add(new JLabel("Numero posti:"));
        panel.add(postiField);

        // crea il bottone per aggiungere un veicolo
        JButton addButton = new JButton("Aggiungi veicolo");
        panel.add(addButton);

        // quando clicco invio si attiva il bottone
        frame.getRootPane().setDefaultButton(addButton);
        // quando clicco il bottone si attiva il campo di testo targa
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                targaField.requestFocusInWindow();
            }
        });
        //q: dove posso mettere scrollpane per farlo scrollare? //a: non so se è possibile farlo scrollare con il gridlayout ma puoi provare a mettere un layout diverso e vedere se funziona 
        // quando clicco il bottone si aggiunge un veicolo alla lista
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text fields
                String targa = targaField.getText();
                String marca = marcaField.getText();
                String modello = modelloField.getText();
                int posti = Integer.parseInt(postiField.getText());

                // crea un nuovo veicolo
                Veicolo v = new Veicolo(targa, marca, modello, posti);

                // Aggiunge il veicolo alla lista
                veicoli.add(v);

                // Cancella i campi di testo
                targaField.setText("");
                marcaField.setText("");
                modelloField.setText("");
                postiField.setText("");
            }
        });

        // Crea il bottone per stampare i veicoli
        JButton printButton = new JButton("Stampa veicoli");
        panel.add(printButton);

        // Cancella il pannello e stampa i veicoli
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                int count = 0;
                for (Veicolo v : veicoli) {
                    // conta i veicoli
                    count++;
                    // stampa i veicoli
                    panel.add(new JLabel("|                Veicolo: " + count));
                    panel.add(new JLabel("|                Targa: " + v.getTarga()));
                    panel.add(new JLabel("|                Marca: " + v.getMarca()));
                    panel.add(new JLabel("|                Modello: " + v.getModello()));
                    panel.add(new JLabel("|                Numero posti: " + v.getNPosti()));
                    panel.add(new JLabel("----------------------------------------------- "));
                }
            }
        });
    } 
}

