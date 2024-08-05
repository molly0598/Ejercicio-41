public class MaximoValor {
    public static double encontrarMaximo(double[] numeros) {
        if (numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }

        double maximo = Double.NEGATIVE_INFINITY;

        for (double numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }

        return maximo;
    }
}