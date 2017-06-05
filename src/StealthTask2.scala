/**
  * Created by yogesh123 on 05-06-2017.
  */
class StealthTask2 {

  val itemDetail = Map[String, Double]("Cola"->0.50, "Coffee"->1, "Cheese Sandwich"-> 2.00, "Steak Sandwich"-> 4.50)

  val itemType = Map[String, String]("Cola"->"Cold", "Coffee"->"Hot", "Cheese Sandwich"->"Cold", "Steak Sandwich"->"Hot")
  val itemFoodType = Map[String, String]("Cola"->"Drink", "Coffee"->"Drink", "Cheese Sandwich"->"Food", "Steak Sandwich"->"Food")


  var totalCost = 0.0;
  var serviceCharge = 0.0


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


  def calculateAll( order :  List[String]) = {
    val itemMap = countItems(order)

    var total = 0.0
    var serviceCh = 0.0
    var hotFoodService = false
    var foodService = false
    for ((prod, count) <- itemMap){
      val tmp = count * ((itemDetail.get(prod)) match {
        case Some(x:Double) => x
        case _ => Double.MinValue
      })


      if ((((itemFoodType.get(prod)) match {
        case Some(x:String) => x
        case _ => ""
      }) == "Food") && (!foodService)){
        foodService = true
        if ((((itemType.get(prod)) match {
          case Some(x:String) => x
          case _ => ""
        }) == "Hot") ){
          hotFoodService = true
        }
      }
      total = total +tmp
    }
    if (hotFoodService) {
      serviceCh = ((total/100) *20)

    } else if(foodService ) {
      serviceCh = ((total/100) *10)

    }

    serviceCh = Math.round(serviceCh * 100.0) / 100.0





    if(serviceCh > 20.0 )
      serviceCh = 20.0

    total= total+serviceCh


    println("total : "+total)
    serviceCharge = serviceCh
    totalCost = total
  }






}
