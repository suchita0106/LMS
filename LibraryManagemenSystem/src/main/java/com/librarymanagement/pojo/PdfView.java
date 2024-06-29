package com.librarymanagement.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 
 * OpenPDF since it is actively maintained and fixes an **
 *important vulnerability for untrusted PDF content.
 *
 *This view implementation uses Bruno Lowagie's iText API
 *
 **/
public class PdfView extends AbstractPdfView {
	
	private static final String FILE_DIR = System.getProperty("user.dir") + "/uploads/"; 
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filename = (String) model.get("filename");
        File file = new File(FILE_DIR, filename);
        
        if (file.exists() && filename.endsWith(".pdf")) {
            PdfReader reader = new PdfReader(new FileInputStream(file));
            PdfContentByte cb = writer.getDirectContent();
            
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                cb.addTemplate(writer.getImportedPage(reader, i), 0, 0);
            }
        }
    }


}
