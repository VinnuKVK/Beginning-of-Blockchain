package com.vin.block;

import java.util.Date;

import com.vin.utility.StringUtility;

public class Block {

	private String hash;
	private String previousHash;
	private String data;
	private long timestamp; // milliseconds elapsed since 1/1/1970
	private int nonce;
	
	
	
	public Block(String data, String previousHash) {
		super();
		this.previousHash = previousHash;
		this.data = data;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash();
	}


	public String getHash() {
		return hash;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}


	public String getPreviousHash() {
		return previousHash;
	}


	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	@Override
	public String toString() {
		return "Block [hash=" + hash + ", previousHash=" + previousHash + ", data=" + data + ", timestamp=" + timestamp
				+ "]";
	}


	public String calculateHash() {
		
		String calculatedHash = StringUtility.applySHA256(previousHash + Long.toString(timestamp) + data);
		return calculatedHash;		
		
	}

	public void mineBlock(int difficulty) {
		
		String targetString = new String(new char[difficulty]).replace('\0', '0');
		
		while(! hash.substring(0, difficulty).equals(targetString)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block mined successfully!" + hash);
		
	}
}
