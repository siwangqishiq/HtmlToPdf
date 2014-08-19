package com.xinlan.ht2pf;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.rtf.RtfWriter2;

public class ItextCreateRTF
{
    public static void main(String[] args) throws Exception {  
        OutputStream out = new FileOutputStream("F://a.doc");  
        Document document = new Document(PageSize.A4);  
        RtfWriter2.getInstance(document, out);  
        document.open();  
        Paragraph context = new Paragraph();  
        String s = "ÉÏ´«µÄÍ¼Æ¬<img width=\"800\" height=\"600\" alt=\"\" src=\"http://www.dongao.com/zckjs/UploadFiles_8424/201407/2014072315194093.png\" />";  
        System.out.println(s);  
        StyleSheet ss = new StyleSheet();  
        List htmlList = HTMLWorker.parseToList(new StringReader(s), ss);  
        for (int i = 0; i < htmlList.size(); i++) {  
            com.lowagie.text.Element e = (com.lowagie.text.Element) htmlList  
                    .get(i);  
            context.add(e);  
        }  
        document.add(context);  
        document.close();  
        System.out.println("ok");  
    }  
}
