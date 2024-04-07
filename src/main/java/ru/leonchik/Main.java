package ru.leonchik;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        String jarName = "";
        Integer[] ports = { 7000, 8000, 9000 };

        try {
            // Get path of the JAR file
            String jarPath = Main.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();

            // Get name of the JAR file
            jarName = jarPath.substring(jarPath.lastIndexOf("/") + 1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (args.length == 4) {
            Work wrk = new Work();

            for (int i = 0; i < 3; i++) {
                ports[i] = Integer.parseInt(args[i + 1]);
                wrk.myConn(args[0], ports[i]);
                wrk.mySleep(1000);
            }

        } else {
            System.out.println(jarName + " host.name.tld NumPort1 NumPort2 NumPort3");
        }
    }
}
