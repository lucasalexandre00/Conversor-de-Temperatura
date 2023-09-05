package br.edu.ifsp.dmo.conversortemperatura.model;

public class FahrenheitStrategy implements ConversorTemperatura{

    private static FahrenheitStrategy instance;

    private FahrenheitStrategy(){}

    public static FahrenheitStrategy getInstance(){
        if (instance == null){
            instance = new FahrenheitStrategy();
        }
        return instance;
    }
    @Override
    public double converter(double temperatura) {
        return 1.8 * temperatura + 32;
    }
}
