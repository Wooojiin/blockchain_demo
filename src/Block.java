import java.util.Date;

public class Block {
    private String data;
    private String previousHash;
    private String hash;

    private long timeStamp;
    private int nonce;
    private String target = "00000";
    private int targetDepth = 5;

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return  "nonce= " + nonce + '\n' +
                "data= " + data + '\n' +
                "previousHash= " + previousHash + '\n' +
                "hash= " + hash + '\n';
    }

    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        newBlock();
    }

    private void newBlock() {
        while (hash == null || !hash.substring(0, targetDepth).equals(target)) {
            nonce++;
            hash = makeHashBlock();
        }
    }

    public String makeHashBlock() {
            return StringUtil.getSha256(
                    previousHash +
                            Long.toString(timeStamp) +
                            data +
                            Integer.toString(nonce)
            );
    }

    public String makeHashData(String data) {
        return StringUtil.getSha256(data);
    }
}


