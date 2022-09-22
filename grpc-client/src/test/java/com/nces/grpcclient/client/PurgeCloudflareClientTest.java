package com.nces.grpcclient.client;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PurgeCloudflareClientTest {

    @Test
    void purgeCloudflare() {
        PurgeCloudflareClient client = new PurgeCloudflareClient();
        client.init();
        // change your own apiKey
        String apiKey = "apiKey";
        // change your own apiEmail
        String apiEmail = "apiEmail";
        // change your own zoneId
        String zoneId = "zoneId";
        String[] purgeList = {"https://www.rhyuheg.site", "https://www.rhyuheg2.site/foo"};
        if(client.purgeCloudflare(apiKey, apiEmail, zoneId, purgeList)) {
            System.out.println(Arrays.toString(purgeList) + " under the " + zoneId + " purge success");
        }
        else System.out.println("purge fail");
//        if(client.purgeCloudflareEverything(apiKey, apiEmail, zoneId)) {
//            System.out.println(zoneId + " purgeEverything success");
//        }
//        else System.out.println("purgeEverything fail");
    }
}