package actividad3;

import javax.swing.*;

public class InterfazComparadorValores {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Comparador de Valores");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200);

                // Crear una instancia de ComparadorValores y agregarla al frame
                ComparadorValores comparadorPanel = new ComparadorValores();
                frame.add(comparadorPanel);

                frame.setVisible(true);
            }
        });
    }
}
