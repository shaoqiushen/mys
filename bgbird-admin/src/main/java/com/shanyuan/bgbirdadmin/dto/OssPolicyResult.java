package com.shanyuan.bgbirdadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-05 16:59
 * <p>
 * desc获取OSS上传授权返回结果
 **/
@Data
public class OssPolicyResult {
    private String accessKeyId;
    private String policy;
    private String signature;
    private String dir;
    private String host;
}
