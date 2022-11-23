package com.relatorio;

import java.io.IOException;

import net.sf.jasperreports.engine.JRException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JRException, IOException
    {
        //String[] param = {"ditlanta","tricon","report/ditlanta.jpg"};
        JasperCore.imprimirRel(args);
    }
}
