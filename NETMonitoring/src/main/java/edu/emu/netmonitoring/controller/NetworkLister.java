package edu.emu.netmonitoring.controller;

import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkLister {

    public static void listNetworkInterfaces() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface iface : Collections.list(interfaces)) {
                System.out.println("Interface Name: " + iface.getName());
                System.out.println("Interface Display Name: " + iface.getDisplayName());
                System.out.println("Is up? " + iface.isUp());
                System.out.println("Is loopback? " + iface.isLoopback());
                System.out.println("Is virtual? " + iface.isVirtual());
                System.out.println("Hardware Address: " + Arrays.toString(iface.getHardwareAddress()));
                System.out.println("MTU: " + iface.getMTU());
                System.out.println("-------------------------------------------------------");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        listNetworkInterfaces();
    }
}
