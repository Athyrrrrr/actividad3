package actividad3;

import javax.swing.*;

public class InterfazCalculadoraSalarioMensual {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Salario Mensual");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);

                // Crear una instancia de CalculadoraSalarioMensual y agregarla al frame
                CalculadoraSalarioMensual calculadoraPanel = new CalculadoraSalarioMensual();
                frame.add(calculadoraPanel);

                frame.setVisible(true);
            }
        });
    }
}
