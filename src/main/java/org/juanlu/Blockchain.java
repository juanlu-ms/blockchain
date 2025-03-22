package org.juanlu;

import org.juanlu.service.BlockchainService;
import org.juanlu.service.BlockchainServiceImp;

public class Blockchain {


    public static void main(String[] args) {
        BlockchainService blockChainService = BlockchainServiceImp.getInstance();

        blockChainService.addBlock("Hi im the first block");
        blockChainService.addBlock("Yo im the second block");
        blockChainService.addBlock("Hey im the third block");

        System.out.println(blockChainService.getBlockchainJson());

    }
}
