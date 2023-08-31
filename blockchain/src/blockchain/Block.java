package blockchain;
import java.util.Date;

import Util.StringUtil;

public class Block {
	
	public String hash;
	public String previousHash;
	public String data;
	private long timeStamp;

	
	public Block (String data, String previousHash) {
		
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	
	public String calculateHash() {
		String calculatedHash = StringUtil.applySha256(
				previousHash + Long.toString(timeStamp) + data );
		
		return calculatedHash;
	}
}
