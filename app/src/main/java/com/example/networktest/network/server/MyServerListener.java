package com.example.networktest.network.server;

import android.util.Log;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.networktest.network.NetworkPackages;

public class MyServerListener extends Listener {



    public void connected(Connection connection)
    {
        // jemand ist dem Server beigetreten
        Log.d("Server: ","Jemand ist dem Server beigetreten" );
    }

    public void disconnected(Connection connection)
    {
        // jemand hat den Server verlassen
        Log.d("Server: ","Jemand hat den Server verlassen" );
    }

    public void received(Connection connection, Object object)
    {
        if (object instanceof NetworkPackages.Packet01Message)
        {
            NetworkPackages.Packet01Message message = (NetworkPackages.Packet01Message) object;
            // do something with it
            Log.d("Client: ",message.getMessage() );
        }
    }
}
