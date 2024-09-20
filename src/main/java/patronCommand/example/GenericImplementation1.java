package patronCommand.example;

public class GenericImplementation1 implements GenericInterface<Parameter1>{

    @Override
    public void execute(Parameter1 parameters) {
        System.out.println(parameters.decimal);
        System.out.println(parameters.numero);
        System.out.println(parameters.nombre);
    }
}
