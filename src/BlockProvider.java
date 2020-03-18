public class BlockProvider {

    public static void main(String[] args) {
        Block genesisBlock = new Block("Genesis Block", null);
        System.out.println(genesisBlock.toString());

        Block secondBlock = new Block("2nd", genesisBlock.getHash());
        System.out.println(secondBlock.toString());

        Block thirdBlock = new Block("3rd", secondBlock.getHash());
        System.out.println(thirdBlock.toString());
    }
}
