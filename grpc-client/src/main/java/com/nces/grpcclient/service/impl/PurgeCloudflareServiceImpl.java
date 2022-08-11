package com.nces.grpcclient.service.impl;

import com.nces.grpcclient.client.PurgeCloudflareClient;
import com.nces.grpcclient.service.PurgeCloudflareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PurgeCloudflareServiceImpl implements PurgeCloudflareService {
    @Resource
    PurgeCloudflareClient client;

    @Override
    public Boolean purgeCloudflare(String apiKey, String apiEmail, String zoneName, String[] purgeList) {
        return client.purgeCloudflare(apiKey, apiEmail, zoneName, purgeList);
    }
}
