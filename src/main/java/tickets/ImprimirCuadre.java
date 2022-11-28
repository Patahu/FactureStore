/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;
import clases.Cuadre;
import clases.Producto;
import clases.ProductoVendido;
import clases.Usuario;
import clases.Venta;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author fell
 */
public class ImprimirCuadre {
    public ImprimirCuadre(){
    }
    
    public static String ingresarDocumentoImprimir( ArrayList<Cuadre> listaProductos,double precioTotal){
        String rutaAImprimir="";
        try{
            Document documento=new Document();
            String ruta=System.getProperty("user.home");
            documento.setPageSize(PageSize.PENGUIN_LARGE_PAPERBACK);
            documento.open();
            Paragraph zz=new Paragraph();
            zz.add("***********************************");
            zz.setAlignment(Element.ALIGN_CENTER);


   

            Paragraph tienda= new Paragraph();
            tienda.add("CUADRE");
            tienda.setAlignment(Element.ALIGN_CENTER);


            Paragraph tiempo= new Paragraph();
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
            tiempo.add(""+gaño+"/"+gmes+"/"+gdia+" "+" HORA:"+ghora+":"+gminuto);
            tiempo.setAlignment(Element.ALIGN_CENTER);

            Paragraph zz1=new Paragraph();
            zz1.add("***********************************");
            zz1.setAlignment(Element.ALIGN_CENTER);

            Paragraph zz2=new Paragraph();
            listaProductos.forEach(tab -> {
                
                String linea=tab.getNombre()+":"+"   "+tab.getPrecioVenta()+" x "+tab.getCantidadVendida()+" \f "+tab.getPrecioTotal()+"\n";
                zz2.add(linea);
                zz2.setAlignment(Element.ALIGN_CENTER);
            });
 
            
            

            Paragraph zzh=new Paragraph();
            zzh.add("***********************************");
            zzh.setAlignment(Element.ALIGN_CENTER);

            Paragraph precioT=new Paragraph();
            precioT.add("Precio Total :"+precioTotal);
            precioT.setAlignment(Element.ALIGN_CENTER);


            
            
  
            
            
            
            rutaAImprimir="Cuadre/"+""+gaño+""+gmes+""+gdia+" "+""+ghora+":"+gminuto+".pdf";
            PdfWriter archivo=PdfWriter.getInstance(documento,new FileOutputStream(rutaAImprimir));
            documento.open();
            
            
            
            Barcode128 codigo128=new Barcode128();
            codigo128.setCode(""+gdia);
            com.itextpdf.text.Image imagen= codigo128.createImageWithBarcode(archivo.getDirectContent(), BaseColor.BLACK, BaseColor.YELLOW);
            
            imagen.scalePercent(100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(zz);
            documento.add(tienda);
            documento.add(tiempo);
            documento.add(zz1);
            documento.add(zz2);
            documento.add(zzh);
            documento.add(precioT);
     
        
            documento.close();
        }catch(Exception e){
            System.out.println("ERROR"+e);
        }
        return rutaAImprimir;
    
    }
}
