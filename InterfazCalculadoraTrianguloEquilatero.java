package actividad3;

import javax.swing.*;

public class InterfazCalculadoraTrianguloEquilatero {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Triángulo Equilátero");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                // Crear una instancia de CalculadoraTrianguloEquilatero y agregarla al frame
                CalculadoraTrianguloEquilatero calculadoraPanel = new CalculadoraTrianguloEquilatero();
                frame.add(calculadoraPanel);

                frame.setVisible(true);
            }
        });
    }
}
