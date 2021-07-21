package com.cestc.vspace.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-alipay.yml")
@ConfigurationProperties(prefix = "alipay")
public class PaymentConfig {
	//应用唯一表示
	@Value("appId")
	private String appId;
	//应用私钥
	@Value("privateKey")
	private String privateKey;
	//支付宝公钥
	@Value("alipayPublicKey")
	private String alipayPublicKey;
	//异步通知跳转url
	@Value("notifyUrl")
	private String notifyUrl;
	//同步通知跳转url
	@Value("redirectUrl")
	private String redirectUrl;
	//数字签名类型
	@Value("signType")
	private String signType;
	//编码方式
	@Value("charset")
	private String charset;
	//支付宝网关
	@Value("alipayGateway")
	private String alipayGateway;
	//日志存储url
	@Value("logPath")
	private String logPath;
	
	@Override
	public String toString() {
	return "PaymentConfig{" +
	"appId='" + appId + '\'' +
	", privateKey='" + privateKey + '\'' +
	", alipayPublicKey='" + alipayPublicKey +
	'\'' +
	", notifyUrl='" + notifyUrl + '\'' +
	", redirectUrl='" + redirectUrl + '\'' +
	", signType='" + signType + '\'' +
	", charset='" + charset + '\'' +
	", alipayGateway='" + alipayGateway + '\''
	+
	", logPath='" + logPath + '\'' +
	'}';
	}

	public String getAlipayGateway() {
		return alipayGateway;
		}
	public void setAlipayGateway(String alipayGateway) {
		this.alipayGateway = alipayGateway;
		}
	public String getAppId() {
		return appId;
		}
	public void setAppId(String appId) {
		this.appId = appId;
		}
	public String getPrivateKey() {
		return privateKey;
		}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
		}
	public String getAlipayPublicKey() {
		return alipayPublicKey;
		}
	public void setAlipayPublicKey(String alipayPublicKey)
		{
		this.alipayPublicKey = alipayPublicKey;
		}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getLogPath() {
		return logPath;
	}
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

}
