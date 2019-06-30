package com.kblive.usersystem.common.utils.messagetools;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;

/**
 * title: StringTools
 * projectName kbLive
 * description: 发送短信验证码工具
 * author 2671242147@qq.com
 * date 2019-06-29 15:00
 ***/
public class SendCodeUtil {

    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    static final String accessKeyId = "LTAIpQC18DdC96";
    static final String accessKeySecret = "E8CYucN0WrvxGfjSbXagQ1acj02b";
    static final Logger logger=Logger.getLogger(SendCodeUtil.class);

    /**
     * 发送短信
     * @param phone 手机号
     * @param code 验证码
     * @return SendSmsResponse
     * @throws ClientException 异常
     */
    public static SendSmsResponse sendSms(String phone, String code) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(phone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName("zkong科技");
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_151772425");
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + code + "\"}");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        // hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            // 请求成功
            System.out.println("请求成功");
        }
        return sendSmsResponse;
    }
    /**
     * 向手机号码发送消息
     * @param phone 手机号
     * @return 验证码
     */
    public static String sendSm(String phone) throws ClientException {
        String code = String.valueOf((int) (Math.random() * 1000000));
        int num = Integer.parseInt(code);
        if (num < 100000) {
            num += 100000;
        }
        code = String.valueOf(num);
        sendSms(phone, code);
        logger.info("验证码为："+code);
        return code;
    }

    //测试
    public static void main(String[] args) throws ClientException {
        sendSm("18873269672");
    }
}
