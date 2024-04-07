package ru.leonchik;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static java.lang.System.out;

public class Work {
    public static final Integer TIMEOUT = 1 * 1000; // 1 sec

    public void mySleep(int mSec) {
        try {
            out.println("Sleep " + mSec + " mSec");
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void myConn(String host, Integer port) {
        System.out.println("Connect to " + host + ":" + port);
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, TIMEOUT);
            socket.close();
        } catch (IOException e) {
            //System.out.println(port);
        }
    }
}