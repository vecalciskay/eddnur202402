package patronCommand.example;

public class GenericImplementation2 implements GenericInterface<Parameter2>{
    @Override
    public void execute(Parameter2 parameters) {
        System.out.println(parameters.factor);
        System.out.println(parameters.suma);
    }
}
