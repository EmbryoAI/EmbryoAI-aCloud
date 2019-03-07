package com.embryoai.acloud.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.embryoai.acloud.common.config.ParamConfig;

/**
 * minio操作工具类
 * @author liudm
 *
 */
public class MinioUtil {
	
	private static final Logger log = LoggerFactory.getLogger(MinioUtil.class);
		
    public static boolean createMinioUser(ParamConfig conf,String minioUsername,String minioKey) {
    	boolean flag = false;
    	try {
    		log.info("开始创建minio用户,ip:{},minioAlias:{},minioUser:{},minioKey:{}",conf.getLinuxIp(),conf.getMinioAlias(),minioUsername,minioKey);
    		String cmd = "mc admin users add " + conf.getMinioAlias() +" " + minioUsername + " " + minioKey + " readwrite";
    		String result = RemoteCommandUtil.execute(conf.getLinuxIp(), conf.getLinuxUsername(), conf.getLinuxPassword(), cmd);
    		log.info("创建minio用户返回结果：{}",result);
    		String succResult = "Added used `" + minioUsername + "` successfully.";
    		if(succResult.equals(result)) {
    			log.info("创建minio用户成功。");
    			flag = true;
    		}
    	} catch (Exception e) {
			log.error("在服务器：{} 上创建minio用户失败！",conf.getLinuxIp());
			e.printStackTrace();
			flag = false;
		}
		return flag;
    }
}
