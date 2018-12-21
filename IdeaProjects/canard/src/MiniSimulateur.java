public class MiniSimulateur {
    public static void main(String[] args) {
        Canard colvert = new Colvert();
        colvert.effectuerCancan();
        colvert.effectuerVol();
        colvert.afficher();

        Canard proto = new PrototypeCanard();
        proto.effectuerVol();
        proto.setComportementVol(new PropulsionAReaction());
        proto.effectuerVol();
    }
}