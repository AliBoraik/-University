package itis.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import itis.Servies.APIService;
import itis.Servies.DbWorker;
import itis.Servies.SignService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.util.encoders.Hex;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockChain {

    private List<BlockModel> blockModelList = new ArrayList<>();
    private APIService apiService;
    private DbWorker dbWorker;
    private SignService signService;



    public void addToDB() {
        dbWorker.clean();

        for (int i = 0; i <blockModelList.size() ; i++) {
            dbWorker.addBlockModel(blockModelList.get(i));
        }

    }

    public BlockModel addNewBlockChain(String data, String name) throws Exception {

        String prevHash = new String(Hex.encode(signService.getHash(blockModelList.get(blockModelList.size() - 1))));

        // add new block
        BlockModel blockModel = new BlockModel();

        blockModel.setPrevhash(prevHash);

        DataModel dataModel = new DataModel(data, name);

        blockModel.setData(dataModel);

        String signature = new String(Hex.encode(signService.generateRSAPSSSignature(dataModel.toString().getBytes())));

        blockModel.setSignature(signature);

        blockModel.setPublickey(SignService.publicKey);

        // send new block to server
        apiService.sendBlock(blockModel);
        // send new block to db
        dbWorker.addBlockModel(blockModel);

        return blockModel;
    }


    public void setBlockModelList(List<BlockModel> blockModelList) {
        this.blockModelList = blockModelList;
        addToDB();
    }

}
