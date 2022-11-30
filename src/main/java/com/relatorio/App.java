package com.relatorio;

import java.io.IOException;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JRException, IOException
    {
        try {
            JasperCore.imprimirRel(args);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"titulo",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
            System.exit(0);
        }
    }
}
