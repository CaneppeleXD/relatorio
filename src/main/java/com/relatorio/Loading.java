package com.relatorio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Loading {
    static JFrame f;
    static JPanel p;
    static JProgressBar b;
    
    public static void main(String[] args) throws IOException {
        mostrarLoading();
        esconderLoading();
    }

    public static void mostrarLoading() throws IOException{
        f = new JFrame("Gerando Relatório");
        p = new JPanel();
        b = new JProgressBar();

        //BufferedImage imagem = ImageIO.read(new File("/home/flexabus-java-3/pasta do jao/Coursera-Test/images/Infinity-1s-200px.gif"));
        //JLabel l = new JLabel(new ImageIcon(imagem));

        Icon imgIcon = new ImageIcon(System.getProperty("user.dir")+"/report/Blocks-1s-134px.gif");
        JLabel l = new JLabel(imgIcon);

        p.add(l);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(500,200);
        f.setVisible(true);


    }

    public static void esconderLoading(){
        f.setVisible(false);
    }
}