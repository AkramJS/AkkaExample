package com.packt.akka



import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, MustMatchers}

class CounterSpec extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with BeforeAndAfterAll
  with MustMatchers{

  override def afterAll()= TestKit.shutdownActorSystem(system)



  "Counter Actor"  should "handle GetCount message with TestProbe" in{

    val sender=TestProbe()
    val counter=system.actorOf(Props[Counter])

    sender.send(counter,Counter.Increment)

    sender.send(counter,Counter.GetCount)

    val state=sender.expectMsgType[Int]

    state must equal (1)


  }


}
