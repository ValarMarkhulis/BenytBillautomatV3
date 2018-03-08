package automat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author chris & mads
 */
public class Billetautomatv2 {
    private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBilletterSolgtType0; // Antal billetter automaten i alt har solgt
    private int antalBilletterSolgtType1;
    private int antalBilletterSolgtType2;
    private int antalBilletterSolgtType3;
    private int antalBilletterSolgtType4; 
    private boolean montoertilstand;
    private ArrayList<Log_event> event_liste;         // opret liste-variabel
    private Date netopNu; // dato variabel
    private boolean debug = false;
    private ArrayList<Billet> Billetter;  //indkøbskurv
    private int totalIndtjeaning;
        
           
	/**
	 * Opret en billetautomat der saelger billetter til 10 kr.
	 */
	public Billetautomatv2() {

		balance = 0;
		antalBilletterSolgtType0 = 0;
                antalBilletterSolgtType1 = 0;
                antalBilletterSolgtType2 = 0;
                antalBilletterSolgtType3 = 0;
                antalBilletterSolgtType4 = 0;
            event_liste = new ArrayList<Log_event>(); // opret liste-array af "Log_event" objekter
            Billetter = new ArrayList<Billet>();

            netopNu = new Date();
            event_liste.add(new Log_event(1,erMontoer())); // Tilføj "Log_event" objekt til event_listen                
    }

    /**
     * Giver basis prisen for en bestemt type billet. 
     */
    public int getBilletpris(int type) {
            return Billet.getBilletPris(type);
    }

    /**
     * Giver prisen pr zone for en bestemt type billet. 
     */
    public int getBilletprisPerZone(int type) {
            return Billet.getBilletPrisPerZone(type);
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */
    public void indsaetPenge(int beloeb) {
        netopNu = new Date(); // Hent et nyt Date objekt
        if(beloeb > 0){ // Tjek om der bliver indbetalt et gyldigt beloeb
            balance = balance + beloeb;
            event_liste.add(new Log_event(2, beloeb, true, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }else{
            System.out.println("Det indsatte beloeb er ugyldigt.");
            // Timestamp på hvornår et ugyldigt beløb er forsøgt indkastet
            event_liste.add(new Log_event(2, beloeb, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }
    }

    /**
     * Giver balancen (beloebet maskinen har modtaget til den naeste billet).
     * @return 
     */
    public int getBalance() {
            return balance;
    }

    /**
     * Udskriv en billet.
     * @param billet
     */
    private void udskrivBillet(Billet billet) {

            netopNu = new Date(); // Hent et nyt Date objekt
            switch(billet.getType()){
                case 0 :
                    event_liste.add(new Log_event(10, billet.getZoner(), true, erMontoer()));
                    break;
                case 1 :
                    event_liste.add(new Log_event(11, billet.getZoner(), true, erMontoer()));
                    break;
                case 2 :
                    event_liste.add(new Log_event(12, billet.getZoner(), true, erMontoer()));
                    break;
                case 3 :
                    event_liste.add(new Log_event(13, billet.getZoner(), true, erMontoer()));
                    break;
                case 4 :
                    event_liste.add(new Log_event(14, billet.getZoner(), true, erMontoer()));
                    break;
            }

            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.printf("#        %s       #\n", billet.getNavn());
            System.out.printf("#        %d zoner    #\n", billet.getZoner());
            System.out.println("#        " + billet.getPris() + " kr.       #");
            System.out.println("#                     #");
            System.out.println("##########B##T#########");
            System.out.println();
            System.out.println();

    }

    /**
     * Giver penge retur, og udskriver besked herom.
     * @return 
     */
    public int returpenge() {
        int returbeloeb;
        netopNu = new Date(); // Hent et nyt Date objekt

        if(balance < 0){ // Hvis balancen er negativ
            returbeloeb = 0;
            event_liste.add(new Log_event(4,balance,false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }else{ // Hvis balancen er positiv eller 0
            returbeloeb = balance;
            event_liste.add(new Log_event(4,returbeloeb,true, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }
        balance = 0;
        System.out.println("Du faar "+returbeloeb+" kr retur");
        return returbeloeb;
    }

    /**
     * Forsøger at logge ind som montør. Hvis montørtilstanden er true logges der ud.
     * @param String
     */
    void montoerLogin(String adgangskode) {
        netopNu = new Date(); // Hent et nyt Date objekt
        if ("1234".equals(adgangskode)) {
                event_liste.add(new Log_event(5, Integer.parseInt(adgangskode), true, erMontoer())); // Tilføj "Log_event" objekt til event_listen
                montoertilstand = true;
                System.out.println("Montoertilstand aktiveret");
        } else {
                if(montoertilstand == true){ // Hvis montoeren bare logger ud
                    System.out.println("Montoertilstand deaktiveret");
                    event_liste.add(new Log_event(5, Integer.parseInt(adgangskode), false, erMontoer())); // Tilføj "Log_event" objekt til event_listen                          
                }else{
                    System.out.println("Montoertilstand deaktiveret");
                    event_liste.add(new Log_event(5, Integer.parseInt(adgangskode), false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
                }
                montoertilstand = false;
        }

    }

    /**
     * Retunerer totalprisen for Billetter listen.
     * @return 
     */
    public int getTotal() {
            if (montoertilstand) {
                    return totalIndtjeaning;
            } else {
                    System.out.println("Afvist - log ind foerst");
                    return -1;
            }
    }

    /**
     * Set billet prisen for bestemt billet-type.
     * @param type
     * @param billetpris
     */
    public void setBilletpris(int type, int billetpris) {
        netopNu = new Date(); // Hent et nyt Date objekt
        int billetpris_old = Billet.getBilletPris(type);

        if (this.montoertilstand) { // Billetprisen kan kun saettes som montoer
            if(billetpris >= 0){ // Billetprisen kan ikke vaere negativ
                Billet.setBilletPris(type, billetpris);
                // Timestamp på hvornår billetprisen er blevet ændret og til hvad

                //Billet klasse ikke implimenteret i log
                event_liste.add(new Log_event(6, billetpris, true, erMontoer())); // Tilføj "Log_event" objekt til event_listen
            }else{
                System.out.println("Billetprisen kan ikke vaere negativ.");

                //Billet klasse ikke implimenteret i log
                event_liste.add(new Log_event(6, billetpris, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen                    
            }
        }else {
                System.out.println("Afvist - log ind foerst");
                event_liste.add(new Log_event(6, billetpris, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }

    }


    /**
     * Set prisen per zone for bestemt billet-type.
     * @param type
     * @param billetpris
     */
    public void setBilletprisPerZone(int type, int billetpris) {
        netopNu = new Date(); // Hent et nyt Date objekt
        int billetpris_old = Billet.getBilletPrisPerZone(type);

        if (this.montoertilstand) { // Billetprisen kan kun saettes som montoer
            if(billetpris >= 0){ // Billetprisen kan ikke vaere negativ
                Billet.setBilletPrisPerZone(type, billetpris);
                // Timestamp på hvornår billetprisen er blevet ændret og til hvad

                //Billet klasse ikke implimenteret i log
                event_liste.add(new Log_event(6, billetpris, true, erMontoer())); // Tilføj "Log_event" objekt til event_listen
            }else{
                System.out.println("Billetprisen kan ikke vaere negativ.");

                //Billet klasse ikke implimenteret i log
                //event_liste.add(new Log_event(6, billetpris, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen                    
            }
        }else {
                System.out.println("Afvist - log ind foerst");
                //event_liste.add(new Log_event(6, billetpris, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }

    }


    public void nulstil() {
        netopNu = new Date(); // Hent et nyt Date objekt
        if (montoertilstand) {
            antalBilletterSolgtType0 = 0;
            antalBilletterSolgtType1 = 0;
            antalBilletterSolgtType2 = 0;
            antalBilletterSolgtType3 = 0;
            antalBilletterSolgtType4 = 0;
            event_liste.add(new Log_event(9, true, erMontoer())); // Tilføj "Log_event" objekt til event_listen                       
        } else {
                System.out.println("Afvist - log ind foerst");
                event_liste.add(new Log_event(9, false, erMontoer())); // Tilføj "Log_event" objekt til event_listen
        }
    }

    /**
     * Retuner antal biletter solgt.
     * @return Total antal billetter solgte
     */
    public int getAntalBilletterSolgt() {
            if (montoertilstand) {
                    int sum = antalBilletterSolgtType0 +
                              antalBilletterSolgtType1 +
                              antalBilletterSolgtType2 +
                              antalBilletterSolgtType3 +
                              antalBilletterSolgtType4;
                    return sum;
            } else {
                    System.out.println("Afvist - log ind foerst");
                    return -1;
            }
    }

    /**
     * Setter antal biletter solgt for en bestemt billet type.
     * 
     * @param type
     * @param antalBilletterSolgt
     */
    public void setAntalBilletterSolgt(int type, int antalBilletterSolgt) {
            if (montoertilstand) {
                switch (type){
                    case 0 : //voksen billet
                        antalBilletterSolgtType0 = antalBilletterSolgt;
                        break;

                    case 1 ://ungdoms billet
                        antalBilletterSolgtType1 = antalBilletterSolgt;
                        break;

                    case 2 : //barne billet
                        antalBilletterSolgtType2 = antalBilletterSolgt;
                        break;

                    case 3 : //studenter billet
                        antalBilletterSolgtType3 = antalBilletterSolgt;
                        break;

                    case 4 : //cykel billet
                        antalBilletterSolgtType4 = antalBilletterSolgt;
                        break;
                    default:
                        break;
                }

                //Billet klassen ikke implementeret i log
                event_liste.add(new Log_event(7,antalBilletterSolgt,true, erMontoer())); // Tilføj "Log_event" objekt til event_listen                        
            } else {
                    System.out.println("Afvist - log ind foerst");
                    event_liste.add(new Log_event(7,antalBilletterSolgt,false, erMontoer())); // Tilføj "Log_event" objekt til event_listen

            }
    }

    /**
     * Retuner montørtilstanden.
     * @return 
     */
    public boolean erMontoer() {
            return montoertilstand;
            // nice meme
    }

    /**
     * Udskriver hele eventloggen
     * 
     */
    public void udskrivLog_event_liste() {
        if (montoertilstand) {
            netopNu = new Date(); // Hent et nyt Date objekt
            System.out.println("============ Transaktioner pr. "+netopNu.toString()+"============"); // Udskrivning af log
            event_liste.forEach((element) -> {
                // gennemloeb alle elementerne i loggen
                System.out.println(element);      
            });
            event_liste.add(new Log_event(8, true, erMontoer()));

        }else {
                System.out.println("Afvist - log ind foerst");
                event_liste.add(new Log_event(8,false,erMontoer()));
        }
    }
        
        /**
	 * Søger i eventloggen efter bestemt id med success parameter. 
         * Success parameter 0 for fail.
         * Success parameter 1 for sucess.
         * Success parameter 2 for alle.
         *  
         * @param ID
         * @param success_parameter
         * @return 
	 */
        public int udskriver(int ID, int success_parameter){
            int tal = 0; // Antal udskrifter
            if(ID <0 || ID > Log_event.hojestID){ // Tjek om gyldigt ID
                System.out.println("Fejl i udskriver med ugyldigt ID: "+ ID);
                return -1;
            }
            
            for (Log_event element : event_liste) {
                if (ID != 0 && element.getId_nr() == ID) {
                    switch (success_parameter) {
                        case 0: // False
                            if(!element.isSucess()){
                                System.out.println(element);
                                tal++;
                            }   break;
                        case 1: // True
                            if(element.isSucess()){
                                System.out.println(element);
                                tal++;
                            }   break;
                        case 2: // Udskriv alt
                            System.out.println(element);
                            tal++;
                        break;
                    default:
                        System.out.println("Fejl i udskriver med ID: "+ ID+ " og success_parameter: "+ success_parameter);
                        return -1;
                }
            } else if (ID == 0) {
                switch (success_parameter) {
                    case 0: // False
                        if(!element.isSucess()){
                            System.out.println(element);
                            tal++;
                        }  break;
                    case 1: // True
                        if(element.isSucess()){
                            System.out.println(element);
                            tal++;
                        }  break;
                    case 2: // Udskriv alt
                        System.out.println(element);
                        tal++;
                        break;
                    default:
                        System.out.println("Fejl i udskriver med ID: "+ ID+ " og success_parameter: "+ success_parameter);
                        return -1;
                }//end switch
            } //end else if
        }//end for-loop
        if(tal == 0){
            System.out.println("Der blev ikke fundet nogle log-elementer der svarede til søge kriteriet.");
        }
        return tal;
    }
        
    /**
     * Finder transaktion for ID med pameter over belob
     * 
     * @param ID
     * @param belob
     * @return 
     */
    public int find_trans_over(int ID, int belob){
        int tal = 0;
        if(ID <0 || ID > Log_event.hojestID){ // Tjek om gyldigt ID
            System.out.println("Fejl i udskriver med ugyldigt ID: "+ ID);
            return -1;
        }

        for (Log_event element : event_liste) {
            if (ID != 0 && element.getId_nr() == ID) {
                if (element.getArgument() >= belob){
                    System.out.println(element);
                    tal++;
                }
            } else if (ID == 0) {
                if (element.getArgument() >= belob){
                    System.out.println(element);
                    tal++;
                }
            } //end else if
        }//end for-loop
        if(tal == 0){
            System.out.println("Der blev ikke fundet nogle log-elementer der svarede til søge kriteriet.");
        }
        return tal;
    }
    
        /**
	 * Udskriver eventloggen ud fra valg4.
         * 0 for indenfor den sidste time.
         * 1 for indenfor den sidste dag.
         * 2 for indenfor den sidste uge.
         * 3 for indenfor de sidste 30 dage. 
         * @param valg4
         * @param ID
	 */
    void datoudskriver(int valg4, int ID) {
        Date sammenligningsdato = new Date();
        int tal = 0;
        switch(valg4){
            case 0: 
                    sammenligningsdato = new Date(sammenligningsdato.getTime() - (60*60*1000)); // 1 time
                    for (Log_event element : event_liste){
                        if (element.getId_nr() == ID) {
                            if(sammenligningsdato.before(element.getTidspunkt())){
                                System.out.println(element);
                                tal++;
                            }
                        }
                    }
                    break;
            case 1:
                    sammenligningsdato = new Date(sammenligningsdato.getTime() - (60*60*1000*24)); // 1 dag
                    for (Log_event element : event_liste){
                        if (element.getId_nr() == ID) {
                            if(sammenligningsdato.before(element.getTidspunkt())){
                                System.out.println(element);
                                tal++;
                            }
                        }
                    }                
                    break;
            case 2:
                    sammenligningsdato = new Date(sammenligningsdato.getTime() - (60*60*1000*24*7)); // Uge
                    for (Log_event element : event_liste){
                        if (element.getId_nr() == ID) {
                            if(sammenligningsdato.before(element.getTidspunkt())){
                                System.out.println(element);
                                tal++;
                            }
                        }
                    }                
                    break;
            case 3:
                    sammenligningsdato = new Date(sammenligningsdato.getTime() - (60*60*1000*24*14)); // 14 dage
                    for (Log_event element : event_liste){
                        if (element.getId_nr() == ID) {
                            if(sammenligningsdato.before(element.getTidspunkt())){
                                System.out.println(element);
                                tal++;
                            }
                        }
                    }                   
                    break;
            default: System.err.println("Datoudskriver metoden modtog ugyldigt input: "+valg4);                    
        }
        if(tal == 0){
            System.out.println("Der blev ikke fundet nogle log-elementer der skete før den angivede dato.");
        }
    }
    
    /**
     * Køber en billet og tilføjer den til listen "Billetter".
     * 
     * @param valg_billet
     * @param valg_zone
     */
    void koebBilletter(int valg_billet, int valg_zone) {

        Billetter.add(new Billet(valg_billet, valg_zone));
    }

    /**
     * Sletter billetter fra listen "Billetter".
     * @param valg_billet "Type billet"
     * @param valg_zone   "Antal zoner
     * @param valg_antal  "Antal billet der ønskes slettet"
     */
    void sletBilletter(int valg_billet, int valg_zone, int valg_antal) {
        int tæller = 1;
        for (Billet element : Billetter){
            if(valg_billet == element.getType() && valg_zone == element.getZoner() && tæller <= valg_antal){
                Billetter.remove(element);
                tæller++; // Holder styr på, hvor mange elementer der skal slettes
            }
        }        
    }
    
    /**
     * Giver totalprisen på indeholdet af Biletter listen.
     * @return 
     */
    public int getTotalPrice(){
        int total = 0;
        for (Billet element : Billetter){
            total += element.getPris();
        }
        return total;
    }
    
    /**
     * Udfører det endeligt køb af biletter hvis balancen er høj nok.
     */
    public void endeligtKoeb(){
        if (balance < getTotalPrice()){
            System.out.printf("Indsæt penge for at købe %d biletter.", Billetter.size());
            
        } else if ( Billetter.size() < 1){
            System.out.println("Der er ingen biletter i indkøbskurven");
            
        } else {
            balance -= getTotalPrice();
            System.out.println("Dine biletter udskrives nu:");
            System.out.println("-----------------------------------");
            System.out.println("");
            Billetter.forEach((element) -> {
                udskrivBillet(element);
            });
            System.out.println("");
            System.out.println("-----------------------------------");
            returpenge();
        }
    }
    
    
    
}
