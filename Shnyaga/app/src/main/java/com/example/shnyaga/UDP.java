package com.example.shnyaga;
//#include <ESP8266WiFi.h>
//#include <WiFiUdp.h>
public class UDP {

    /*
    void setup()
    {

        Serial.begin(115200);
        Serial.println();
        WiFi.begin("network-name", "pass-to-network");
        Serial.print("Connecting");  //  "Подключение"
        while (WiFi.status() != WL_CONNECTED)
        {
            delay(500);
            Serial.print(".");
        }
        Serial.println();

        Serial.print("Connected, IP address: ");
        Serial.println(WiFi.localIP());
    }
    void loop()
    {int packetSize = Udp.parsePacket();

if (packetSize)

{
  Serial.printf("Received %d bytes from %s, port %d\n", packetSize, Udp.remoteIP().toString().c_str(), Udp.remotePort());
  int len = Udp.read(incomingPacket, 255);
  if (len > 0)
    }
    incomingPacket[len] = 0;
  }
  Serial.printf("UDP packet contents: %s\n", incomingPacket);

}
    }
     */
const char* ssid = "adolf gitler";
const char* password = "1488";
    WiFiUDP Udp;
    int localUdpPort = 4210;  // локальный порт для прослушки
    char incomingPacket[];
    incomingPacket[] = new char[255];
    char  replyPacket[] = "1";  // ответ
    void setup()
    {
        Serial.begin(115200);
        Serial.println();
        Serial.printf("Connecting to %s ", ssid);
        WiFi.begin(ssid, password);
        while (WiFi.status() != WL_CONNECTED)
        {

            delay(500);
            Serial.print(".");

        }
        Serial.println(" connected");
        Udp.begin(localUdpPort);
        Serial.printf("Now listening at IP %s, UDP port %d\n", WiFi.localIP().toString().c_str(), localUdpPort);

    }

    void loop()
    {
        int packetSize = Udp.parsePacket();
        if (packetSize)
        {
            Serial.printf("Received %d bytes from %s, port %d\n", packetSize, Udp.remoteIP().toString().c_str(), Udp.remotePort());
            int len = Udp.read(incomingPacket, 255);
            if (len > 0)
            {
                incomingPacket[len] = 0;
            }
            Serial.printf("UDP packet contents: %s\n", incomingPacket);
            Udp.beginPacket(Udp.remoteIP(), Udp.remotePort());
            Udp.write(replyPacekt);
            Udp.endPacket();


        }

    }

}
