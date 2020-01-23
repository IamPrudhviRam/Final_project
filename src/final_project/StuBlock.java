 /**
 *
 * @author PRUDHVI CHINNA
 */

import final_project.Student_database;
import java.sql.*;
import java.util.Date;

public class StuBlock {
public String hash;
public String previousHash; 
private String data; 
private long timeStamp; 
private int nonce;

public StuBlock(String data,String previousHash) {
this.data = data;
this.previousHash = previousHash;
this.timeStamp = new Date().getTime();	
this.hash = calculateHash(); 
Student_database d = new Student_database();
this.data = String.valueOf(d);
}              

public String calculateHash() {
String calculatedhash = StuHashAlgorithm.applySha256
        ( previousHash+Long.toString(timeStamp)
          +Integer.toString(nonce)+ data);
return calculatedhash;
}              	

public void mineBlock(int difficulty) {
String target =StuHashAlgorithm.getDificultyString(difficulty); 
while(!hash.substring(0,difficulty).equals(target))
{nonce ++;
hash = calculateHash();
}
System.out.println("Block Mined : " + hash);
}
}   
