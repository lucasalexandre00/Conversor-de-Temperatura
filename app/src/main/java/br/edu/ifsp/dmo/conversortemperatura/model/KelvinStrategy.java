package br.edu.ifsp.dmo.conversortemperatura.model;

public class KelvinStrategy implements ConversorTemperatura{

    private static KelvinStrategy instance;

    private KelvinStrategy(){}

    public static KelvinStrategy getInstance(){
        if (instance == null){
            instance = new KelvinStrategy();
        }
        return instance;
    }
    @Override
    public double converter(double temperatura) {
        return temperatura + 273;
    }
}
