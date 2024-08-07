package actividad3;

import javax.swing.*;

public class InterfazCalculadoraSalario {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Salario del Empleado");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 300);

                // Crear una instancia de CalculadoraSalario y agregarla al frame
                CalculadoraSalario calculadoraPanel = new CalculadoraSalario();
                frame.add(calculadoraPanel);

                frame.setVisible(true);
            }
        });
    }
}
