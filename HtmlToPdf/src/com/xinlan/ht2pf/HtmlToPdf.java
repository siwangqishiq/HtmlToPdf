package com.xinlan.ht2pf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.util.ArrayList;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class HtmlToPdf
{
    public static void main(String[] agrs)
    {
        HtmlToPdf instance = new HtmlToPdf();
        
        //instance.htmlCodeComeString("Hello中文\n你好 世界!", "D:\\iText_2.pdf");
        instance.htmlCodeComeFromFile("F:\\index.html", "F:\\iText_2.pdf");
//        try
//        {
//            instance.createPdf("F:\\index.html", "F:\\iText_2.pdf");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
    }
    
    public void createPdf(String filePath, String pdfPath) throws Exception {  
        String inputFile = filePath;  
        String url = new File(inputFile).toURI().toURL().toString();  
        String outputFile = pdfPath;  
        System.out.println(url);  
        // step 2  
        OutputStream os = new FileOutputStream(outputFile);  
        org.xhtmlrenderer.pdf.ITextRenderer renderer = new ITextRenderer();  
        renderer.setDocument(url);  
  
        // step 3 解决中文支持  
        org.xhtmlrenderer.pdf.ITextFontResolver fontResolver = renderer  
                .getFontResolver();  
        fontResolver.addFont("c:/Windows/Fonts/simsun.ttc", BaseFont.IDENTITY_H,     
                BaseFont.NOT_EMBEDDED);  
  
        renderer.layout();  
        renderer.createPDF(os);  
        os.close();  
          
        System.out.println("create pdf done!!");  
    }  
    
    public  void htmlCodeComeFromFile(String filePath, String pdfPath)
    {
        Document document = new Document();
        try {  
            StyleSheet st = new StyleSheet();  
            st.loadTagStyle("body", "leading", "16,0");  
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));  
            document.open();  
            ArrayList p = HTMLWorker.parseToList(new FileReader(filePath), st);  
            for(int k = 0; k < p.size(); ++k) {  
                document.add((Element)p.get(k));  
            }  
            document.close();  
            System.out.println("文档创建成功");  
        }catch(Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    public void htmlCodeComeString(String htmlCode, String pdfPath) {  
        Document doc = new Document(PageSize.A4);  
        try {  
            PdfWriter.getInstance(doc, new FileOutputStream(pdfPath));  
            doc.open();  
            // 解决中文问题  
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);  
            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);  
            Paragraph t = new Paragraph(htmlCode, FontChinese);  
            doc.add(t);  
            doc.close();  
            System.out.println("文档创建成功");  
        }catch(Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
}//end class
