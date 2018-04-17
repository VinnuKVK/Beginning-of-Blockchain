package com.vin.main;

import com.vin.block.Block;

public class BlockChainTest {
	
	public static void main(String[] args) {
		
		Block genesisBlock = new Block("I am the first Block", "0");
		System.out.println("Hash for Block 1: " + genesisBlock.calculateHash());
		
		Block secondBlock = new Block("Second Block", genesisBlock.calculateHash());
		System.out.println("Hash for Block 2: " + secondBlock.calculateHash());
		
		Block thirdBlock = new Block("Second Block", secondBlock.calculateHash());
		System.out.println("Hash for Block 3: " + thirdBlock.calculateHash());
		
		
	}

}
