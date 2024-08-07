package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraMatricula extends JPanel {
    private JTextField campoInscripcion, campoNombres, campoPatrimonio, campoEstrato;
    private JLabel etiquetaResultado;

    public CalculadoraMatricula() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para el número de inscripción
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Número de inscripción:"), gbc);

        gbc.gridx = 1;
        campoInscripcion = new JTextField(15);
        add(campoInscripcion, gbc);

        // Campo para los nombres
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombres:"), gbc);

        gbc.gridx = 1;
        campoNombres = new JTextField(15);
        add(campoNombres, gbc);

        // Campo para el patrimonio
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Patrimonio:"), gbc);

        gbc.gridx = 1;
        campoPatrimonio = new JTextField(15);
        add(campoPatrimonio, gbc);

        // Campo para el estrato social
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Estrato social:"), gbc);

        gbc.gridx = 1;
        campoEstrato = new JTextField(15);
        add(campoEstrato, gbc);

        // Botón para calcular el pago de matrícula
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton botonCalcular = new JButton("Calcular Matrícula");
        add(botonCalcular, gbc);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMatricula();
            }
        });

        // Resultado
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        etiquetaResultado = new JLabel();
        add(etiquetaResultado, gbc);
    }

    private void calcularMatricula() {
        try {
            String numeroInscripcion = campoInscripcion.getText();
            String nombres = campoNombres.getText();
            double patrimonio = Double.parseDouble(campoPatrimonio.getText());
            int estrato = Integer.parseInt(campoEstrato.getText());

            double pagoMatricula = 50000;

            if (patrimonio > 2000000 && estrato > 3) {
                pagoMatricula += 0.03 * patrimonio;
            }

            etiquetaResultado.setText(String.format("El estudiante con número de inscripción %s y nombre %s debe pagar: $%.2f", numeroInscripcion, nombres, pagoMatricula));

            JOptionPane.showMessageDialog(this, etiquetaResultado.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
