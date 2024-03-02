package edu.emu.netmonitoring.controller;

import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class NetworkInterfaceInfo {

    public List<String> getInterfaceIPAddresses() {
        List<String> ipAddresses = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isUp() && !iface.isLoopback()) {
                    Enumeration<InetAddress> addresses = iface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress addr = addresses.nextElement();
                        ipAddresses.add(addr.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ipAddresses;
    }
}
