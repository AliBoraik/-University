package itis;

import itis.Model.BlockChain;
import itis.Model.BlockModel;
import itis.Servies.APIService;
import itis.Servies.DbWorker;
import itis.Servies.SignService;

import java.util.List;

public class Start {
    public static void main(String[] args) throws Exception {

        // for work to db
        DbWorker dbWorker = new DbWorker();
        // for work to server
        APIService apiService = new APIService();
        // for work to sing and hash
        SignService signService = new SignService();

        // read list blockchains
        List<BlockModel> blockModelList = List.of(apiService.getBlockChain());



        BlockChain blockChain = new BlockChain();

        blockChain.setDbWorker(dbWorker);
        blockChain.setSignService(signService);
        blockChain.setApiService(apiService);
        blockChain.setBlockModelList(blockModelList);

        new Frame(blockChain);

    }
}
