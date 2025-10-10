package ALPOO.EX13.controller;

public class SomaController {

    public double somar(String num1, String num2) throws NumberFormatException {
        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        return numero1 + numero2;
    }
}
