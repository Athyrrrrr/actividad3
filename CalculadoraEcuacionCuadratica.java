package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraEcuacionCuadratica extends JPanel {
    private JTextField campoA, campoB, campoC;
    private JLabel etiquetaResultado;

    public CalculadoraEcuacionCuadratica() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para el valor A
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Valor de A:"), gbc);

        gbc.gridx = 1;
        campoA = new JTextField(15);
        add(campoA, gbc);

        // Campo para el valor B
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Valor de B:"), gbc);

        gbc.gridx = 1;
        campoB = new JTextField(15);
        add(campoB, gbc);

        // Campo para el valor C
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Valor de C:"), gbc);

        gbc.gridx = 1;
        campoC = new JTextField(15);
        add(campoC, gbc);

        // Botón para calcular las soluciones
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton botonCalcular = new JButton("Calcular Soluciones");
        add(botonCalcular, gbc);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSoluciones();
            }
        });

        // Resultado
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        etiquetaResultado = new JLabel();
        add(etiquetaResultado, gbc);
    }

    private void calcularSoluciones() {
        try {
            double a = Double.parseDouble(campoA.getText());
            double b = Double.parseDouble(campoB.getText());
            double c = Double.parseDouble(campoC.getText());

            double discriminante = Math.pow(b, 2) - 4 * a * c;
            String resultado;

            if (discriminante > 0) {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                resultado = String.format("Las soluciones son x1 = %.2f y x2 = %.2f", x1, x2);
            } else if (discriminante == 0) {
                double x = -b / (2 * a);
                resultado = String.format("La solución es x = %.2f", x);
            } else {
                resultado = "La ecuación no tiene soluciones reales.";
            }

            etiquetaResultado.setText(resultado);
            JOptionPane.showMessageDialog(this, resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
