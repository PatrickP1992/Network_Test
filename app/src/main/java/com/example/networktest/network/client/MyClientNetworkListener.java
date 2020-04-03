package com.example.networktest.network.client;

import android.util.Log;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.networktest.network.NetworkPackages;

public class MyClientNetworkListener extends Listener {

    private Client client;

    public void init(Client client)
    {
        this.client = client;
    }

    public void connected(Connection connection)
    {
        Log.d("Client: ", "Verbunden mit dem Server");

        NetworkPackages.Packet01Message verbunden = new NetworkPackages.Packet01Message();
        verbunden.setMessage("Client ist mit dem Server verbunden");

        client.sendTCP(verbunden);
    }

    public void disconnected(Connection connection)
    {
        Log.d("Client: ", "Verbindung mit dem Server wurde getrennt");
    }

    public void received(Connection connection, Object object)
    {
        if (object instanceof NetworkPackages.Packet01Message)
        {
            NetworkPackages.Packet01Message message = (NetworkPackages.Packet01Message) object;
            // do something with it
            Log.d("Server: ",message.getMessage() );
        }
    }
}
