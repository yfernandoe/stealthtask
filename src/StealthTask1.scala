import breeze.numerics.floor

/**
  * Created by yogesh123 on 05-06-2017.
  */
object StealthTask1 {

  def main(args: Array[String]): Unit = {

    val isItem = Set("Apple","Orange")
    val itemDetail = Map[String, Double]("Apple"->0.60, "Orange"->0.20)


    val order  = List("Apple","Orange","Apple","Orange","Apple","Apple","Orange","Apple","Apple","Orange","Apple","Orange","Apple","Apple","Orange","Apple")

    val itemCount = scala.collection.mutable.HashMap[String, Int]().withDefaultValue(0)

    val filteredItems = order.filter(x=> isItem(x))

    filteredItems.foreach(item => itemCount(item) += 1 )

    var orderAmount = 0.0

    for ((prod, count) <- itemCount){
       orderAmount = orderAmount + calculateCost(count, ((itemDetail.get(prod)) match {
        case Some(x:Double) => x
        case _ => Double.MinValue
      }))

    }


    val orderAmountWithOffer = calculateAppleWithOffer(itemCount("Apple"))+calculateOrangeWithOffer(itemCount("Orange"))

    println("all cost"+orderAmount);
    println("all cost with offer"+orderAmountWithOffer);

  }

  def calculateCost( count:  Int, cost: Double): Double = {

    return  count*cost
  }

  def calculateOrangeWithOffer( orgCount:  Int): Double = {

   //apply offer
    var offCount  = orgCount - floor(orgCount/3)

    return  0.25*offCount
  }

  def calculateAppleWithOffer( appCount:  Int): Double = {
    //apply offer
    var offCount  = appCount - floor(appCount/2)
    return .60*offCount;
  }

}
