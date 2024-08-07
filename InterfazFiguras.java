package actividad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazFiguras extends JFrame {
    private JTextArea resultadoArea;
    private JTextField radioField, baseField, alturaField, ladoField;

    public InterfazFiguras() {
        setTitle("Calculadora de Figuras Geométricas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campos de entrada
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelBotones.add(new JLabel("Radio del Círculo:"), gbc);
        gbc.gridx = 1;
        radioField = new JTextField(10);
        panelBotones.add(radioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelBotones.add(new JLabel("Base del Rectángulo o del Triángulo:"), gbc);
        gbc.gridx = 1;
        baseField = new JTextField(10);
        panelBotones.add(baseField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelBotones.add(new JLabel("Altura del Rectángulo o del Triángulo:"), gbc);
        gbc.gridx = 1;
        alturaField = new JTextField(10);
        panelBotones.add(alturaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelBotones.add(new JLabel("Lado del Cuadrado:"), gbc);
        gbc.gridx = 1;
        ladoField = new JTextField(10);
        panelBotones.add(ladoField, gbc);

        // Botones para calcular
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton botonCirculo = new JButton("Calcular Círculo");
        botonCirculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(radioField.getText());
                Circulo circulo = new Circulo(radio);
                mostrarResultados("Círculo", circulo.calcularArea(), circulo.calcularPerimetro());
            }
        });
        panelBotones.add(botonCirculo, gbc);

        gbc.gridy = 5;
        JButton botonRectangulo = new JButton("Calcular Rectángulo");
        botonRectangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int base = Integer.parseInt(baseField.getText());
                int altura = Integer.parseInt(alturaField.getText());
                Rectangulo rectangulo = new Rectangulo(base, altura);
                mostrarResultados("Rectángulo", rectangulo.calcularArea(), rectangulo.calcularPerimetro());
            }
        });
        panelBotones.add(botonRectangulo, gbc);

        gbc.gridy = 6;
        JButton botonCuadrado = new JButton("Calcular Cuadrado");
        botonCuadrado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lado = Integer.parseInt(ladoField.getText());
                Cuadrado cuadrado = new Cuadrado(lado);
                mostrarResultados("Cuadrado", cuadrado.calcularArea(), cuadrado.calcularPerimetro());
            }
        });
        panelBotones.add(botonCuadrado, gbc);

        gbc.gridy = 7;
        JButton botonTriangulo = new JButton("Calcular Triángulo Rectángulo");
        botonTriangulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int base = Integer.parseInt(baseField.getText());
                int altura = Integer.parseInt(alturaField.getText());
                TrianguloRectangulo triangulo = new TrianguloRectangulo(base, altura);
                mostrarResultados("Triángulo Rectángulo", triangulo.calcularArea(), triangulo.calcularPerimetro());
                resultadoArea.append("Tipo de triángulo: " + triangulo.determinarTipoTriangulo() + "\n\n");
            }
        });
        panelBotones.add(botonTriangulo, gbc);

        add(panelBotones, BorderLayout.NORTH);
    }

    private void mostrarResultados(String figura, double area, double perimetro) {
        resultadoArea.append("El área del " + figura + " es = " + area + "\n");
        resultadoArea.append("El perímetro del " + figura + " es = " + perimetro + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazFiguras().setVisible(true);
            }
        });
    }
}
