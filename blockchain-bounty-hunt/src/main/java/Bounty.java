import info.blockchain.api.APIException;
import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;

import java.io.IOException;
import java.util.*;

public class Bounty {

    public static final long[] TIMESTAMPS = {
            1525107600, //April 30, 2018
            1525194000, //May 1, 2018
            1525280400  //May 2, 2018
    };


    public static void main(String[] args) throws APIException, IOException {
        BlockExplorer blockExplorer = new BlockExplorer();

        Transaction tx = findBounty(blockExplorer);
        if(tx != null) {
            for(Output output : tx.getOutputs()){
                System.out.println("Get output addresses: " + output.getAddress());
            }
        }else{
            System.out.println("No transaction hash ending with 04dfa3 found");
        }
    }

    private static Transaction findBounty(BlockExplorer blockExplorer){
        List<SimpleBlock> simpleBlocks = new ArrayList<SimpleBlock>();
        try {
            for (long timestamp : TIMESTAMPS) {
                simpleBlocks.addAll(blockExplorer.getBlocks(timestamp));
            }
            System.out.println("Found " + simpleBlocks.size() + " simple blocks...\nGetting all blocks...");

            for(SimpleBlock simpleBlock : simpleBlocks) {
                Block block = blockExplorer.getBlock(simpleBlock.getHash());
                List<Transaction> transactions = block.getTransactions();

                for(Transaction tx : transactions) {
                    if(tx.getHash().endsWith("04dfa3")){
                        System.out.println("FOUND! at block height: " + block.getHeight() + " | Tx Hash: " + tx.getHash());
                        return tx;
                    }
                }
                System.out.println("Got block at height: " + block.getHeight() + " | Hash: " + block.getHash());
            }
        }catch(info.blockchain.api.APIException ex) {
            ex.printStackTrace();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
