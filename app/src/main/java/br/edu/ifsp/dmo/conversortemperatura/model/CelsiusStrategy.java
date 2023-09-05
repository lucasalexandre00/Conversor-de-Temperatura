package br.edu.ifsp.dmo.conversortemperatura.model;

public class CelsiusStrategy implements ConversorTemperatura{

    private static CelsiusStrategy instance;

    private CelsiusStrategy(){}

    public static CelsiusStrategy getInstance(){
        if (instance == null){
            instance = new CelsiusStrategy();
        }
        return instance;
    }
    @Override
    public double converter(double temperatura) {
        return (temperatura - 32) / 1.8;
    }
}
