package com.gabrielbellon.calculadoraip;

import org.apache.commons.net.util.SubnetUtils;
import org.apache.commons.net.util.SubnetUtils.SubnetInfo;

//mostra as subredes, endereços de rede e broadcast, host possíveis, etc.
public class NetCalc {

	private SubnetUtils utils;
	private SubnetInfo info;

	private String subnetBits;
	private String ip;
	private String cidrIP;

	public NetCalc(String ip, String subnetBits) {
		this.cidrIP = ip + "/" + subnetBits;

		this.utils = new SubnetUtils(cidrIP);
		this.info = utils.getInfo();
	}

	public String getNetmask() {
		return this.info.getNetmask();
	}

	public String getBroadcast() {
		return this.info.getBroadcastAddress();
	}

	public String getHighAddress() {
		return this.info.getHighAddress();
	}

	public String getLowAddress() {
		return this.info.getLowAddress();
	}

	public int getHostCount() {
		return this.info.getAddressCount();
	}

	public String getNetAddress() {
		return this.info.getNetworkAddress();
	}

	public String[] getAllAddresses() {
		return this.info.getAllAddresses();
	}

	// Atualiza os valores e as classes SubnetUtils e Info para um novo IP
	public void updateWithNewIP(String ip, String subnetBits) {
		this.cidrIP = ip + "/" + subnetBits;

		this.utils = new SubnetUtils(cidrIP);
		this.info = utils.getInfo();
	}

	// Getters, não há necessidade de setters
	public String getSubnetBits() {
		return subnetBits;
	}

	public String getIp() {
		return ip;
	}

	public String getCidrIP() {
		return cidrIP;
	}

}
