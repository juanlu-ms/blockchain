package org.juanlu.service;

import com.google.gson.GsonBuilder;
import org.juanlu.domain.Block;

import java.util.ArrayList;

public class BlockchainServiceImp implements BlockchainService {

    private static BlockchainServiceImp instance;
    private final ArrayList<Block> blockchain;

    private BlockchainServiceImp() {
        blockchain = new ArrayList<>();
    }

    // Singleton
    public static BlockchainServiceImp getInstance() {
        if (instance == null) {
            instance = new BlockchainServiceImp();
        }
        return instance;
    }

    /**
     * Adds a new block to the blockchain. The block contains the given data and links
     * to the previous block in the chain through its hash. If the blockchain is empty,
     * the block is added as the first block with a previous hash of "0".
     */
    public void addBlock(String data) {
        String previousHash = blockchain.isEmpty()
                ? "0"
                : blockchain.getLast().getHash();
        Block newBlock = new Block(data, previousHash);
        blockchain.add(newBlock);
    }

    // Checks if any block in the blockchain has been tampered with
    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        if (blockchain.size() > 1) {
            for (int i = 1; i < blockchain.size(); i++) {
                currentBlock = blockchain.get(i);
                previousBlock = blockchain.get(i - 1);
                if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                    System.out.println("Current Hashes not equal");
                    return false;
                }
                if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                    System.out.println("Previous Hashes not equal");
                    return false;
                }
            }
        }
        return true;
    }

    // Returns the Blockchain as a JSON
    public String getBlockchainJson() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    }

}
