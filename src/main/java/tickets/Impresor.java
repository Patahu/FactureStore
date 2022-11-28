/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
/**
 *
 * @author fell
 */
public class Impresor {

    private final static Logger LOGGER = Logger.getLogger("mx.hash.impresionpdf.Impresor");


    public void imprimir(String ruta) throws PrinterException, IOException {
        PDDocument doc = PDDocument.load(new File(ruta));
        PrinterJob job = PrinterJob.getPrinterJob();

        // define custom paper
        Paper paper = new Paper();
        int altura=500;
        paper.setSize(200, 500); // 1/72 inch
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins

        // custom page format
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);

        // override the page format
        Book book = new Book();
        // append all pages
        book.append(new PDFPrintable(doc, Scaling.ACTUAL_SIZE), pageFormat, doc.getNumberOfPages());
        job.setPageable(book);

        job.print();
    }    
}
