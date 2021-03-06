/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Gui.Ingresos;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author ricardo
 */
public class ModeloExcel {
    Workbook wb;
    public String Importar(File archivo, JTable tablaD, DefaultTableModel modeloT){
        String respuesta="No se pudo realizar la importación.";
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila=-1;
            while (filaIterator.hasNext()) {                
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[1000];
                int indiceColumna=-1;
                while (columnaIterator.hasNext()) {                    
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if(indiceFila==0){
                        //modeloT.addColumn(celda.getStringCellValue());
                    }else{
                        if(celda!=null){
                            switch(celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna]= (int)Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna]= celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna]= celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna]=celda.getDateCellValue();
                                    break;
                            }
                        }                        
                    }
                }
                if(indiceFila!=0)modeloT.addRow(listaColumna);
            }
            respuesta="Importación exitosa";
        } catch (IOException | InvalidFormatException | EncryptedDocumentException e) {
        }
        return respuesta;
    }
    
    public String Exportar(File archivo, JTable tablaD){
        String respuesta="No se realizo con exito la exportación.";
        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();
        if(archivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Hoja 1");
        hoja.setColumnWidth(0, 2000);
        hoja.setColumnWidth(1, 2800);
        hoja.setColumnWidth(2, 3000);
        hoja.setColumnWidth(3, 3500);
        hoja.setColumnWidth(4, 6000);
        hoja.setColumnWidth(5, 7000);
        hoja.setColumnWidth(6, 2800);
        for (int j = 7; j < 16; j++) {
            hoja.setColumnWidth(j, 2000);
        }
        hoja.setDefaultRowHeight((short)280);
        
        CellStyle style = wb.createCellStyle();
        style.setLocked(false);
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if(i==-1){
                        
                        if (j != 7 && j != 8 && j != 9 && j != 10 &&  j != 13 && j != 14 && j != 15 && j != 16) {
                            celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                        } else {
                            celda.setCellValue(Double.parseDouble(tablaD.getColumnName(j).toString()));
                        }
                        Font font = wb.createFont ();
                        font.setBold(true);
                        style.setFont(font);
                        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                        celda.setCellStyle(style);
                    }else{ 
                        if (j != 0 && j != 2 && j != 3 && j != 6 && j != 7 && j != 8 && j != 9 && j != 10 && j != 11
                                 && j != 12 && j != 13 && j != 14 && j != 15 && j != 16) {
                            celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                        } else {
                            celda.setCellValue(Double.parseDouble(tablaD.getValueAt(i, j).toString()));
                        }
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta="Exportación exitosa.";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return respuesta;
    }
}
