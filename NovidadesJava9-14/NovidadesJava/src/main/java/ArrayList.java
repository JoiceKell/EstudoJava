import java.util.Arrays;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        /*
        objetos com Arrays.List(..) trabalham com objetos com tamanhos fixos e mutáveis, enquanto o List.of(...)
        trabalham com objetos sem tamanho definidos e imutáveis.
         */
        List<String> asList = Arrays.asList("nome1", "nome2");
        //asList.add("nome3"); //java.lang.UnsupportedOperationException
        asList.set(1, "nome3"); //Ok
        System.out.println(asList);

        List<String> ofList = List.of("nome1", "nome2");
        //ofList.add("nome3"); //java.lang.UnsupportedOperationException
        //ofList.set(3, "nome3"); //java.lang.UnsupportedOperationException
        System.out.println(ofList);
    }
}
