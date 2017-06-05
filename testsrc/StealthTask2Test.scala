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

  test("Calculate"){
    val order  = List("Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee")
    calcc.calculate(order)
    assert(calcc.totalCost == 10.5)
  }



}
