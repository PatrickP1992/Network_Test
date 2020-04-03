package com.example.networktest.network.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.example.networktest.network.NetworkPackages;
import com.example.networktest.network.Ports;

import java.io.IOException;

public class MyKryoServer {
    private String servername;
    private Server server;
    private MyServerListener listener;
    private Kryo kryo;

    public MyKryoServer(String servername) {
        this.servername = servername;
        server = new Server();
        listener = new MyServerListener();
        kryo = server.getKryo();
        registerPackages();
    }


    public void startServer() throws IOException {
        server.start();
        server.bind(Ports.TCP, Ports.UDP);
        server.addListener(listener);
    }

    private void registerPackages()
    {
        kryo.register(NetworkPackages.Packet01Message.class);
    }

    public void stopServer() {
        server.stop();
    }


}



