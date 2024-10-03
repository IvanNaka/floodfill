import javax.swing.*;
import java.io.IOException;

public class Tela extends JFrame {
    FloodFill panel;

    Tela(int x, int y, int tipo) throws IOException {
        panel = new FloodFill(x, y, tipo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
