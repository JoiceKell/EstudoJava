import java.util.*;
import java.util.stream.Collectors;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

class ExemploCurso {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
        //cursos.forEach(c -> System.out.println(c.getNome()));

        //Maior que 100
        cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));

        //
        cursos.stream().filter(c -> c.getAlunos() >= 100)
                .map(c -> c.getAlunos())//Número de alunos do curso
                .forEach(total -> System.out.println(total));

        cursos.stream().filter(c -> c.getAlunos() >= 100)
                .map(Curso::getAlunos)//Número de alunos do curso
                .forEach(System.out::println);

        int soma = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .mapToInt(Curso::getAlunos)
                .sum();
        System.out.println(soma);

        OptionalDouble average = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .mapToInt(Curso::getAlunos)
                .average();

        System.out.println("Media: " + average);

        Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

        System.out.println("ifPresent()");
        optionalCurso.ifPresent(c-> System.out.println(c.getNome()));

        System.out.println("Junto");
        cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c-> System.out.println(c.getNome()));

        System.out.println("\n");

//        Curso curso = optionalCurso.get();
        Curso curso = optionalCurso.orElse(null);
        System.out.println(curso.getNome());

        //Stream para Collection collect();
//        List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
        cursos = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
        System.out.println("Retorna para cursos na mesma variável");
        cursos.stream().forEach(c-> System.out.println(c.getNome()));


        System.out.println("\nMap");
        Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
        System.out.println(map);

        System.out.println("\nMap for");
        cursos.parallelStream().filter(c -> c.getAlunos() > 100).
                collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + "tem " + alunos + " alunos"));
    }
}