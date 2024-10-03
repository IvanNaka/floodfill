import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Painel extends JPanel implements ActionListener {
    BufferedImage imagem;
    Timer timer;
    int x = 10;
    int y = 10;
    int PANEL_WIDTH;
    int PANEL_HEIGHT;
    String tipo;
    Painel(String tipoOp) throws IOException {
        tipo = tipoOp;
        imagem =  ImageIO.read(new File("src/Untitled.png"));
        PANEL_WIDTH = imagem.getWidth(null);
        PANEL_HEIGHT = imagem.getHeight(null);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        timer = new Timer(50, this);
        timer.start();
    }
    public void paint(Graphics g) {
        super.paintComponent(g); // paint background
        g.drawImage(imagem, 0, 0, null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics2D g2d = imagem.createGraphics();
        g2d.setColor(Color.RED);
        g2d.drawLine(x, y, x, y);

        x = x + 1;
        y = y + 1;
        int rgb = imagem.getRGB(x, y);
        g2d.dispose();
        repaint();
    }

}
