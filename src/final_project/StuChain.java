/**
 *
 * @author PRUDHVI CHINNA
 */
import final_project.Student_database;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class StuChain {
   
public static ArrayList<StuBlock> blockchain = new ArrayList<StuBlock>();
public static int difficulty = 5;
public static void main(String[] args) {	
   
System.out.println("Trying to Mine block 1 : ");
addBlock(new StuBlock("", "0"));
   for(int i=2;i<=10;i++)
   {
      System.out.println("Trying to Mine block  : " +i);
      addBlock(new StuBlock("",blockchain.get(blockchain.size()-1).hash));
   }
System.out.println("\nBlockchain is Valid: " + isChainValid());
String blockchainJson = StuHashAlgorithm.getJson(blockchain);
System.out.println("\nThe block chain: ");
System.out.println(blockchainJson);
}
public static Boolean isChainValid() {
StuBlock currentBlock; 
StuBlock previousBlock;
String hashTarget = new String(new char[difficulty]).replace('\0', '0');
for(int i=1; i < blockchain.size(); i++) {
currentBlock = blockchain.get(i);
previousBlock = blockchain.get(i-1);
if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
System.out.println("Current Hashes not equal");			
return false;
}
if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
System.out.println("Previous Hashes not equal");
return false;
}   
if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
System.out.println("This block hasn't been mined");
return false;
}		
}
return true;
}	
public static void addBlock(StuBlock newBlock) {
newBlock.mineBlock(difficulty);
blockchain.add(newBlock);
}
}

