package com.ash.cloud.modules.product.controller;

import com.ash.cloud.common.utils.Result;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 商品属性
 *
 * @author Ash ash@ash.com
 * @since 1.0.0 2022-07-24
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("third-service/minio")
public class MinioController {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.port}")
    private Integer port;

    @Value("${minio.secure}")
    private Boolean secure;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucket}")
    private String bucket;

    @GetMapping("getPresignedObjectUrl")
    public Result<Map<String, String>> getPresignedObjectUrl(String name) throws Exception {

        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint, port, secure)
                .credentials(accessKey, secretKey)
                .build();

        String url = minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.PUT)
                                .bucket(bucket)
                                .object(name)
                                .expiry(5, TimeUnit.MINUTES)
                                .build());

        Map<String, String> map = new HashMap<>();
        map.put("url", url);

        return new Result<Map<String, String>>().ok(map);
    }
}