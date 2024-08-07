package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraTrianguloEquilatero extends JPanel {
    private JTextField campoLado;
    private JLabel etiquetaPerimetro, etiquetaAltura, etiquetaArea;

    public CalculadoraTrianguloEquilatero() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para el valor del lado
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Valor del lado:"), gbc);

        gbc.gridx = 1;
        campoLado = new JTextField(15);
        add(campoLado, gbc);

        // Botón para calcular
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        JButton botonCalcular = new JButton("Calcular");
        add(botonCalcular, gbc);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValores();
            }
        });

        // Perímetro
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Perímetro:"), gbc);

        gbc.gridx = 1;
        etiquetaPerimetro = new JLabel();
        add(etiquetaPerimetro, gbc);

        // Altura
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Altura:"), gbc);

        gbc.gridx = 1;
        etiquetaAltura = new JLabel();
        add(etiquetaAltura, gbc);

        // Área
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Área:"), gbc);

        gbc.gridx = 1;
        etiquetaArea = new JLabel();
        add(etiquetaArea, gbc);
    }

    private void calcularValores() {
        try {
            double lado = Double.parseDouble(campoLado.getText());

            // Calcular el perímetro
            double perimetro = 3 * lado;

            // Calcular la altura (h = (sqrt(3)/2) * lado)
            double altura = (Math.sqrt(3) / 2) * lado;

            // Calcular el área (A = (sqrt(3)/4) * lado^2)
            double area = (Math.sqrt(3) / 4) * Math.pow(lado, 2);

            etiquetaPerimetro.setText(String.format("%.2f", perimetro));
            etiquetaAltura.setText(String.format("%.2f", altura));
            etiquetaArea.setText(String.format("%.2f", area));

            JOptionPane.showMessageDialog(this, "Perímetro: " + perimetro + "\nAltura: " + altura + "\nÁrea: " + area);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
