package org.juanlu.domain;

import org.juanlu.utils.StringUtil;

import java.util.Date;

public class Block {

    private String hash;
    private final String previousHash;
    private final String data;
    private final long timestamp;
    private int nonce = 0;

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    // Applies SHA256 to a String and returns the result
    public String calculateHash() {
        return StringUtil.applySha256(
                previousHash
                        + data
                        + timestamp
                        + nonce);
    }

    // Increases nonce value until hash target is reached
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined: " + hash);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
