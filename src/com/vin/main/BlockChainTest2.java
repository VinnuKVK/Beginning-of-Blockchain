package com.vin.main;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;
import com.vin.block.Block;

public class BlockChainTest2 {
	
	public static ArrayList<Block> blockChain = new ArrayList<>();
	
	public static void main(String[] args) {
		
		blockChain.add(new Block("First", "0"));
		blockChain.add(new Block("Second", blockChain.get(blockChain.size()-1).calculateHash()));
		blockChain.add(new Block("Third", blockChain.get(blockChain.size()-1).calculateHash()));
		blockChain.add(new Block("Fourth", blockChain.get(blockChain.size()-1).calculateHash()));
		
		String blockChainInJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		
		System.out.println("blockChain in normal view: \n" + blockChain);
		System.out.println();
		System.out.println("blockChain in JSON View: \n" + blockChainInJSON);
		
		System.out.println("Checking for correctness/integrity of our blockchain ");
		System.out.println("isValidBlockChain: " +isValidBlockChain(blockChain));
		
		System.out.println("=========");
		
		System.out.println("Checking for correctness/integrity of our blockchain ");
		blockChain.get(1).setHash("qwerty");
		blockChain.get(1).setPreviousHash("asdfg");
		System.out.println("isValidBlockChain: " +isValidBlockChain(blockChain));
		
	}

	private static boolean isValidBlockChain(ArrayList<Block> blockChain2) {
		
		Block currentBlock;
		Block previousBlock;
		
		for(int u=1 ; u<blockChain2.size() ; u++) {
			
			currentBlock = blockChain2.get( u );
			previousBlock = blockChain2.get( u-1 );
			
			if(! currentBlock.getHash().equals(currentBlock.calculateHash())) {
				System.out.println("SOmething fishy..! Current Hashes not equal.");
				return false;
			}
			
			if(! previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
				System.out.println("SOmething fishy..! Previous Hashes not equal.");
				return false;
			}
			
			
		}
		return true;
	}

}
