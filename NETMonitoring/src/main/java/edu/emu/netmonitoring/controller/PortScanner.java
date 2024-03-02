package edu.emu.netmonitoring.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PortScanner {

    public static void scanPorts(String ipAddress, int startPort, int endPort) {
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                // Connect with a timeout of 200 milliseconds
                socket.connect(new InetSocketAddress(ipAddress, port), 200);
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                System.out.println("Port " + port + " is closed.");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        String ipAddress = "127.0.0.1"; // IP address to scan
        int startPort = 80; // Start of port range
        int endPort = 100; // End of port range
        scanPorts(ipAddress, startPort, endPort);
    }
}
