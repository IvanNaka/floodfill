import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scannerPixelX = new Scanner(System.in);
        System.out.println("Digite o primeiro pixel do eixo X");
        int escolhaX = scannerPixelX.nextInt();
        Scanner scannerPixelY = new Scanner(System.in);
        System.out.println("Digite o primeiro pixel do eixo Y");
        int escolhaY = scannerPixelY.nextInt();
        Scanner scannerTipo = new Scanner(System.in);
        System.out.println("Escolha o tipo da estutura:");
        System.out.println("1 - Pilha");
        System.out.println("2 - Fila");
        int escolhaTipo = scannerTipo.nextInt();
        switch (escolhaTipo) {
            case 1:
                new Tela(escolhaX, escolhaY, 1);
                break;
            case 2:
                new Tela(escolhaX, escolhaY, 2);
                break;
            default:
                System.out.println("Escolha uma opção válida");
                return;
        }
    }
}