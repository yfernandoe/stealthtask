/**
  * Created by yogesh123 on 05-06-2017.
  */
class StealthTask2Test extends org.scalatest.FunSuite {

  var calcc = new StealthTask2


  test("Calculate with no items"){
    val order  = List()
    calcc.calculate(order)
    assert(calcc.totalCost == 0.0)
  }

  test("Calculate with not available items"){
    val order  = List("Junk","Cola", "Stuff")
    calcc.calculate(order)
    assert(calcc.totalCost == 0.5)
  }

  test("Calculate only drinks"){
    val order  = List("Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee")
    calcc.calculate(order)
    assert(calcc.totalCost == 10.5)
  }




  test("CalculateWith Service"){
    val order  = List("Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich")
    calcc.calculateAll(order)
    assert(calcc.totalCost == 16.5)
  }




  test("Calculate With Service for hot food"){
    val order  = List("Cola","Cheese Sandwich", "Steak Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich", "Steak Sandwich","Cola", "Steak Sandwich","Cheese Sandwich","Cola", "Steak Sandwich","Cheese Sandwich","Cola","Cheese Sandwich")
    calcc.calculateAll(order)
    assert(calcc.serviceCharge == 6.60)
  }

  test("Calculate With Service > 20"){
    val order  = List("Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich"
    )
    calcc.calculateAll(order)
    assert(calcc.serviceCharge == 20.0)
  }



}
