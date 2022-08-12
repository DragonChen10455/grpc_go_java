package com.nces.grpcclient.client;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PurgeCloudflareClientTest {

    @Test
    void purgeCloudflare() {
        PurgeCloudflareClient client = new PurgeCloudflareClient();
        client.init();
        String apiKey = "apiKey";
        String apiEmail = "apiEmail";
        String zoneName = "rhyuheg.site";
        String[] purgeList = {"https://www.rhyuheg.site", "https://www.rhyuheg2.site/foo"};
        if(client.purgeCloudflare(apiKey, apiEmail, zoneName, purgeList)) {
            System.out.println(Arrays.toString(purgeList) + " under the " + zoneName + " purge success");
        }
        else System.out.println("purge fail");
    }
}