/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;

import clases.OperacioCaja;
import clases.ProductoVendido;
import clases.Usuario;
import clases.Venta;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 *
 * @author fell
 */
public class ImprimirEgresoIngreso {
    public ImprimirEgresoIngreso(){
    }
    
    public static String ingresarDocumentoImprimir(OperacioCaja operacioCaja){
        String rutaAImprimir="";
        try{
            Document documento=new Document();
            String ruta=System.getProperty("user.home");
            documento.setPageSize(PageSize.PENGUIN_LARGE_PAPERBACK);
            documento.open();
    

            Paragraph idOperacionCaja=new Paragraph();
            idOperacionCaja.add(operacioCaja.getIdOperacionCaja());
            idOperacionCaja.setAlignment(Element.ALIGN_CENTER);



               Paragraph fecha= new Paragraph();
            int gminuto;
            int ghora;
            int gdia;
            int gmes;
            int gaño;

            gdia=LocalDateTime.now().getDayOfMonth();

            gmes=LocalDateTime.now().getMonthValue();

            gaño=LocalDateTime.now().getYear();

            ghora=LocalDateTime.now().getHour();
            gminuto=LocalDateTime.now().getMinute();
            fecha.add("Fecha:"+gaño+"/"+gmes+"/"+gdia+" "+"\nHORA:"+ghora+":"+gminuto);
            fecha.setAlignment(Element.ALIGN_CENTER);
            
            

            Paragraph zzh=new Paragraph();
            zzh.add("***********************************");
            zzh.setAlignment(Element.ALIGN_CENTER);

            
            Paragraph tipo=new Paragraph();
            tipo.add("tipo :"+operacioCaja.getTipo());
            tipo.setAlignment(Element.ALIGN_CENTER);
            
            
            Paragraph precioTotal=new Paragraph();
            precioTotal.add("Precio :"+operacioCaja.getPrecioTotal());
            precioTotal.setAlignment(Element.ALIGN_CENTER);
            Paragraph razon=new Paragraph();
            razon.add("Razón:"+operacioCaja.getRazon());
            razon.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph espacio=new Paragraph();
            espacio.add("\n\n\n ");
            espacio.setAlignment(Element.ALIGN_CENTER);
            Paragraph fimar=new Paragraph();
            fimar.add("_______________________");
            fimar.setAlignment(Element.ALIGN_CENTER);
            Paragraph cc=new Paragraph();
            cc.add("FIRMA");
            cc.setAlignment(Element.ALIGN_CENTER);
            
  
            
            
            
            rutaAImprimir="OperacionCaja/"+operacioCaja.getIdOperacionCaja()+".pdf";
            PdfWriter archivo=PdfWriter.getInstance(documento,new FileOutputStream(rutaAImprimir));
            documento.open();
            
            
            
            Barcode128 codigo128=new Barcode128();
            codigo128.setCode(operacioCaja.getIdOperacionCaja());
            com.itextpdf.text.Image imagen= codigo128.createImageWithBarcode(archivo.getDirectContent(), BaseColor.BLACK, BaseColor.YELLOW);
            
            imagen.scalePercent(100);
            imagen.setAlignment(Element.ALIGN_CENTER);

            documento.add(imagen);
            documento.add(idOperacionCaja);
    
    
            documento.add(fecha);
         
            documento.add(tipo);
            documento.add(precioTotal);
            documento.add(razon);
            documento.add(zzh);
            documento.add(espacio);
            documento.add(fimar);
            documento.add(cc);
            documento.close();
        }catch(Exception e){
            System.out.println("ERROR"+e);
        }
        return rutaAImprimir;
    
    }   
}
