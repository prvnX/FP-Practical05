
import scala.io.StdIn.readLine

object inventory{

	def getProductList():List[String] = {
	
		var productList:List[String] = List();
		var input = "";
		
		while(input != "done"){
			
			input = readLine("Enter product name ('done' for finish) : ");
			
			if(input != "done"){
				productList = productList :+ input;
			}
		}
		
		productList;
	}
	
	
	def printProductList(productList:List[String]): Unit = {
	
		var index = 0;
	
		for( p <- productList){
			index = productList.indexOf(p);
			println(s"${index+1}.${p}");
		}
	}
	
	def getTotalProducts(productList:List[String]):Int = {
	
		productList.size;
	}

	def main(args : Array[String]):Unit = {
	
		var productList = getProductList();
		
		printProductList(productList);
		
		var numOfProducts = getTotalProducts(productList);
		println(s"Number of products in List : ${numOfProducts}");
	}
}
