package com.nces.grpcclient.client;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PurgeCloudflareClientTest {

    @Test
    void purgeCloudflare() {
        PurgeCloudflareClient client = new PurgeCloudflareClient();
        client.init();
        String apiKey = "676f8785dad552acb6ea14d3e822bc41a2070";
        String apiEmail = "haolong@centcloud.net";
        String zoneName = "rhyuheg.site";
        String[] purgeList = {"https://www.rhyuheg.site", "https://www.rhyuheg2.site/foo"};
        if(client.purgeCloudflare(apiKey, apiEmail, zoneName, purgeList)) {
            System.out.println(Arrays.toString(purgeList) + " under the " + zoneName + " purge success");
        }
        else System.out.println("purge fail");
    }
}