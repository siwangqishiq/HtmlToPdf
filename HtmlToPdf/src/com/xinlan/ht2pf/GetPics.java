package com.xinlan.ht2pf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class GetPics
{
    public static final String[] baseUrl = {
            "http://www.dongao.com/zckjs/ksgs/201407/175391.shtml",// 1
            "http://www.dongao.com/zckjs/ksgs/201407/175666.shtml",// 2
            "http://www.dongao.com/zckjs/ksgs/201407/176041.shtml",// 3
            "",// 4
            "",// 5
            "",// 6
            "",// 7
            "",// 8
            "",// 9
            "",// 10
            "",// 11
            "",// 12
            "",// 13
            "",// 14
            "" };// 15

    public static void main(String[] args)
    {
        //download("http://www.dongao.com/zckjs/UploadFiles_8424/201408/2014081215132521.png");
        //http://image5.suning.cn/images/shop/cms/4225/1408274737565_1200.jpg
        download("http://image5.suning.cn/images/shop/cms/4225/1408274737565_1200.jpg");
    }
    
    public static String getName(String urlString)
    {
        int lastIndex = urlString.lastIndexOf("/");
        return urlString.substring(lastIndex+1);
    }
    
    public static void download(String urlString)
    {
         download(urlString,getName(urlString));
    }
    

    public static void download(String urlString, String filename)
    {
        // 构造URL
        OutputStream os = null;
        InputStream is = null;
        try
        {
            System.out.println("下载--->"+urlString+"      ===>"+filename);
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            // 开始读取
            os = new FileOutputStream(filename);
            while ((len = is.read(bs)) != -1)
            {
                os.write(bs, 0, len);
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println(e);
            e.printStackTrace();
        }finally{
            // 完毕，关闭所有链接
            try
            {
                os.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
