package edu.emu.netmonitoring.controller;

import java.util.List;

public class IntegratedScanner {

    public static void main(String[] args) {
        NetworkInterfaceInfo networkInfo = new NetworkInterfaceInfo();
        List<String> ipAddresses = networkInfo.getInterfaceIPAddresses();

        for (String ipAddress : ipAddresses) {
            System.out.println("Scanning ports for IP address: " + ipAddress);
            // Example port range, adjust as needed
            int startPort = 80;
            int endPort = 100;
            PortScanner.scanPorts(ipAddress, startPort, endPort);
        }
    }
}
