package com.relatorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperCore {
    public static void imprimirRel(String[] args) throws JRException, IOException {
        //carrega e compila o relatorio
        String path = System.getProperty("user.dir")+"/report/RelatorioDitlanta.jrxml";
        JasperDesign jasperDesign = JRXmlLoader.load(path);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        
        //carrega o arquivo json com os dados e seta os parametros
        File jsonFile = new File(System.getProperty("user.dir")+"/dados.json");
        Map parametros = new HashMap();
        try {
            parametros.put("empresa", args[0]);
            parametros.put("usuario", args[1]);
        } catch (Exception e) {
            System.out.println(e);
        }
        parametros.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, new FileInputStream(jsonFile));
        
        //preenche o relatorio
        jasperReport.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parametros);

        //salva e mostra o relatorio
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "BasicReport.pdf");
        JasperViewer.viewReport(jasperPrint);

    }    
}
