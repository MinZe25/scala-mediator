package minze25.scalamediator
package minze25.scalamediator.example.main

import com.google.inject.Guice
import core.{IHandlerService, IMediator}
import modules.{ClassScannerModule, MediatorModule}

import net.codingwell.scalaguice.ScalaModule


object MainAppMultipleInjectors extends App {
  val injector = Guice.createInjector(new ClassScannerModule("minze25.scalamediator.handlers"), new ClassScannerModule("app.handlers"))
  val instance = injector.getInstance(classOf[IHandlerService])
  val size = instance.howManySingleHandlers
  println(s"There are $size single handlers")
  val sizeMulti = instance.howManyMultiHandlers
  println(s"There are $sizeMulti multi handlers")

}

object MainAppModulesCombine extends App {
  val injector = Guice.createInjector(new ModuleCombiner)
  val size = injector.getInstance(classOf[IHandlerService]).howManySingleHandlers
  println(s"There are $size handlers")
  val mediator = injector.getInstance(classOf[IMediator])
  println(mediator.send(GetBook()))
  println(mediator.send(GetEmployee()))
  mediator.publish(PostEmployeeCommand())
  mediator.send(PostBook())

  class ModuleCombiner extends ScalaModule {
    override def configure(): Unit = {
      install(new ClassScannerModule("app.handlers"))
      install(new ClassScannerModule("minze25.scalamediator.handlers"))
      install(new MediatorModule)
    }
  }
}
