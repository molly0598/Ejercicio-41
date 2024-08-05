import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionMayorValor extends JFrame {
    private JTextField campoCantidad;
    private JTextArea areaNumeros;
    private JLabel etiquetaResultado;

    public AplicacionMayorValor() {
        setTitle("Determinar el Valor Máximo");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel etiquetaCantidad = new JLabel("Número de entradas:");
        campoCantidad = new JTextField();
        JButton botonCalcular = new JButton("Ejecutar");

        panelEntrada.add(etiquetaCantidad);
        panelEntrada.add(campoCantidad);
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(botonCalcular);

        areaNumeros = new JTextArea();
        areaNumeros.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaNumeros);

        etiquetaResultado = new JLabel();
        etiquetaResultado.setForeground(Color.BLUE);

        botonCalcular.setFont(new Font("Serif", Font.BOLD, 16));
        botonCalcular.setPreferredSize(new Dimension(140, 40));

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidad = Integer.parseInt(campoCantidad.getText());

                    if (cantidad <= 0) {
                        etiquetaResultado.setText("Introduce un número mayor a cero.");
                        return;
                    }

                    double[] numeros = new double[cantidad];
                    for (int i = 0; i < cantidad; i++) {
                        String entrada = JOptionPane.showInputDialog("Introduce el valor #" + (i + 1) + ":");
                        numeros[i] = Double.parseDouble(entrada);
                        areaNumeros.append(entrada + "\n");
                    }

                    double maximo = MaximoValor.encontrarMaximo(numeros);
                    etiquetaResultado.setText("El valor máximo es: " + maximo);
                } catch (NumberFormatException ex) {
                    etiquetaResultado.setText("Introduce un número válido.");
                } catch (IllegalArgumentException ex) {
                    etiquetaResultado.setText(ex.getMessage());
                }
            }
        });

        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(etiquetaResultado, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplicacionMayorValor());
    }
}
