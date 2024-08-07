package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSalario extends JPanel {
    private JTextField campoCodigo, campoNombres, campoHoras, campoValorHora, campoRetencion;
    private JLabel etiquetaSalarioBruto, etiquetaSalarioNeto;

    public CalculadoraSalario() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Código del empleado
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Código del empleado:"), gbc);

        gbc.gridx = 1;
        campoCodigo = new JTextField(15);
        add(campoCodigo, gbc);

        // Nombres del empleado
        gbc.gridx = 2;
        add(new JLabel("Nombres del empleado:"), gbc);

        gbc.gridx = 3;
        campoNombres = new JTextField(15);
        add(campoNombres, gbc);

        // Número de horas trabajadas
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Número de horas trabajadas:"), gbc);

        gbc.gridx = 1;
        campoHoras = new JTextField(15);
        add(campoHoras, gbc);

        // Valor hora trabajada
        gbc.gridx = 2;
        add(new JLabel("Valor hora trabajada:"), gbc);

        gbc.gridx = 3;
        campoValorHora = new JTextField(15);
        add(campoValorHora, gbc);

        // Porcentaje de retención en la fuente
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Porcentaje de retención:"), gbc);

        gbc.gridx = 1;
        campoRetencion = new JTextField(15);
        add(campoRetencion, gbc);

        // Botón para calcular el salario
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton botonCalcular = new JButton("Calcular Salario");
        add(botonCalcular, gbc);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalario();
            }
        });

        // Salario bruto
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(new JLabel("Salario bruto:"), gbc);

        gbc.gridx = 1;
        etiquetaSalarioBruto = new JLabel();
        add(etiquetaSalarioBruto, gbc);

        // Salario neto
        gbc.gridx = 2;
        add(new JLabel("Salario neto:"), gbc);

        gbc.gridx = 3;
        etiquetaSalarioNeto = new JLabel();
        add(etiquetaSalarioNeto, gbc);
    }

    private void calcularSalario() {
        try {
            String codigo = campoCodigo.getText();
            String nombres = campoNombres.getText();
            double horasTrabajadas = Double.parseDouble(campoHoras.getText());
            double valorHora = Double.parseDouble(campoValorHora.getText());
            double porcentajeRetencion = Double.parseDouble(campoRetencion.getText());

            double salarioBruto = horasTrabajadas * valorHora;
            double salarioNeto = salarioBruto * (1 - porcentajeRetencion / 100);

            etiquetaSalarioBruto.setText(String.format("%.2f", salarioBruto));
            etiquetaSalarioNeto.setText(String.format("%.2f", salarioNeto));

            JOptionPane.showMessageDialog(this, "Código: " + codigo + "\nNombres: " + nombres +
                    "\nSalario bruto: " + salarioBruto + "\nSalario neto: " + salarioNeto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese números válidos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
