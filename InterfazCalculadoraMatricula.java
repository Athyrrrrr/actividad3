package actividad3;

import javax.swing.*;

public class InterfazCalculadoraMatricula {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Matrícula");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);

                // Crear una instancia de CalculadoraMatricula y agregarla al frame
                CalculadoraMatricula calculadoraPanel = new CalculadoraMatricula();
                frame.add(calculadoraPanel);

                frame.setVisible(true);
            }
        });
    }
}
