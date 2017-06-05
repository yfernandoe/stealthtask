/**
  * Created by yogesh123 on 05-06-2017.
  */
class StealthTask2 {

  val itemDetail = Map[String, Double]("Cola"->0.50, "Coffee"->1, "Cheese Sandwich"-> 2.00, "Steak Sandwich"-> 4.50)


  var totalCost = 0.0;


  def countItems(aList: List[String]):scala.collection.mutable.Map[String, Int] = {

    val order  = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")

    var filteredList = aList.filter(x=> order.contains(x))

    val itemCount = scala.collection.mutable.HashMap[String, Int]().withDefaultValue(0)

    filteredList.foreach(item => itemCount(item) += 1 )

    return itemCount
  }


  def calculate( order :  List[String]) = {


    val itemMap = countItems(order)

    var total = 0.0
    for ((prod, count) <- itemMap){
      val tmp = count * ((itemDetail.get(prod)) match {
        case Some(x:Double) => x
        case _ => Double.MinValue
      })

      total = total +tmp
    }

    println("total in calc : "+total)

    totalCost = total
  }



}
