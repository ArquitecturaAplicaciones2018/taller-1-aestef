import fraccionario.Rational;
import java.util.List;
public class main {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(7, 8));
        var unMedio = new Rational(1, 2);
        var sumaTotal = new Rational(0, 1);
        var mayor = new Rational(0, 1);
        var sumaNumeradores = 0;
        var numeradorMenor = 0;
        var numeradorMayor = 0;

        //Obtener todos los números racionales que sean menores a 1/2
        //Imperativa
        /*  for (Rational r : rationals) {
            if (r.isLessThan(unMedio)) {
                System.out.println("Menor a 1/2 es: " + r);
                }
        }*/
        //Funcional
        System.out.print("Menores a un 1/2 : ");
        rationals.stream().filter(r -> r.isLessThan(unMedio)).forEach(System.out::println);

        // Sumar todos los racionales
        sumaTotal = rationals.stream().reduce(sumaTotal, (r, s)  -> r.plus(s));
        System.out.println("La suma total es: " + sumaTotal);

        // Obtener el número racional mayor
        mayor = rationals.stream().reduce(mayor, (r, m) -> r.getGreater(m) );
        System.out.println("El racional mayor es: " + mayor);

        //Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores,
        // el numerador menor, el mayor y el promedio

        //Suma de los numeradores
        sumaNumeradores = rationals.stream().mapToInt(r -> r.getNumerator()).sum();
        System.out.println("La suma de los numeradores es: " + sumaNumeradores);

        //Número de elementos
        System.out.println("El numero de elementos es: " + rationals.size());

        //Numerador menor
        numeradorMenor = rationals.stream().mapToInt(Rational::getNumerator).min().getAsInt();
        System.out.println("El numerador menor es: " + numeradorMenor);

        //Numerador mayor
        numeradorMayor = rationals.stream().mapToInt(Rational::getNumerator).max().getAsInt();
        System.out.println("El numerador mayor es: " + numeradorMayor);

        //Promedio de los numeradores
        System.out.println("El promedio es: " + (double)(sumaNumeradores / rationals.size()));
    }
}

