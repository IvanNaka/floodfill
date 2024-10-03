import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FloodFill extends JPanel implements ActionListener {
    BufferedImage imagem;
    Timer timer;
    int x;
    int y;
    int imgLarg;
    int imgAlt;
    int rgbIni;
    int rgbPintar = Color.RED.getRGB();
    int tipo;
    Pilha<Pixel> pilha;
    FilaEst<Pixel> fila;

    FloodFill(int xIni, int yIni, int tipoEsc) throws IOException {
        x = xIni;
        y = yIni;
        tipo = tipoEsc;
        imagem = ImageIO.read(new File("src/BBBB.png"));
        imgLarg = imagem.getWidth(null);
        imgAlt = imagem.getHeight(null);
        rgbIni = imagem.getRGB(x, y);
        this.setPreferredSize(new Dimension(imgLarg, imgAlt));
        timer = new Timer(1, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.drawImage(imagem, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics2D g2d = imagem.createGraphics();
        switch (tipo) {
            case 1:
                if (pilha == null) {
                    pilha = new Pilha<Pixel>(imgLarg * imgAlt);
                    pilha.push(new Pixel(x, y));
                }
                if (!pilha.isEmpty()) {
                    Pixel p1 = pilha.pop();

                    x = p1.x;
                    y = p1.y;
                    if (validarPixel(x, y)) {
                        if(imagem.getRGB(x, y) == rgbIni){
                            g2d.setColor(Color.RED);
                            g2d.drawLine(x, y, x, y);
                            g2d.dispose();
                            if (validarPixel(x + 1, y)){
                                pilha.push(new Pixel(x + 1, y));
                            }
                            if (validarPixel(x - 1, y)){
                                pilha.push(new Pixel(x - 1, y));
                            }
                            if (validarPixel(x, y + 1)){
                                pilha.push(new Pixel(x, y + 1));
                            }
                            if (validarPixel(x, y - 1)){
                                pilha.push(new Pixel(x, y - 1));
                            }
                        }
                    }
                }else{
                    timer.stop();
                }
                break;
            case 2:
                if (fila == null) {
                    fila = new FilaEst<Pixel>(imgLarg * imgAlt);
                    fila.add(new Pixel(x, y));
                }
                if(!fila.isEmpty()){
                    Pixel p = fila.remove();
                    x = p.x;
                    y = p.y;
                    if (validarPixel(x, y)) {
                        if(imagem.getRGB(x, y) == rgbIni){
                            g2d.setColor(Color.RED);
                            g2d.drawLine(x, y, x, y);
                            g2d.dispose();
                            if (validarPixel(x + 1, y)){
                                fila.add(new Pixel(x + 1, y));
                            }
                            if (validarPixel(x - 1, y)){
                                fila.add(new Pixel(x - 1, y));
                            }
                            if (validarPixel(x, y + 1)){
                                fila.add(new Pixel(x, y + 1));
                            }
                            if (validarPixel(x, y - 1)){
                                fila.add(new Pixel(x, y - 1));
                            }
                        }
                    }
                }else {
                    timer.stop();
                }
                break;
        }
        repaint();
    }
    private boolean validarPixel(int x, int y) {
        return x >= 0 && x < imgLarg && y >= 0 && y < imgAlt;
    }

}







