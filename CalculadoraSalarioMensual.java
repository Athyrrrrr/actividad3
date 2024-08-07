package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSalarioMensual extends JPanel {
    private JTextField campoNombre, campoSalarioHora, campoHorasTrabajadas;
    private JLabel etiquetaResultado;

    public CalculadoraSalarioMensual() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para el nombre del empleado
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre del empleado:"), gbc);

        gbc.gridx = 1;
        campoNombre = new JTextField(15);
        add(campoNombre, gbc);

        // Campo para el salario básico por hora
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Salario básico por hora:"), gbc);

        gbc.gridx = 1;
        campoSalarioHora = new JTextField(15);
        add(campoSalarioHora, gbc);

        // Campo para el número de horas trabajadas en el mes
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Número de horas trabajadas en el mes:"), gbc);

        gbc.gridx = 1;
        campoHorasTrabajadas = new JTextField(15);
        add(campoHorasTrabajadas, gbc);

        // Botón para calcular el salario mensual
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton botonCalcular = new JButton("Calcular Salario Mensual");
        add(botonCalcular, gbc);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalarioMensual();
            }
        });

        // Resultado
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        etiquetaResultado = new JLabel();
        add(etiquetaResultado, gbc);
    }

    private void calcularSalarioMensual() {
        try {
            String nombre = campoNombre.getText();
            double salarioHora = Double.parseDouble(campoSalarioHora.getText());
            int horasTrabajadas = Integer.parseInt(campoHorasTrabajadas.getText());

            double salarioMensual = salarioHora * horasTrabajadas;

            if (salarioMensual > 450000) {
                etiquetaResultado.setText(String.format("%s debe recibir un salario mensual de: $%.2f", nombre, salarioMensual));
            } else {
                etiquetaResultado.setText(String.format("%s", nombre));
            }

            JOptionPane.showMessageDialog(this, etiquetaResultado.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
