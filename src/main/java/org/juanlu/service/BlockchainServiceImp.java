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



    // Returns the Blockchain as a JSON
    public String getBlockchainJson() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    }

}
