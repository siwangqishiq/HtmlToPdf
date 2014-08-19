package com.xinlan.ht2pf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil
{
    /**
     * 读取文本文件内容
     * 
     * @param filepath
     * @return
     */
    public static String readTextFile(String filepath)
    {
        StringBuffer sb = new StringBuffer();
        BufferedReader buffer = null;
        String line = null;
        try
        {
            buffer = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filepath)));
            while ((line = buffer.readLine()) != null)
            {
                sb.append(line);
            }// end while
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (buffer != null)
            {
                try
                {
                    buffer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}//end class
