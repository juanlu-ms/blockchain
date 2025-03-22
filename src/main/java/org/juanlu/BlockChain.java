package org.juanlu;

import com.google.gson.GsonBuilder;
import org.juanlu.domain.Block;

import java.util.ArrayList;

public class BlockChain {


    public static void main(String[] args) {
        ArrayList<Block> blockChain = new ArrayList<>();

        blockChain.add(new Block("Hi im the first block", "0"));
        blockChain.add(new Block("Yo im the second block", blockChain.get(blockChain.size() - 1).getHash()));
        blockChain.add(new Block("Hey im the third block", blockChain.get(blockChain.size() - 1).getHash()));

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockchainJson);

    }
}
