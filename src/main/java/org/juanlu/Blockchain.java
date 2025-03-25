package org.juanlu;

import org.juanlu.service.BlockchainService;

public class Blockchain {

    public static void main(String[] args) {
        BlockchainService.getInstance().addBlock("Hi im the first block");
        BlockchainService.getInstance().addBlock("Yo im the second block");
        BlockchainService.getInstance().addBlock("Hey im the third block");

        System.out.println(BlockchainService.getInstance().getBlockchainJson());

    }
}
