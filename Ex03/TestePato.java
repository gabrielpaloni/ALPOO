package ALPOO.Ex03;

public class TestePato {
    public void testaPato() {

        Pato pato = new Pato();

        pato.setAcaoVoar(new AcaoVoarConcreta());
        pato.voar();
    }

    public static void main(String[] args) {
        new TestePato().testaPato();
    }
}
