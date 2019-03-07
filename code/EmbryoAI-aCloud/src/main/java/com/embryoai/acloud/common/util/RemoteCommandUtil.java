package com.embryoai.acloud.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.embryoai.acloud.common.config.ParamConfig;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * 远程连接linux服务器工具类
 * @author liudm
 *
 */
public class RemoteCommandUtil {
	
	private static final Logger log = LoggerFactory.getLogger(RemoteCommandUtil.class);
		
    private static String  DEFAULTCHART="UTF-8"; 

    /** 
     * 登录主机 
     * @return 
     *      登录成功返回true，否则返回false 
     */  
	public static Connection login(String ip,String userName,String userPwd){  

        boolean flg=false;
        Connection conn = null;
        try {  
            conn = new Connection(ip);  
            conn.connect();//连接  
            flg=conn.authenticateWithPassword(userName, userPwd);//认证  
            if(flg){
                log.info("=========登录成功========="+conn);
                return conn;
            }
        } catch (IOException e) {  
            log.error("=========登录失败=========ip:{},userame:{},password:{}",ip,userName,userPwd);
            e.printStackTrace();  
        }  
        return conn;  
    }  

	/**
	 * 远程执行shll脚本或者命令 
	 * @param ip 服务器ip
	 * @param username 服务器用户名
	 * @param password 服务器密码
	 * @param cmd 命令
	 * @return 命令执行完后返回的结果值 
	 */
    public static String execute(String ip,String username,String password,String cmd){  
        String result="";  
        try {  
        	log.info("开始执行命令：{},参数[ip:{},userame:{},password:{}]",cmd,ip,username,password);
        	Connection conn = login(ip, username, password);
            if(conn !=null){  
                Session session= conn.openSession();//打开一个会话  
                session.execCommand(cmd);//执行命令  
                result=processStdout(session.getStdout(),DEFAULTCHART);  
                //如果为得到标准输出为空，说明脚本执行出错了  
                if(StringUtils.isBlank(result)){
                    log.info("得到标准输出为空,链接conn:"+conn+",执行的命令："+cmd);
                    result=processStdout(session.getStderr(),DEFAULTCHART);  
                }else{
                    log.info("执行命令成功,链接conn:"+conn+",执行的命令："+cmd);
                }  
                conn.close();  
                session.close();  
            }  
        } catch (Exception e) {
            log.error("执行命令失败,链接:"+ ip +",执行的命令："+cmd+"  "+e.getMessage());
            e.printStackTrace();  
        }  
        return result;  
    }
    
    /** 
     * 解析脚本执行返回的结果集 
     * @param in 输入流对象 
     * @param charset 编码 
     * @return 
     *       以纯文本的格式返回 
     */  
	private static String processStdout(InputStream in, String charset){  
		InputStream  stdout = new StreamGobbler(in);  
     	StringBuffer buffer = new StringBuffer();;  
     	try {  
     		BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));  
     		String line=null;  
     		while((line=br.readLine()) != null){  
     			buffer.append(line);  
     		}  
     	} catch (UnsupportedEncodingException e) { 
     		log.error("解析脚本出错："+e.getMessage());
     		e.printStackTrace();  
     	} catch (IOException e) {
     		log.error("解析脚本出错："+e.getMessage());
     		e.printStackTrace();  
     	}  
     	return buffer.toString();  
	}
	
//	public static void main(String[] args) {
//		String result = execute("39.104.173.18", "root", "astec.@c0", " mc admin users add mycloud  liuyz 123456789 readwrite");
//		System.out.println(result);
//		if("Added used `liuyz` successfully.".equals(result)) {
//			System.out.println("minio用户创建成功");
//		}
//		
//	}
}
