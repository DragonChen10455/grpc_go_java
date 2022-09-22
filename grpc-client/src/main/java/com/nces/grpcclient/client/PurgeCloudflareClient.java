package com.nces.grpcclient.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.cloudflare.cache.purge.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Slf4j
public class PurgeCloudflareClient {
    /**
     * BlockingStub
     */
    private PurgeCloudflareGrpc.PurgeCloudflareBlockingStub serviceBl;

    @PostConstruct
    public void init(){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        serviceBl = PurgeCloudflareGrpc.newBlockingStub(managedChannel);
    }

    public Boolean purgeCloudflare(String apiKey, String apiEmail, String zoneId, String[] purgeList){
        PurgeRequestCloudflare request = PurgeRequestCloudflare.newBuilder()
                .setApiKey(apiKey)
                .setApiEmail(apiEmail)
                .setZoneId(zoneId)
                .addAllPurgeList(Arrays.asList(purgeList)).build();
        PurgeReplyCloudflare reply = serviceBl.purgeCloudflare(request);
        return reply.getResult();
    }
    public Boolean purgeCloudflareEverything(String apiKey, String apiEmail, String zoneId){
        PurgeRequestCloudflareEverything request = PurgeRequestCloudflareEverything.newBuilder()
                .setApiKey(apiKey)
                .setApiEmail(apiEmail)
                .setZoneId(zoneId).build();
        PurgeReplyCloudflare reply = serviceBl.purgeCloudflareEverything(request);
        return reply.getResult();
    }
}
