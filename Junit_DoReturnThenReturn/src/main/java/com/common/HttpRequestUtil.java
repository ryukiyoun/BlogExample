package com.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestUtil implements RequestUtil{
    HttpURLConnection httpURLConnection = null;

    @Override
    public void Connection(String address) {
        try {
            httpURLConnection = (HttpURLConnection) (new URL(address).openConnection());
        }
        catch (IOException ioException) {
            throw new RuntimeException("http connection fail");
        }
    }

    @Override
    public String GetRequest(String param) {
        if(httpURLConnection != null){
            DataOutputStream out = null;
            BufferedReader in = null;

            try {
                httpURLConnection.setRequestMethod("GET");

                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));

                out = new DataOutputStream(httpURLConnection.getOutputStream());
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                out.writeBytes(param);

                StringBuilder result = new StringBuilder();
                String buffer;

                while((buffer = in.readLine()) != null)
                    result.append(buffer).append("\n");

                return result.toString();
            }
            catch (IOException ioException) {
                throw new RuntimeException("request fail");
            }
            finally {
                try {
                    out.close();
                    in.close();
                }
                catch (IOException ignored){

                }
            }
        }
        else
            throw new NullPointerException("connection is null");
    }
}
