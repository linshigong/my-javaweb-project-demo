package test.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ACE计量项pojo class
 * 
 * <uid>default</uid>
		<pid>ace</pid>
		<bid>aliyun</bid>
		<inst_id>1</inst_id>
		<time>1334023200</time>
		<cpu_acc_usage>0</cpu_acc_usage>
		<memcache_size>0</memcache_size>
		<req_count>0</req_count>
		<lb_id>0</lb_id>
		<version>1</version>
		<end_time>1334026800</end_time>
 * 
 */
@XmlRootElement(name="Object")
public class AceCalcStrutsData implements Serializable {

	private static final long serialVersionUID = -8650628115170980173L;
	
	/** openid#pid#bid组合,openid是用户id,pid是ace,bid是app_id **/
	@XmlElement(name="uid")
	private String uuid;
	
	/** app应用id **/
	@XmlElement(name="inst_id")
	private String appId;
	
	/** 抽样开始时间 s **/
	@XmlElement(name="time")
	private long startTime;
	
	/** 在抽样开始时间和抽样结束时间时间段(下同)内cpu的使用时间 s **/
	@XmlElement(name="cpu_acc_usage")
	private long cpuAccUsage;
	
	/** memcache占用内存大小 **/
	@XmlElement(name="memcache_size")
	private long memcacheSize;
	
	/** 时间段内的请求总数 **/
	@XmlElement(name="req_count")
	private long reqCount;
	
	@XmlElement(name="lb_id")
	private String lbId;
	
	/** 版本号，目前为1 **/
	@XmlElement(name="version")
	private int version;
	
	/** 抽样结束时间 **/
	@XmlElement(name="end_time")
	private long endTime;
	
	//for uuid
	/** 终端用户 **/
	@XmlElement(name="bid")
	private String endUserId;
	
	/** 服务ID eg:vm,oss,slb **/
	@XmlElement(name="pid")
	private String serviceId;
	
	
	public AceCalcStrutsData() {
		this.serviceId = "ace";//待定 eg:vm,oss etc
		this.endUserId = "default";
		this.version = 1;
	}
	
	/**
	 * uuid = enduserid#serviceid#appid
	 * @param endUserId
	 * @param serviceId
	 * @param appId
	 */
	public void setUuid(String endUserId,String serviceId,String appId) {
		this.endUserId = endUserId;
		this.serviceId = serviceId;
		this.appId = appId;
	}
	
	public String getUuid() {
		StringBuffer sb = new StringBuffer(endUserId);
		sb.append("#");
		sb.append(serviceId);
		sb.append("#");
		sb.append(appId);
		return sb.toString();
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getCpuAccUsage() {
		return cpuAccUsage;
	}
	public void setCpuAccUsage(long cpuAccUsage) {
		this.cpuAccUsage = cpuAccUsage;
	}
	public long getMemcacheSize() {
		return memcacheSize;
	}
	public void setMemcacheSize(long memcacheSize) {
		this.memcacheSize = memcacheSize;
	}
	public long getReqCount() {
		return reqCount;
	}
	public void setReqCount(long reqCount) {
		this.reqCount = reqCount;
	}
	public String getLbId() {
		return lbId;
	}
	public void setLbId(String lbId) {
		this.lbId = lbId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getEndUserId() {
		return endUserId;
	}
	public void setEndUserId(String endUserId) {
		this.endUserId = endUserId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	@Override
	public String toString() {
		return "uuid:" + getUuid() + " appId:" + appId + " startTime:"
				+ startTime + " cpuAccUsage:" + cpuAccUsage + " memcacheSize:"
				+ memcacheSize + " reqCount:" + reqCount + " lbId:" + lbId
				+ " version:" + version + " endTime:" + endTime;
	}
}
