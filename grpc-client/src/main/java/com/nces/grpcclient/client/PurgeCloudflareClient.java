package com.nces.grpcclient.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.cloudflare.cache.purge.PurgeCloudflareGrpc;
import io.grpc.cloudflare.cache.purge.PurgeReplyCloudflare;
import io.grpc.cloudflare.cache.purge.PurgeRequestCloudflare;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Slf4j
public class PurgeCloudflareClient {
    /**
     * 阻塞stub
     */
    private PurgeCloudflareGrpc.PurgeCloudflareBlockingStub serviceBl;

    @PostConstruct
    public void init(){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        serviceBl = PurgeCloudflareGrpc.newBlockingStub(managedChannel);
    }

    public Boolean purgeCloudflare(String apiKey, String apiEmail, String zoneName, String[] purgeList){
        PurgeRequestCloudflare request = PurgeRequestCloudflare.newBuilder()
                .setApiKey(apiKey)
                .setApiEmail(apiEmail)
                .setZoneName(zoneName)
                .addAllPurgeList(Arrays.asList(purgeList)).build();
        PurgeReplyCloudflare reply = serviceBl.purgeCloudflare(request);
        return reply.getResult();
    }
}
