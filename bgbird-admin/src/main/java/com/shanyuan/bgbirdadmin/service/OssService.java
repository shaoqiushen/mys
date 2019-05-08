package com.shanyuan.bgbirdadmin.service;

import com.shanyuan.bgbirdadmin.dto.OssCallbackResult;
import com.shanyuan.bgbirdadmin.dto.OssPolicyResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-05 17:01
 * <p>
 * desc
 **/
public interface OssService {
//    OssPolicyResult policy();
//    OssCallbackResult callBack(HttpServletRequest request);
    String uploadImg(MultipartFile file);
}
