package org.juanlu.domain;

import org.juanlu.utils.StringUtil;

import java.util.Date;

public class Block {

    private final String hash;
    private final String previousHash;
    private final String data;
    private final long timestamp;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return StringUtil.applySha256(previousHash + data + timestamp);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
