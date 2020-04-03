package com.example.networktest.network.client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.example.networktest.network.NetworkPackages;
import com.example.networktest.network.Ports;

import java.io.IOException;

public class MyKryoClient {
    private String name;
    private Client client;
    private MyClientNetworkListener listener;
    private Kryo kryo;

    public MyKryoClient(String name) {
        this.name = name;
        client = new Client();
        listener = new MyClientNetworkListener();
        listener.init(client);
        this.kryo = client.getKryo();
        registerPackages();
    }

    public void startClient()
    {
        client.start();
    }


    public void connectToServer(String server) throws IOException
    {
        client.connect(5000, server, Ports.TCP, Ports.UDP);
        client.addListener(listener);
    }

    public void stopConnection()
    {
        client.close();
    }

    public void sendMessage(String message)
    {


    }

    private void registerPackages()
    {
        kryo.register(NetworkPackages.Packet01Message.class);
    }



}
