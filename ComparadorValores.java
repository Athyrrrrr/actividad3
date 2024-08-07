package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparadorValores extends JPanel {
    private JTextField campoA, campoB;
    private JLabel etiquetaResultado;

    public ComparadorValores() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para el valor A
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Valor de A:"), gbc);

        gbc.gridx = 1;
        campoA = new JTextField(10);
        add(campoA, gbc);

        // Campo para el valor B
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Valor de B:"), gbc);

        gbc.gridx = 1;
        campoB = new JTextField(10);
        add(campoB, gbc);

        // Botón para comparar
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton botonComparar = new JButton("Comparar");
        add(botonComparar, gbc);

        botonComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararValores();
            }
        });

        // Resultado
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        etiquetaResultado = new JLabel();
        add(etiquetaResultado, gbc);
    }

    private void compararValores() {
        try {
            double valorA = Double.parseDouble(campoA.getText());
            double valorB = Double.parseDouble(campoB.getText());

            if (valorA > valorB) {
                etiquetaResultado.setText("A es mayor que B");
            } else if (valorA == valorB) {
                etiquetaResultado.setText("A es igual a B");
            } else {
                etiquetaResultado.setText("A es menor que B");
            }

            JOptionPane.showMessageDialog(this, etiquetaResultado.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
