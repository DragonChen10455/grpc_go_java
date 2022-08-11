package com.nces.grpcclient.service;

public interface PurgeCloudflareService {
    Boolean purgeCloudflare(String apiKey, String apiEmail, String zoneName, String[] purgeList);
}
