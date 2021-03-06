package com.packt.akka

import akka.actor.Actor

class Counter extends Actor {
  import Counter._

  var count:Int=0

  override def receive: Receive = {

    case Increment => count+=1
    case Decrement => count-=1
    case GetCount => sender ! count

  }

}

object Counter{
  case object Increment
  case object Decrement
  case object GetCount
}
