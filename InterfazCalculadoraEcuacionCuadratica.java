package actividad3;

import javax.swing.*;

public class InterfazCalculadoraEcuacionCuadratica {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculadora de Ecuación Cuadrática");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                // Crear una instancia de CalculadoraEcuacionCuadratica y agregarla al frame
                CalculadoraEcuacionCuadratica calculadoraPanel = new CalculadoraEcuacionCuadratica();
                frame.add(calculadoraPanel);

                frame.setVisible(true);
            }
        });
    }
}
