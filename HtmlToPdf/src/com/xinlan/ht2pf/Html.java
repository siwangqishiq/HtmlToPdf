package com.xinlan.ht2pf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.pdf.BaseFont;

public class Html
{

    public static void main(String[] args) throws Exception
    {
        //htmlToPdf2();
        htmlFileToPdf("F:/index.html","F:/test333.pdf");
    }

    // 支持中文
    public static void htmlToPdf2() throws Exception
    {
        String outputFile = "F:/demo_3.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc",
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        StringBuffer html = new StringBuffer();
        // DOCTYPE 必需写否则类似于 这样的字符解析会出现错误
        html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
        html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n")
                .append("<head>\n")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n")
                .append("<style type=\"text/css\" mce_bogus=\"1\">body {font-family: SimSun;}</style>\n")
                .append("</head>").append("<body>");
        html.append("<div>支持中文！</div>");
        html.append("</body></html>");
        System.out.println(html.toString());
        renderer.setDocumentFromString(html.toString());
        renderer.layout();
        renderer.createPDF(os);
        System.out.println("======转换成功!");
        os.close();
    }
    
    public static void htmlFileToPdf(String src,String dst) throws Exception
    {
        String outputFile = dst;
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc",
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String html = new String();
        // DOCTYPE 必需写否则类似于 这样的字符解析会出现错误
        html = FileUtil.readTextFile(src);
        System.out.println(html);
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(os);
        System.out.println("======转换成功!");
        os.close();
    }

    public static void htmlToPdf3() throws Exception
    {
        String inputFile = "F:/index.html";
        String outFile = "F:/test.pdf";
        OutputStream os = null;
        os = new FileOutputStream(outFile);
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("C:/Windows/fonts/simsun.ttc",
                BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String url = new File(inputFile).toURI().toURL().toString();
        System.out.println("=============url: " + url);
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);
        System.out.println("======转换成功!");
        os.close();
    }
}// end class
